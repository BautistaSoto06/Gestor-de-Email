package com.app;

public abstract class EditarContacto {

    private String nombre;
    private String email;

    public EditarContacto() {
    }

    public abstract void editarContacto();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}