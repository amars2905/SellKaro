package com.sell.karo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.sell.karo.R;
import com.sell.karo.utils.Alerts;

import java.util.Arrays;


public class LoginSetUpActivity extends AppCompatActivity {
    String TAG = "LoginSetUpActivity";
    private static final String EMAIL = "email";
    Button btnLogin, btnEmail, btnFb;

    private AccessTokenTracker accessTokenTracker;
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_set_up);
        mContext=this;
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginSetUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginSetUpActivity.this, SignUpWithEmail.class);
                startActivity(i);
            }
        });

        btnFb = (Button) findViewById(R.id.btnFb);
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        initFacebook();
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
                            Alerts.show(mContext,strName);
                            mProfileTracker.stopTracking();
                        }
                    };
                } else {
                    Profile profile = Profile.getCurrentProfile();
                    Log.e("facebook - profile", profile.getFirstName());
                    String strName = profile.getFirstName();
                    String strUsername = profile.getFirstName();
                    Alerts.show(mContext,strName);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (callbackManager.onActivityResult(requestCode, resultCode, data)) {
            return;
        }
    }

}
