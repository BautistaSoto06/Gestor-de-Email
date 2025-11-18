package com.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EliminarContactoTest {

    @Test
    public void editarContactoTest() {
        GestorContactos listaContactos = new GestorContactos();
        Contacto contactoOriginal = new Contacto("Lautaro Lopez Lecube", "lautarolecube@gmail.com");
        listaContactos.add(contactoOriginal);

        EditarContacto.editarNombre(contactoOriginal, "Lautaro Editado");

        assertEquals("Lautaro Editado", contactoOriginal.getNombre());
    }
}

