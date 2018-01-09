package com.surfspotcheck.surfspotcheck.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.surfspotcheck.surfspotcheck.Adapters.ClimaTempoTodayAdapter;
import com.surfspotcheck.surfspotcheck.Adapters.ListaClimaTempoAdapter;
import com.surfspotcheck.surfspotcheck.Controllers.LocationController;
import com.surfspotcheck.surfspotcheck.Models.*;
import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.Controllers.ClimaTempoController;
import com.surfspotcheck.surfspotcheck.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ClimaTempoFragment extends Fragment {

    static RelativeLayout relativeLayout;
    static List<ClimaTempo> list;
    static ProgressBar progressBar;
    static ListView listView;
    static android.app.Activity context;
    static RelativeLayout rel_progress_bar;
    static LocationMyModel locationMyModel;
    static LocationController locationController;

    public static ClimaTempoFragment NewInstance()
    {
        try
        {
            ClimaTempoFragment fragment = new ClimaTempoFragment();
            fragment.setArguments(new Bundle());

            context = Main.context;

            list = new ArrayList<ClimaTempo>();
            locationController = new LocationController(context);

            return fragment;
        }
        catch (Exception e )
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        context = this.getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Main.toolbar.setTitle("Previsão do Tempo");
        return inflater.inflate(R.layout.fragment_clima_tempo, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        getLocationMyModel();

        relativeLayout = (RelativeLayout) view.findViewById(R.id.rel_clima_tempo);
        rel_progress_bar = (RelativeLayout) view.findViewById(R.id.rel_progress_bar);

        listView = (ListView) view.findViewById(R.id.listview);
        listView.setItemsCanFocus(false);

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        getListClimaTempo(null);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

    public static void SetVisibilityProgressBar(final boolean visible)
    {
        try
        {
            context.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    if (visible)
                    {
                        rel_progress_bar.setVisibility(View.VISIBLE);
                        relativeLayout.setVisibility(View.GONE);
                    }
                    else
                    {
                        relativeLayout.setVisibility(View.VISIBLE);
                        rel_progress_bar.setVisibility(View.GONE);
                    }

                }
            });
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }

    public static LocationMyModel getLocationMyModel()
    {
        try
        {
            locationMyModel = locationController.getLastLocation();
            return locationMyModel;
        }
        catch (Exception e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public static List<ClimaTempo> getListClimaTempo(final Date date)
    {
        SetVisibilityProgressBar(true);

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    ClimaTempoController climaTempoContorller = new ClimaTempoController(context);

                    List<ClimaTempo> _list = climaTempoContorller.getToday(date, locationMyModel);
                    ClimaTempo climaTempoToday = null;

                    Calendar calendar = Calendar.getInstance();
                    Date hoje = null;

                    if(date == null)
                        hoje = calendar.getTime();
                    else
                        hoje = date;

                    for (ClimaTempo obj: _list )
                    {
                        Date data = obj.getData();

                        if(data.getDate() == hoje.getDate())
                        {
                            climaTempoToday = obj;
                        }
                    }

                    if(climaTempoToday != null)
                    {
                        ClimaTempoTodayAdapter climaTempoTodayAdapter = new ClimaTempoTodayAdapter(context, climaTempoToday, relativeLayout);

                        climaTempoTodayAdapter.UpdateClimaTempoItem();
                        _list.remove(climaTempoToday);
                    }

                    setList(_list);
                    UpdateListView();
                    SetVisibilityProgressBar(false);
                }
                catch (Exception e )
                {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        return getList();
    }

    public static void UpdateListView()
    {
        try
        {
            context.runOnUiThread(new Runnable()
            {
                @Override
                public void run() {

                    ListaClimaTempoAdapter adapter = (ListaClimaTempoAdapter) listView.getAdapter();

                    if(adapter == null)
                    {
                        adapter = new ListaClimaTempoAdapter(context, getList());
                        listView.setAdapter(adapter);
                    }

                    adapter.Update();
                }
            });
        }
        catch (Exception e){}
    }

    public static void setList(List<ClimaTempo> _list)
    {
        list = _list;
    }

    public static List<ClimaTempo> getList()
    {
        if(list == null)
        {
            list = new ArrayList<ClimaTempo>();
        }

        return list;
    }
}
