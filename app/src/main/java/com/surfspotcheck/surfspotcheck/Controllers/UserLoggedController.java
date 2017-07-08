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
        try{
            this.context = _context;
            this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        catch (Exception e){
            String teste = e.toString();
        }
    }

    public void SetId(long id_user)
    {
        try
        {
            RemoveId();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putLong("id_user", id_user);
            editor.commit();
        }
        catch(Exception e){}
    }

    public void RemoveId()
    {
        try
        {
            if(GetId() != 0)
            {
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("id_user");
                editor.commit();
            }
        }
        catch(Exception e){}
    }

    public long GetId()
    {
        try
        {
            return preferences.getLong("id_user", 0);
    }
        catch (Exception e){return 0;}
    }
}
