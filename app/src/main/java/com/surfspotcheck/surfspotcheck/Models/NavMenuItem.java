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
        item.image = R.mipmap.icon_mares;
        item.position = 2;

        nav.add(item);

        item = new NavMenuItem();
        item.name = "Previsão do Tempo";
        item.position = 3;
        item.image = R.mipmap.icon_clima_tempo;
        nav.add(item);

        item = new NavMenuItem();
        item.name = "Picos";
        item.image = R.mipmap.icon_picos;
        item.position = 4;
        nav.add(item);

        return nav;
    }
}
