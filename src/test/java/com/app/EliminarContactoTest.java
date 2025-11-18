package com.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EliminarContactoTest {

    @Test
    public void EliminarContactoTest() {
        GestorContactos listaContactos = new GestorContactos();
        Contacto contactoOriginal = new Contacto("Lautaro Lopez Lecube", "lautarolecube@gmail.com");
        listaContactos.add(contactoOriginal);

        listaContactos.eliminarContacto("Lautaro Lopez Lecube");

        assertEquals(0, listaContactos.tamañoLista());
    }
}

