package com.surfspotcheck.surfspotcheck.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.R;

public class Pico extends Fragment {

    public Pico()
    {
    }

    public static Pico newInstance()
    {
        Pico fragment = new Pico();
        fragment.setArguments(new Bundle());

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Main.toolbar.setTitle("Picos");
        return inflater.inflate(R.layout.fragment_pico, container, false);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }
}
