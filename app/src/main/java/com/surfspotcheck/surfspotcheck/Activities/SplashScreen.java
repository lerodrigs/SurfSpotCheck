package com.surfspotcheck.surfspotcheck.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.surfspotcheck.surfspotcheck.Controllers.UserLoggedController;
import com.surfspotcheck.surfspotcheck.R;

public class SplashScreen extends Activity {

    public static Activity context;

    int MY_PERMISSION_ACCESS_FILE_LOCATION = 1;
    int MY_PERMISSION_ACCESS_COARSE_LOCATION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);

            context = this;
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
                    Intent intent;

                    if(userLogged.getUserLogged())
                        intent = new Intent(context, Main.class);
                    else
                        intent = new Intent(context, Login.class);

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
