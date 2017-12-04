package com.surfspotcheck.surfspotcheck.Controllers;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by chibs on 03/12/17.
 */

public class SharedPreferencesController
{
    SharedPreferences sharedPreferences;
    Activity context;

    public SharedPreferencesController(Activity context )
    {
        this.context = context;
        this.sharedPreferences = this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void SetKey(String key, String value)
    {
        try
        {
            if(getKey(key) != null)
            {
                RemoveKey(key);
            }

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.commit();
        }
        catch (Exception e )
        {
            e.getMessage();
        }
    }

    public String getKey(String key)
    {
        try
        {
            return sharedPreferences.getString(key, null);
        }
        catch (Exception e )
        {
            return null;
        }
    }

    public void RemoveKey(String key)
    {
        try
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(key);
            editor.commit();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
