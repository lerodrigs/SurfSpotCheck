package com.surfspotcheck.surfspotcheck.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.surfspotcheck.surfspotcheck.R;

public class ForgotPassword extends AppCompatActivity {

    TextView voltar;
    Button btnResetPass;
    EditText txt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnResetPass = (Button) findViewById(R.id.btnResetPass);
        voltar = (TextView) findViewById(R.id.txt_voltar);
        txt_email = (EditText) findViewById(R.id.txt_email);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
