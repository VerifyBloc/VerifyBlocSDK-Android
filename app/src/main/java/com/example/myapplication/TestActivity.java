package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import network.mintex.module_kyc.entity.ui.style.VerifyBlocStyle;
import network.mintex.module_kyc.export.VerifyBlocManager;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initListener();
    }

    private void initListener(){
        findViewById(R.id.btn_start_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = ((EditText)findViewById(R.id.et_user_name)).getText().toString();
                if (userId.isEmpty()){
                    Toast.makeText(TestActivity.this, "Please input user name", Toast.LENGTH_LONG).show();
                }else {
                    VerifyBlocManager.INSTANCE.updateStyle(VerifyBlocStyle.DARK);
                    VerifyBlocManager.INSTANCE.verify(TestActivity.this, userId);
                }
            }
        });
    }
}