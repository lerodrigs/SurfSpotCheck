package com.surfspotcheck.surfspotcheck.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.surfspotcheck.surfspotcheck.R;

public class Login extends AppCompatActivity {

    Button buttonFacebook;
    Button buttonInstagram;
    TextView entre_email;
    TextView cadastro;
    AlertDialog alertDialog;
    AppCompatActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;

        buttonFacebook = (Button) findViewById(R.id.btnLoginFacebook);
        buttonInstagram = (Button) findViewById(R.id.btnLoginInstagram);
        entre_email = (TextView) findViewById(R.id.login_com_email);
        cadastro = (TextView) findViewById(R.id.register);

        buttonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickBtnFacebook();
            }
        });
        buttonInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickBtnInstagram();
            }
        });
        entre_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginEmail();
            }
        });
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });


    }

    public void ClickBtnFacebook()
    {
        Thread facebook = new Thread(new Runnable() {
            @Override
            public void run() {
                DialogLoader();
            }
        });

        facebook.start();
    }

    public void ClickBtnInstagram()
    {
        Thread instagram = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        instagram.start();
    }

    public void LoginEmail()
    {
        try
        {
            Intent intent = new Intent(this, LoginEmail.class);
            startActivity(intent);
        }
        catch (Exception e){}
    }

    public void Register()
    {
        try
        {
            Intent register = new Intent(this, Register.class);
            startActivity(register);
        }
        catch (Exception e){}
    }

    public void DialogLoader()
    {
        try
        {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View view = context.getLayoutInflater().inflate(R.layout.view_loader, null);

                    builder.setView(view);
                    alertDialog = builder.create();

                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    alertDialog.show();
                }
            });

        }
        catch (Exception e){}
    }
}
