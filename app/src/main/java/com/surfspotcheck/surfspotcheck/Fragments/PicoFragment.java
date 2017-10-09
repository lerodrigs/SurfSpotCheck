package com.surfspotcheck.surfspotcheck.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.R;

public class PicoFragment extends Fragment {

    public PicoFragment()
    {
    }

    public static PicoFragment newInstance()
    {
        PicoFragment fragment = new PicoFragment();
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
