package com.app; 

public class Contacto {
    //Atributos propios
    private String nombre;
    private String email;

    //Constructor con parámetros
    public Contacto(String nombre, String email) {
        validarEmail(email);
        validarNombre(nombre);
        this.nombre = nombre;
        this.email = email;
    }
    
    //Métodos
    public void validarEmail(String email){
            if (email == null && email.isEmpty() && email.contains("@")) {
                throw new IllegalArgumentException("El campo email debe completarse y tener un formato válido");
            }
        }

    public void validarNombre(String nombre){
            if (nombre == null && nombre.isEmpty()) {
                throw new IllegalArgumentException("El campo nombre debe completarse");
            }
        }

    //getters
    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    //setters
    public void setEmail(String email) {
        validarEmail(email);
        this.email = email;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    
    
    
}