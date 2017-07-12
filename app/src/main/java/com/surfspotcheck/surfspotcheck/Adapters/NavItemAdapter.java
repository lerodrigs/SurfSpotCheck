package com.surfspotcheck.surfspotcheck.Adapters;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.surfspotcheck.surfspotcheck.Models.NavMenuItem;
import com.surfspotcheck.surfspotcheck.R;

import java.util.List;

/**
 * Created by lerodrigs on 7/10/2017.
 */

public class NavItemAdapter extends BaseAdapter {

    List<NavMenuItem> items;
    Activity context;

    public NavItemAdapter(Activity _context, List<NavMenuItem> _items){
        this.items = _items;
        this.context = _context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public NavMenuItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {

        NavMenuItem navItem = null;

        if((navItem = items.get(position)) != null){
            return navItem.position;
        }
        else {
          return 0;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        NavMenuItem navItem = items.get(position);

        if(view == null)
        {
            view = context.getLayoutInflater().inflate(R.layout.nav_item_row, null);
        }

        TextView nome = (TextView) view.findViewById(R.id.nome);
        nome.setText(navItem.name);

        return view;
    }

    public void Update(){
        this.notifyDataSetChanged();
    }


}
