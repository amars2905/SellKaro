package com.sell.sellkaro.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.sell.sellkaro.R;
import com.sell.sellkaro.utils.Alerts;

import java.util.Arrays;


public class LoginSetUpActivity extends AppCompatActivity implements View.OnClickListener {
    String TAG = "LoginSetUpActivity";
    private static final String EMAIL = "email";
    Button btnLogin, btnEmail, btnFb;

    private AccessTokenTracker accessTokenTracker;
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private Context mContext;
    private GoogleSignInClient mGoogleSignInClient;
    private final int RC_SIGN_IN = 1293;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_set_up);
        mContext = this;

        init();
        initFacebook();
        initGoogleIntegration();
    }

    private void init() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnFb = (Button) findViewById(R.id.btnFb);

        btnLogin.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnFb.setOnClickListener(this);
        findViewById(R.id.btnGoogle).setOnClickListener(this);
        findViewById(R.id.btnLogout).setOnClickListener(this);
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // Set the access token using
                // currentAccessToken when it's loaded or set.
            }
        };
        // If the access token is available already assign it.
        //accessToken = AccessToken.getCurrentAccessToken();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        LoginManager.getInstance().logOut();
        loginButton.setReadPermissions(Arrays.asList(EMAIL));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            private ProfileTracker mProfileTracker;

            @Override
            public void onSuccess(LoginResult loginResult) {
                if (Profile.getCurrentProfile() == null) {
                    mProfileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                            Log.e("facebook - profile", currentProfile.getFirstName());
                            String strName = currentProfile.getFirstName();
                            String strUsername = currentProfile.getFirstName();
                            Alerts.show(mContext, strName);
                            mProfileTracker.stopTracking();
                        }
                    };
                } else {
                    Profile profile = Profile.getCurrentProfile();
                    Log.e("facebook - profile", profile.getFirstName());
                    String strName = profile.getFirstName();
                    String strUsername = profile.getFirstName();
                    Alerts.show(mContext, strName);
                }
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    private void initGoogleIntegration() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(this);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //updateUI(account);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (callbackManager.onActivityResult(requestCode, resultCode, data)) {
            return;
        }

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task);
        }
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Alerts.show(mContext, account.getEmail());
            findViewById(R.id.btnLogout).setVisibility(View.VISIBLE);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEmail:
                Intent iEmail = new Intent(LoginSetUpActivity.this, SignUpWithEmail.class);
                startActivity(iEmail);
                break;
            case R.id.btnLogin:
                Intent i = new Intent(LoginSetUpActivity.this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.sign_in_button:
            case R.id.btnGoogle:
                signIn();
                break;
            case R.id.btnFb:
                loginButton.performClick();
                break;
            case R.id.btnLogout:
                findViewById(R.id.btnLogout).setVisibility(View.GONE);
                mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Alerts.show(mContext, task.toString());
                    }
                });
                break;
        }
    }
}
