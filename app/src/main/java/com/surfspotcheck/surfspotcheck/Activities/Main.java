package com.surfspotcheck.surfspotcheck.Activities;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.surfspotcheck.surfspotcheck.Adapters.NavItemAdapter;
import com.surfspotcheck.surfspotcheck.Fragments.ClimaTempoFragment;
import com.surfspotcheck.surfspotcheck.Fragments.HomeFragment;
import com.surfspotcheck.surfspotcheck.Fragments.MareFragment;
import com.surfspotcheck.surfspotcheck.Fragments.PicoFragment;
import com.surfspotcheck.surfspotcheck.Models.NavMenuItem;
import com.surfspotcheck.surfspotcheck.R;

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
        toolbar.setTitle("HomeFragment");
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
