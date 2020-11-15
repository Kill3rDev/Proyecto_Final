package com.example.proyectofinal.Utilidades;

public class utilidades {


    public static final String TABLA_USUARIO = "user";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_USUARIO = "usuario";
    public static final String CAMPO_CONTRASEÑA = "contraseña";

   public static final String CREAR_TABLA_USUARIO =
           "CREATE TABLE "+TABLA_USUARIO+"" +
           " ("+CAMPO_NOMBRE+" TEXT, " +
           ""+CAMPO_USUARIO+" TEXT, " +
           ""+CAMPO_CONTRASEÑA+" TEXT)" ;

}
