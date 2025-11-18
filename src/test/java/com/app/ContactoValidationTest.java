package com.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactoValidationTest {

    @Test
    public void validarSettersYExcepciones() {
        Contacto contacto = new Contacto("Nombre","mail@test.com");
        assertEquals("Nombre", contacto.getNombre());
        assertEquals("mail@test.com", contacto.getEmail());

        contacto.validarNombre("Nombre");
        contacto.validarEmail("otro@test.com");
    }
}
