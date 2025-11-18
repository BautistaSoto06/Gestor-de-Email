package com.app;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ContactoGestorTest {

    @Test
    public void contactoAndGestor() {
        Contacto contacto = new Contacto("Pepito","pepito@test.com");
        assertEquals("Pepito", contacto.getNombre());
        assertEquals("pepito@test.com", contacto.getEmail());

        EditarContacto.editarNombre(contacto, "Nuevo");
        assertEquals("Nuevo", contacto.getNombre());
        EditarContacto.editarMail(contacto, "nuevo@test.com");
        assertEquals("nuevo@test.com", contacto.getEmail());

        GestorContactos gestor = new GestorContactos();
        gestor.crearContacto("Ana","ana@test.com");
        gestor.add(contacto);
        assertTrue(gestor.tamañoLista() >= 1);
        List<Contacto> encontrados = gestor.buscarPorNombre("an");
        assertNotNull(encontrados);

        List<Contacto> res = gestor.eliminarContacto("ana");
        assertNotNull(res);
    }
}
