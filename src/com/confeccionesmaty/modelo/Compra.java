package com.confeccionesmaty.modelo;

public class Compra {
    private String idCliente;
    private int codeProducto;

    public Compra (String idCliente, int codeProducto){
        this.idCliente = idCliente;
        this.codeProducto = codeProducto;
    }

    public String getIdCliente() {return idCliente;}
    public void setIdCliente (String idCliente) {this.idCliente = idCliente;}

    public int getCodeProducto() {return codeProducto;}
    public void setCodeProducto(int codeProducto) {this.codeProducto = codeProducto;}

    @Override
    public String toString() {
        return "compra id cliente" + idCliente + "codeProducto" + codeProducto;
    }
}
