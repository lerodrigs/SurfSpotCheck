package com.surfspotcheck.surfspotcheck.Activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.util.Log;

import com.surfspotcheck.surfspotcheck.Controllers.LocationController;
import com.surfspotcheck.surfspotcheck.Controllers.UserLoggedController;
import com.surfspotcheck.surfspotcheck.R;

public class SplashScreen extends Activity {

    public static Activity context;

    AlertDialog alertDialog;
    LocationController locationController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        context = this;
        alertDialog = null;

        try
        {
            IsLogged();
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();

        try
        {
            IsLogged();
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }

    public void IsLogged()
    {
        try
        {
            Thread threading = new Thread(new Runnable()
            {
                @Override
                public void run()
                {

                    UserLoggedController userLogged = new UserLoggedController(context);
                    Intent intent = null;

                    if(userLogged.getUserLogged() != null )
                        intent = new Intent(context, Login.class);
                    else
                        intent = new Intent(context, Main.class);

                    startActivity(intent);
                    finish();
                }
            });

            threading.start();
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }
}
