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

public class Mare extends Fragment {

    public Mare()
    {
        // Required empty public constructor
    }

    public static Mare newInstance()
    {
        Mare fragment = new Mare();
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
        Main.toolbar.setTitle("Maré");
        return inflater.inflate(R.layout.fragment_mare, container, false);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }
}
