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
    }

    private Date data;
    private double alturaManha;
    private double alturaTarde;
    private double alturaNoite;

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getAlturaManha(){
        return this.alturaManha;
    }

    public void setAlturaManha(double _altura){
        this.alturaManha = _altura;
    }

    public double getAlturaTarde(){
        return this.alturaTarde;
    }

    public void setAlturaTarde(double _altura){
        this.alturaTarde = _altura;
    }

    public double getAlturaNoite(){
        return this.alturaNoite;
    }

    public void setAlturaNoite(double _altura){
        this.alturaNoite = _altura;
    }

}
