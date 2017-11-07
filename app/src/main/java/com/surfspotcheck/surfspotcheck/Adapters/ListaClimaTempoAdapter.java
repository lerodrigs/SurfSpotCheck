package com.surfspotcheck.surfspotcheck.Adapters;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.surfspotcheck.surfspotcheck.Models.ClimaTempo;
import com.surfspotcheck.surfspotcheck.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaClimaTempoAdapter extends BaseAdapter {

    List<ClimaTempo> items;
    Activity context;

    public ListaClimaTempoAdapter(Activity _context, List<ClimaTempo> _items)
    {
        this.items = _items;
        this.context = _context;
    }

    @Override
    public int getCount(){
        return items.size();
    }

    @Override
    public ClimaTempo getItem(int position ){
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {

        ClimaTempo item = null;

        if((item = items.get(position)) != null){
            return item.getId();
        }
        else {
            return 0;
        }
    }

    public void Update()
    {
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ClimaTempo item = items.get(position);

        if(view == null)
        {
            view = context.getLayoutInflater().inflate(R.layout.clima_tempo_row, null);
        }

        TextView descricao = (TextView) view.findViewById(R.id.descricao);
        descricao.setText(item.getDescricao());

        TextView temp_max = (TextView) view.findViewById(R.id.temp_max);
        temp_max.setText(String.valueOf(item.getTempMax()) + "º");

        TextView temp_min = (TextView) view.findViewById(R.id.temp_min);
        temp_min.setText(String.valueOf(item.getTempMin()) + "º");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = item.getData();

        TextView data_semana = (TextView) view.findViewById(R.id.data_semana);
        data_semana.setText(String.valueOf(dateFormat.format(data) + " - " + item.getDiaSemana()));

        ImageView imageView  = (ImageView) view.findViewById(R.id.img);
        String condition = item.getCondition();

        if(condition != null)
        {
            switch (condition){

                case "clear_day":
                    imageView.setImageResource(R.mipmap.sun);
                    break;

                case "cloud":
                    imageView.setImageResource(R.mipmap.cloud);
                    break;

                case "storm":
                    imageView.setImageResource(R.mipmap.storm);
                    break;

                case "rain":
                    imageView.setImageResource(R.mipmap.rain_2);
                    break;
                case "cloudly_day":
                    imageView.setImageResource(R.mipmap.partly_cloudy);
                    break;

                default:
                    //colocar imagem null
                    break;
            }
        }


        return view;
    }

}
