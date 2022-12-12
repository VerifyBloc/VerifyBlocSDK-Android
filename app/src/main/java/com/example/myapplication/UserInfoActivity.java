package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import network.mintex.module_kyc.export.VerifyBlocManager;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initParams();
                goTestActivity();
            }
        });
    }

    private void goTestActivity(){
        startActivity(new Intent(this, TestActivity.class));
    }

    private void initParams(){
        String partnerId = ((EditText)findViewById(R.id.et_partner_id)).getText().toString();
        String appId = ((EditText)findViewById(R.id.et_app_id)).getText().toString();
        String privateKey = ((EditText)findViewById(R.id.et_private_key)).getText().toString();
        VerifyBlocManager.INSTANCE.config(partnerId, appId, privateKey);
    }
}