package com.example.transporte_arraylist;

import java.io.Serializable;

public class ClsTransporte implements Serializable {
    private String transporte;
    private  String codigo;
    private String cantidad;
    private String alimentacion;
    private String total;

    public ClsTransporte(String transporte, String codigo, String cantidad, String alimentacion , String total){
        this.transporte = transporte;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.alimentacion = alimentacion;
        this.total = total;
    }

    public ClsTransporte(){
    }
    public String getTransporte(){return transporte;}

    public void setTransporte(String transporte) { this.transporte = transporte;}

    public String getCodigo(){return codigo;}

    public void setCodigo(String transporte) { this.transporte = codigo;}

    public String getCantidad(){return cantidad;}

    public void setTransporte(String transporte) { this.transporte = transporte;}

    public String getTransporte(){return transporte;}

    public void setTransporte(String transporte) { this.transporte = transporte;}

    public String getTransporte(){return transporte;}

    public void setTransporte(String transporte) { this.transporte = transporte;}


}
