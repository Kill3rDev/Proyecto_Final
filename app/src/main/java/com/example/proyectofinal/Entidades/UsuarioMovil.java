package com.example.proyectofinal.Entidades;

public class UsuarioMovil
{


    private String name;
    private String user;
    private String password;


    public UsuarioMovil(String nombre, String usuario, String contraseña) {
        this.name = nombre;
        this.user = usuario;
        this.password = contraseña;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

