package com.surfspotcheck.surfspotcheck.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import com.surfspotcheck.surfspotcheck.Adapters.DialogLoaderAdapter;
import com.surfspotcheck.surfspotcheck.R;

import java.sql.Timestamp;

public class Login extends AppCompatActivity {

    Button buttonFacebook;
    Button buttonInstagram;
    TextView entre_email;
    TextView cadastro;
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
            public void run()
            {
                DialogLoaderAdapter.Loader(context);
                DialogLoaderAdapter.Show(context, true);

                DialogLoaderAdapter.Show(context, false);
                Intent main = new Intent(context, Main.class);
                startActivity(main);
            }
        });

        facebook.start();
    }

    public void ClickBtnInstagram()
    {
        Thread instagram = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                DialogLoaderAdapter.Loader(context);
                DialogLoaderAdapter.Show(context, true);

                DialogLoaderAdapter.Show(context, false);
                Intent main = new Intent(context, Main.class);
                startActivity(main);
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
}
