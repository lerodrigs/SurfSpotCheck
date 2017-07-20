package com.surfspotcheck.surfspotcheck.Models;

import android.content.Intent;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mare {

    public Mare()
    {
        this.data = new Date();
        this.altura = new HashMap<>();
        this.hora = new HashMap<>();
    }

    private Date data;
    private Map<Integer, Double> altura;
    private Map<Integer, Double> hora;

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
