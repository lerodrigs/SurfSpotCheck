package com.surfspotcheck.surfspotcheck.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.R;

public class ClimaTempo extends Fragment {

    public ClimaTempo(){}

    public static ClimaTempo NewInstance()
    {
        ClimaTempo fragment = new ClimaTempo();
        fragment.setArguments(new Bundle());

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Main.toolbar.setTitle("Clima tempo");
        return inflater.inflate(R.layout.fragment_clima_tempo, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

}
