package com.surfspotcheck.surfspotcheck.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.R;

public class ClimaTempo extends Fragment {

    SwipeRefreshLayout refreshLayout;
    ProgressBar progressBar;
    android.app.Activity context;

    public static ClimaTempo NewInstance()
    {
        ClimaTempo fragment = new ClimaTempo();
        fragment.setArguments(new Bundle());

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        context = this.getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Main.toolbar.setTitle("Clima tempo");
        return inflater.inflate(R.layout.fragment_clima_tempo, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresher);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(){

            }
        });

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);

        SetVisibilityProgressBar(false);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

    public void SetVisibilityProgressBar(final boolean visible)
    {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                if(visible)
                    progressBar.setVisibility(View.VISIBLE);
                else
                    progressBar.setVisibility(View.GONE);
            }
        });
    }

}
