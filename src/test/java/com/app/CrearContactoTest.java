package com.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CrearContactoTest {

    @Test
    public void crearContactoTest() {
        GestorContactos listaContactos = new GestorContactos();
        String nombre = "Lautaro Lopez Lecube";
        String email = "lautarolecube@gmail.com";

        Contacto contacto = new Contacto(nombre, email);
        listaContactos.add(contacto);

        assertEquals(nombre, contacto.getNombre());
        assertEquals(email, contacto.getEmail());
        assertEquals(1, listaContactos.tamañoLista());
    }
}
