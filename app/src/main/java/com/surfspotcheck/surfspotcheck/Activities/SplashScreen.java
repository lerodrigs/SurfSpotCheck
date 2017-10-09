package com.surfspotcheck.surfspotcheck.Activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;

import com.surfspotcheck.surfspotcheck.Controllers.LocationController;
import com.surfspotcheck.surfspotcheck.Controllers.UserLoggedController;
import com.surfspotcheck.surfspotcheck.R;

public class SplashScreen extends Activity {

    public static Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        context = this;
        IsLogged();
    }

    public void IsLogged()
    {
        Thread threading = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                UserLoggedController userLogged = new UserLoggedController(context);
                Intent intent = null;

                if(userLogged.GetId() == 0 )
                {
                    intent = new Intent(context, Login.class);
                }
                else
                {
                    intent = new Intent(context, Main.class);
                }

                startActivity(intent);
                finish();
            }
        });

        threading.start();
    }
}
