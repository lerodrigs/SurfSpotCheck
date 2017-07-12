package com.surfspotcheck.surfspotcheck.Activities;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.widget.ListView;
import com.surfspotcheck.surfspotcheck.Adapters.NavItemAdapter;
import com.surfspotcheck.surfspotcheck.Models.NavMenuItem;
import com.surfspotcheck.surfspotcheck.R;

import java.util.List;

public class Main extends AppCompatActivity {

    ListView  nav_menu;
    DrawerLayout drawerLayout;
    NavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toogle);
        toogle.syncState();

    }

    private List<NavMenuItem> getNavMenu()
    {
        NavMenuItem navItem = new NavMenuItem();
        return navItem.getItems();
    }
}
