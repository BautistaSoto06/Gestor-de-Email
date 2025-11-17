package com.app; 




public class EditarContacto {

    protected GestorContactos gestor;
    protected String email;
    protected String nombre;
    
    private EditarContacto() {
    }

    public static void editarNombre(Contacto contacto, String nuevoNombre){
        contacto.setNombre(nuevoNombre);
    }
    
    public static void editarMail(Contacto contacto, String nuevoEmail){
        contacto.setEmail(nuevoEmail);
    }

}