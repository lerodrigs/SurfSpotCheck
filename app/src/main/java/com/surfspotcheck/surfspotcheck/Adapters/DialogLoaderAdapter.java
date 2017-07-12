package com.surfspotcheck.surfspotcheck.Adapters;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.surfspotcheck.surfspotcheck.R;

/**
 * Created by lerodrigs on 7/11/2017.
 */

public class DialogLoaderAdapter
{
    private static AlertDialog alertDialog;
    private static AlertDialog.Builder builder;

    public static void Loader(final Activity context)
    {
        try
        {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    builder = new AlertDialog.Builder(context);

                    View view = context.getLayoutInflater().inflate(R.layout.view_loader, null);
                    builder.setView(view);

                    alertDialog = builder.create();
                    alertDialog.setCancelable(false);
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
            });
        }
        catch (Exception e){}
    }

    public static void Show(Activity context, final boolean visible)
    {
        try
        {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(visible)
                        alertDialog.show();
                    else
                        alertDialog.dismiss();
                }
            });
        }
        catch (Exception e){}
    }
}
