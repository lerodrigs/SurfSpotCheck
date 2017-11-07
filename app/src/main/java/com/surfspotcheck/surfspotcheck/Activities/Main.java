package com.surfspotcheck.surfspotcheck.Activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;

import com.surfspotcheck.surfspotcheck.Adapters.NavItemAdapter;
import com.surfspotcheck.surfspotcheck.Fragments.ClimaTempoFragment;
import com.surfspotcheck.surfspotcheck.Fragments.HomeFragment;
import com.surfspotcheck.surfspotcheck.Fragments.MareFragment;
import com.surfspotcheck.surfspotcheck.Fragments.PicoFragment;
import com.surfspotcheck.surfspotcheck.Models.NavMenuItem;
import com.surfspotcheck.surfspotcheck.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main extends AppCompatActivity {

    ListView  listview;
    DrawerLayout drawerLayout;
    FloatingActionButton fab;
    public static Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toogle);
        toogle.syncState();

        NavigationView nav = (NavigationView) findViewById(R.id.nav_view);

        NavItemAdapter adapter = new NavItemAdapter(this, getNavMenu());
        listview = (ListView) nav.findViewById(R.id.listview_menu);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemListViewClick((int)id);
            }
        });

        itemListViewClick(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        menu.findItem(R.id.calendario).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                showDialog(1); //Mostra dialog datePicker

                return false;
            }
        });

        /*for(int i = 0; i < menu.size(); i++){

            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(R.color.branco), PorterDuff.Mode.SRC_ATOP);
            }
        }*/

        return true;
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        if(id == 1)
        {
            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(this, myDateListener, year, month+1, day);
        }

        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker arg0, int ano, int mes, int day)
        {
            Calendar calendar = Calendar.getInstance();

            calendar.set(ano, mes, day);
            final Date escolhida = calendar.getTime();

            Thread novaData = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    ClimaTempoFragment.getListClimaTempo(escolhida);
                }
            });
            novaData.start();
        }
    };

    public void itemListViewClick(int id)
    {
        try
        {
            android.support.v4.app.Fragment fragment = null;

            switch (id)
            {
                case 1:
                    fragment = HomeFragment.newInstance();
                    break;
                case 2:
                    fragment = MareFragment.newInstance();
                    break;
                case 3:
                    fragment = ClimaTempoFragment.NewInstance();
                    break;
                case 4:
                    fragment = PicoFragment.newInstance();
                    break;
            }

             getSupportFragmentManager().beginTransaction()
                     .replace(R.id.contentMain, fragment)
                     .commit();

            drawerLayout.closeDrawer(GravityCompat.START, true);
        }
        catch (Exception e )
        {}
    }

    private List<NavMenuItem> getNavMenu()
    {
        NavMenuItem navItem = new NavMenuItem();
        return navItem.getItems();
    }
}
