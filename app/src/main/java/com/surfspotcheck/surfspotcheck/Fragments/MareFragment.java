package com.surfspotcheck.surfspotcheck.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.R;

public class MareFragment extends Fragment {

    public MareFragment()
    {
        // Required empty public constructor
    }

    public static MareFragment newInstance()
    {
        MareFragment fragment = new MareFragment();
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
