package com.sell.karo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sell.karo.R;
import com.sell.karo.views.CustomTextViewSbold;


public class MyProfileActivity extends AppCompatActivity {
    CustomTextViewSbold editProfile , editSetting , editOffersMade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        editProfile = (CustomTextViewSbold)findViewById(R.id.editProfile);
        editSetting = (CustomTextViewSbold)findViewById(R.id.editSetting);
        editOffersMade = (CustomTextViewSbold)findViewById(R.id.editOffersMade);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });

        editSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        editOffersMade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this, MyoffersActivity.class);
                startActivity(intent);
            }
        });


    }
}
