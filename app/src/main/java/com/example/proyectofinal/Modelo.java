package com.example.proyectofinal;

public class Modelo {

    private int imagenIcono;
    String titulo;
    String cuerpo;

    public Modelo(int imagenIcono,String titulo, String cuerpo) {
        this.imagenIcono = imagenIcono;
        this.titulo = titulo;
        this.cuerpo = cuerpo;

    }

    public int getImagenIcono() {
        return imagenIcono;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }
}



