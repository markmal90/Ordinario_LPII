package com.example.model;
public class Gasto {
    private int id;
    private String descripcion;
    private long fecha;
    private double monto;
    
    //Getters y Setters (metodos get (acceder)y set(modificar))
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id= id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setdescripcion(String descripcion){
        this.descripcion= descripcion;

    }
    public long getFecha(){
        return fecha;

    }
    public void setFecha(long fecha){
        this.fecha= fecha;
    }
    public double getMonto(){
        return monto;
    }
    public void setMonto(double monto){
        this.monto= monto;
    
    }
}