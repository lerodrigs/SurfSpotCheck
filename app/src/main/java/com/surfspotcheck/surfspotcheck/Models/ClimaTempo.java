package com.surfspotcheck.surfspotcheck.Models;

import java.util.Date;

public class ClimaTempo {

    public ClimaTempo() {}

    private Date data;
    private double temp;
    private double tempMin;
    private double tempMax;
    private String direcaoVento;
    private String velocidadeVento;
    private String descricao;
    private String cidade;
    private byte tempoManha;
    private byte tempoTarde;
    private byte tempoNoite;


    public void setData(Date _data){
        this.data = _data;
    }

    public Date getData() {
        return this.data;
    }

    public void setTempMin(double _temp_min){
        this.tempMin = _temp_min;
    }

    public double getTempMin(){
        return this.tempMin;
    }

    public void setTempMax(double _temp_max){
        this.tempMax = _temp_max;
    }

    public double getTempMax(){
        return this.tempMax;
    }

    public void setDirecaoVento(String _direcao){
        this.direcaoVento = _direcao;
    }

    public String getDirecaoVento(){
        return this.direcaoVento;
    }

    public byte getTempoManha() {
        return this.tempoManha;
    }

    public void setTempoManha(byte tempoManha) {
        this.tempoManha = tempoManha;
    }

    public byte getTempoTarde() {
        return this.tempoTarde;
    }

    public void setTempoTarde(byte tempoTarde) {
        this.tempoTarde = tempoTarde;
    }

    public byte getTempoNoite() {
        return this.tempoNoite;
    }

    public void setTempoNoite(byte tempoNoite) {
        this.tempoNoite = tempoNoite;
    }

    public String getVelocidadeVento() {
        return this.velocidadeVento;
    }

    public void setVelocidadeVento(String velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public void setTemp(double _temp){
        this.temp = _temp;
    }

    public double getTemp(){
        return this.temp;
    }

    public void setDescricao(String _descricao){
        this.descricao = _descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
