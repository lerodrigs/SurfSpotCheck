package com.surfspotcheck.surfspotcheck.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.Controllers.ClimaTempoController;
import com.surfspotcheck.surfspotcheck.R;

public class HomeFragment extends Fragment {

    public HomeFragment()
    {
        // Required empty public constructor
    }

    public static HomeFragment newInstance()
    {
        HomeFragment fragment = new HomeFragment();
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
        Main.toolbar.setTitle("HomeFragment");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        ClimaTempoController controller = new ClimaTempoController();
        controller.getToday();

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }
}
