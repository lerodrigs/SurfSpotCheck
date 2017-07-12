package com.surfspotcheck.surfspotcheck.Models;

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

        item.position = 1;
        item.name = "Home";
        nav.add(item);

        item.position = 2;
        item.name = "Mares";
        nav.add(item);

        item.position = 3;
        item.name = "Picos";

        return nav;
    }
}
