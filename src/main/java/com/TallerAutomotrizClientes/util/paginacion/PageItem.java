package com.TallerAutomotrizClientes.util.paginacion;

public class PageItem {
    private  int numero;
    private boolean actual;
    public PageItem(int numero, boolean actual){
        super();
        this.actual = actual;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }
}
