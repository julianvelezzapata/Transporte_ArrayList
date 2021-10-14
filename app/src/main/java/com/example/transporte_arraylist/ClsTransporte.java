package com.example.transporte_arraylist;

import java.io.Serializable;

public class ClsTransporte implements Serializable {
    private  String codigo;
    private String transporte;
    private String cantidad;
    private String alimentacion;
    private String total;

    public ClsTransporte(String transporte, String codigo, String cantidad, String alimentacion , String total){
        this.codigo = codigo;
        this.transporte = transporte;
        this.cantidad = cantidad;
        this.alimentacion = alimentacion;
        this.total = total;
    }

    public ClsTransporte(){
    }
    public String getCodigo(){return codigo;}

    public void setCodigo(String codigo) { this.codigo = codigo;}

    public String getTransporte(){return transporte;}

    public void setTransporte(String transporte) { this.transporte = transporte;}

    public String getCantidad(){return cantidad;}

    public void setCantidad(String cantidad) { this.cantidad = cantidad;}

    public String getAlimentacion(){return alimentacion;}

    public void setAlimentacion(String alimentacion) { this.alimentacion = alimentacion;}

    public String getTotal(){return total;}

    public void setTotal(String total) { this.total = total;}

    @Override
    public String toString() {
        return "Datos transporte{" +
                "codigo='" + codigo + '\'' +
                ", transporte='" + transporte + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", alimentacion='" + alimentacion + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
