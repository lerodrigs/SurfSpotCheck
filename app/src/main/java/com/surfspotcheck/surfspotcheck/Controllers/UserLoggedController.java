package com.surfspotcheck.surfspotcheck.Controllers;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserLoggedController
{
    SharedPreferences preferences;
    Activity context;

    public UserLoggedController(Activity _context)
    {
        try
        {
            this.context = _context;
            this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        catch (Exception e)
        {
            String teste = e.toString();
        }
    }

    public Boolean getUserLogged()
    {
        return true;
    }

    public void removeUserLogged()
    {
        try
        {

        }
        catch(Exception e){}
    }

    public void InsertUserLogged()
    {
        try
        {

        }
        catch (Exception e){ }
    }

    public void UpdateUserLogged()
    {

    }
}
