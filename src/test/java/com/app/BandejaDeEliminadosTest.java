package com.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class BandejaDeEliminadosTest {

    @Test
    public void testMoverAEliminados() {
        // Instanciamos directamente
        BandejaDeEliminados bandeja = new BandejaDeEliminados();

        String asunto = "Asunto";
        String contenido = "Contenido";
        String remitente = "remitente@test.com";
        List<String> destinatarios = Arrays.asList("dest@test.com");

        Correo correo = new Correo(asunto, contenido, remitente, destinatarios);

        bandeja.moverAEliminados(correo);
        
        // Pedimos el ID a la misma bandeja
        String idGenerado = bandeja.getIdDeCorreo(correo);

        assertNotNull(idGenerado, "El ID generado no debería ser nulo");
        assertEquals("eliminado", correo.getStatus());
        assertEquals(1, bandeja.getTodosLosEliminados().size());
        assertTrue(bandeja.existeEliminado(idGenerado));
    }

    @Test
    public void testRestaurarCorreo() {
        BandejaDeEliminados bandeja = new BandejaDeEliminados();

        Correo correo = new Correo("A", "B", "rem@test.com", Arrays.asList("dest@test.com"));
        bandeja.moverAEliminados(correo);
        
        String idGenerado = bandeja.getIdDeCorreo(correo);

        boolean restaurado = bandeja.restaurarCorreo(idGenerado);

        assertTrue(restaurado);
        assertEquals(0, bandeja.getTodosLosEliminados().size());
        assertFalse(bandeja.existeEliminado(idGenerado));
    }

    @Test
    public void testEliminarDefinitivo() {
        BandejaDeEliminados bandeja = new BandejaDeEliminados();

        Correo correo = new Correo("A", "B", "rem@test.com", Arrays.asList("dest@test.com"));
        bandeja.moverAEliminados(correo);
        
        String idGenerado = bandeja.getIdDeCorreo(correo);

        bandeja.eliminarDefinitivo(idGenerado);

        assertEquals(0, bandeja.getTodosLosEliminados().size());
        assertFalse(bandeja.existeEliminado(idGenerado));
    }

    @Test
    public void testRestaurarCorreoInexistente() {
        BandejaDeEliminados bandeja = new BandejaDeEliminados();

        boolean resultado = bandeja.restaurarCorreo("id-falso-999");

        assertFalse(resultado);
        assertEquals(0, bandeja.getTodosLosEliminados().size());
    }
}