package com.surfspotcheck.surfspotcheck.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.surfspotcheck.surfspotcheck.R;

public class LoginEmail extends AppCompatActivity {

    TextView txt_email;
    TextView txt_pass;
    TextView forgot_pass;
    Button btnLogin;
    AppCompatActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_email);

        context = this;

        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_pass = (TextView) findViewById(R.id.txt_pass);
        forgot_pass = (TextView) findViewById(R.id.txt_forgot_pass);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent forgot = new Intent(context, ForgotPassword.class);
                startActivity(forgot);
            }
        });
    }
}
