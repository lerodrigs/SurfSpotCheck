package com.surfspotcheck.surfspotcheck.Adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.surfspotcheck.surfspotcheck.Models.ClimaTempo;
import com.surfspotcheck.surfspotcheck.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClimaTempoTodayAdapter
{
    ClimaTempo climaTempo;
    Activity context;
    RelativeLayout view;

    public ClimaTempoTodayAdapter(Activity _context, ClimaTempo _climaTempo, RelativeLayout _view)
    {
        this.climaTempo= _climaTempo;
        this.context = _context;
        this.view = _view;
    }

    public void UpdateClimaTempoItem()
    {
        if(climaTempo != null && view != null)
        {
            context.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    TextView cidade = (TextView) view.findViewById(R.id.cidade);
                    cidade.setText(climaTempo.getCidade());

                    TextView data = (TextView) view.findViewById(R.id.data);

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = climaTempo.getData();

                    data.setText(dateFormat.format(date));

                    TextView temp = (TextView) view.findViewById(R.id.temp);
                    temp.setText(String.valueOf(climaTempo.getTemp()) + "º");

                    TextView descricao = (TextView)  view.findViewById(R.id.descricao);
                    descricao.setText(climaTempo.getDescricao());

                    TextView umidade = (TextView) view.findViewById(R .id.txt_umidade);
                    umidade.setText(" "+Integer.toString(climaTempo.getUmidade()) + "%");

                    TextView vento = (TextView) view.findViewById(R.id.txt_vento);
                    vento.setText(" "+climaTempo.getVelocidadeVento());

                    ImageView img = (ImageView) view.findViewById(R.id.img);

                    String conditionSlug = climaTempo.getConditionSlug();

                    switch (conditionSlug)
                    {
                        case "clear_day":
                            img.setImageResource(R.mipmap.sun);
                            break;

                        case "cloud":
                            img.setImageResource(R.mipmap.cloud);
                            break;

                        case "storm":
                            img.setImageResource(R.mipmap.storm);
                            break;

                        case "rain":
                            img.setImageResource(R.mipmap.rain_2);
                            break;
                        case "cloudly_day":
                            img.setImageResource(R.mipmap.partly_cloudy);
                            break;

                        default:
                            //colocar imagem null
                            break;

                    }
                }
            });
        }
    }
}
