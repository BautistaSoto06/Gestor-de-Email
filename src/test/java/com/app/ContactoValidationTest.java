package com.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactoValidationTest {

    @Test
    public void validarSettersYExcepciones() {
        Contacto contacto = new Contacto("Nombre","mail@test.com");
        assertEquals("Nombre", contacto.getNombre());
        assertEquals("mail@test.com", contacto.getEmail());

        contacto.setNombre("Otro");
        contacto.setEmail("otro@test.com");

        assertEquals("Otro", contacto.getNombre());
        assertEquals("otro@test.com", contacto.getEmail());

        // llamar con null a setEmail provocará NullPointerException dado el código actual
        assertThrows(NullPointerException.class, () -> contacto.setEmail(null));
        // llamar con null a setNombre también provocará NullPointerException
        assertThrows(NullPointerException.class, () -> contacto.setNombre(null));
    }
}
