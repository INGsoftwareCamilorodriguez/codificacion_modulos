package com.confeccionesmaty.modelo;

public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String direccion;
    private int codigoProveedor;

    public Proveedor(int idProveedor, String nombre, String direccion, int codigoProveedor){
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigoProveedor = codigoProveedor;
    }

    public int getIdProveedor () {return idProveedor;}
    public void setIdProveedor(int idProveedor) {this.idProveedor = idProveedor;}

    public String getNombre () {return nombre;}
    public void setNombre (String nombre) {this.nombre = nombre;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public int getCodigoProveedor() {return codigoProveedor;}
    public void setCodigoProveedor(int codigoProveedor) {this.codigoProveedor = codigoProveedor;}

    @Override
    public String toString(){
        return "proveedor id = " + idProveedor + " nombre = " + nombre + " direccion = " + direccion + " codigo = " + codigoProveedor;
    }
}
