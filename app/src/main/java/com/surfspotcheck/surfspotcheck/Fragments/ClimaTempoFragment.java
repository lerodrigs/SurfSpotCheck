package com.surfspotcheck.surfspotcheck.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.surfspotcheck.surfspotcheck.Adapters.ClimaTempoTodayAdapter;
import com.surfspotcheck.surfspotcheck.Adapters.ListaClimaTempoAdapter;
import com.surfspotcheck.surfspotcheck.Models.*;
import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.Controllers.ClimaTempoController;
import com.surfspotcheck.surfspotcheck.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ClimaTempoFragment extends Fragment {

    //SwipeRefreshLayout refreshLayout;
    static RelativeLayout relativeLayout;
    static List<ClimaTempo> list;
    static ProgressBar progressBar;
    static ListView listView;
    static android.app.Activity context;
    static RelativeLayout rel_progress_bar;

    public static ClimaTempoFragment NewInstance()
    {
        ClimaTempoFragment fragment = new ClimaTempoFragment();
        fragment.setArguments(new Bundle());

        list = new ArrayList<ClimaTempo>();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        context = this.getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Main.toolbar.setTitle("Previsão do Tempo");
        return inflater.inflate(R.layout.fragment_clima_tempo, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        relativeLayout = (RelativeLayout) view.findViewById(R.id.rel_clima_tempo);

        rel_progress_bar = (RelativeLayout) view.findViewById(R.id.rel_progress_bar);

        /*refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresher);
        //refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });*/

        listView = (ListView) view.findViewById(R.id.listview);
        listView.setItemsCanFocus(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

            }
        });

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

    public static List<ClimaTempo> getListClimaTempo(final Date date)
    {
        try
        {
            SetVisibilityProgressBar(true);

            Thread thread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {

                    List<ClimaTempo> _list = new ClimaTempoController().getToday(date);
                    ClimaTempo climaTempoToday = null;

                    Calendar calendar = Calendar.getInstance();
                    Date hoje = calendar.getTime();

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
            });

            thread.start();
        }
        catch (Exception e){ }

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
