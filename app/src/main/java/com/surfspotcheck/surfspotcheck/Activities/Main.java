package com.surfspotcheck.surfspotcheck.Activities;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.surfspotcheck.surfspotcheck.Adapters.NavItemAdapter;
import com.surfspotcheck.surfspotcheck.Fragments.Home;
import com.surfspotcheck.surfspotcheck.Fragments.Mare;
import com.surfspotcheck.surfspotcheck.Fragments.Pico;
import com.surfspotcheck.surfspotcheck.Models.NavMenuItem;
import com.surfspotcheck.surfspotcheck.R;

import java.util.List;

public class Main extends AppCompatActivity {

    ListView  listview;
    DrawerLayout drawerLayout;
    public static Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toogle);
        toogle.syncState();

        NavigationView nav = (NavigationView) findViewById(R.id.nav_view);

        NavItemAdapter adapter = new NavItemAdapter(this, getNavMenu());
        listview = (ListView) nav.findViewById(R.id.listview_menu);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemListViewClick(parent, view, position,(int) id);
            }
        });

    }

    public void itemListViewClick(AdapterView<?> parent, View view, int position, int id)
    {
        try
        {
            android.support.v4.app.Fragment fragment = null;

            switch (id)
            {
                case 1:
                    fragment = Home.newInstance();
                    break;
                case 2:
                    fragment = Mare.newInstance();
                    break;
                case 3:
                    fragment = Pico.newInstance();
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
