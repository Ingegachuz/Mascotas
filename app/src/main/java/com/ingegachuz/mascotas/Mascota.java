package com.ingegachuz.mascotas;

/**
 * Created by Inge on 29/05/2016.
 */
public class Mascota {

    private String nombre;
    private int foto;
    private String cantidad;


    public Mascota(int foto, String nombre, String cantidad) {
        this.foto = foto;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
