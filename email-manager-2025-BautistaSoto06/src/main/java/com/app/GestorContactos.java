package com.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap; 


public class GestorContactos implements IEliminarContacto, ICrearContacto, IContacto {
    

    private Map<String, String> contactos; 
    private String nombre;
    private String email;
    
    
    
    // Constructor
    public GestorContactos(String nombre, String email) {
        // Inicializar el Map en el constructor
        this.contactos = new HashMap<>(); 
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public void eliminarContacto() {
        if (nombre != null && contactos.containsKey(nombre)) {
            contactos.remove(nombre);
            System.out.println("Contacto eliminado: " + nombre);
        } else {
            System.out.println("Contacto no encontrado: " + nombre);
        }
    }

    @Override
    public void crearContacto() {
        if (nombre != null && email != null) {
            setNombreContacto(nombre);
            setEmailContacto(email);
            guardarContacto();
        } else {
            System.out.println("Error: Nombre y email son requeridos");
        }
    }
    
    @Override
    public void setNombreContacto(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void setEmailContacto(String email) {
        this.email = email;
    }
    
    @Override
    public void guardarContacto() {
        if (nombre != null && email != null) {
            contactos.put(nombre, email);
            System.out.println("Contacto guardado: " + nombre + " - " + email);
        }
    }

    @Override
    public List<String> ListaContactos() {
        List<String> lista = new ArrayList<>();
        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            lista.add(entry.getKey() + " - " + entry.getValue());
        }
        return lista;
    }

    @Override
    public void editarContacto() {
        if (nombre != null && contactos.containsKey(nombre)) {
            if (email != null) {
                contactos.put(nombre, email);
                System.out.println("Contacto editado: " + nombre + " - " + email);
            }
        } else {
            System.out.println("Contacto no encontrado para editar: " + nombre);
        }
    }
    
    // Métodos auxiliares
    
    public String buscarContacto(String nombre) {
        return contactos.get(nombre);
    }
    
    public boolean existeContacto(String nombre) {
        return contactos.containsKey(nombre);
    }
    
    public int cantidadContactos() {
        return contactos.size();
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}