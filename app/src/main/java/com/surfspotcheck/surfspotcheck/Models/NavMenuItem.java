package com.surfspotcheck.surfspotcheck.Models;

import com.surfspotcheck.surfspotcheck.R;

import java.util.ArrayList;
import java.util.List;

public class NavMenuItem
{
    public NavMenuItem()
    {
        this.position = 0;
        this.name = "";
    }

    public int position;
    public String name;
    public int image;

    public List<NavMenuItem> getItems()
    {
        List<NavMenuItem> nav = new ArrayList<NavMenuItem>();
        NavMenuItem item = new NavMenuItem();

        item.name = "Home";
        item.position = 1;
        item.image = R.mipmap.home;
        nav.add(item);

        item = new NavMenuItem();
        item.name = "Maré";
        item.position = 2;

        nav.add(item);

        item = new NavMenuItem();
        item.name = "Clima tempo";
        item.position = 3;
        nav.add(item);

        item = new NavMenuItem();
        item.name = "Picos";
        item.position = 4;
        nav.add(item);

        return nav;
    }
}
