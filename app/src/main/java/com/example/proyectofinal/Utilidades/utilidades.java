package com.example.proyectofinal.Utilidades;

public class utilidades {


    public static final String TABLA_USUARIO = "user";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_USUARIO = "usuario";
    public static final String CAMPO_CONTRASEÑA = "contraseña";



    public static final String TABLA_NOTA = "note";
    public static final String CAMPO_TITULO = "titulo";
    public static final String CAMPO_DESCRIPCION = "desc";
    public static final String CAMPO_FECHA = "fech";
    public static final String CAMPO_HORA = "hora";
    public static final String CAMPO_NOTA = "notax";

   public static final String CREAR_TABLA_USUARIO =
           "CREATE TABLE " + TABLA_USUARIO + "" +
           " (" + CAMPO_NOMBRE + " TEXT, " +
           "" + CAMPO_USUARIO+" TEXT, " +
           "" + CAMPO_CONTRASEÑA + " TEXT)" ;




    public static final String CREAR_TABLA_NOTA =
            "CREATE TABLE " + TABLA_NOTA + "" +
                    " (" + CAMPO_TITULO + " TEXT, " +
                    "" + CAMPO_DESCRIPCION+" TEXT, " +
                    "" + CAMPO_FECHA + " TEXT" +
                    "" + CAMPO_HORA+" TEXT, " +
                    "" + CAMPO_NOTA+" TEXT)" ;
}
