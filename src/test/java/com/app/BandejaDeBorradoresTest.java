package com.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList; 
import java.util.Arrays; // Necesario para la lista de destinatarios

public class BandejaDeBorradoresTest {

    // No hay campos de clase ni método setUp

    @Test
    public void testGuardarBorrador() {
        IBorradores servicioDeAlmacenamiento = new Borradores();
        BandejaDeBorradores bandeja = new BandejaDeBorradores(servicioDeAlmacenamiento);
        String asunto = "Asunto";
        String contenido = "Contenido";
        String remitente = "remitente@test.com";
        List<String> destinatarios = Arrays.asList("dest@test.com");
        Correo correoDePrueba = new Correo(asunto, contenido, remitente, destinatarios);

        // Act
        String idGenerado = bandeja.guardarNuevoBorrador(correoDePrueba);

        // Assert
        assertNotNull(idGenerado); 
        assertEquals(1, bandeja.getTodosLosBorradores().size());
    }

    @Test
    public void testGuardarCambiaEstado() {
        IBorradores servicioDeAlmacenamiento = new Borradores();
        BandejaDeBorradores bandeja = new BandejaDeBorradores(servicioDeAlmacenamiento);
        String asunto = "Asunto";
        String contenido = "Contenido";
        String remitente = "remitente@test.com";
        List<String> destinatarios = Arrays.asList("dest@test.com");
        Correo correoDePrueba = new Correo(asunto, contenido, remitente, destinatarios);

        correoDePrueba.setStatus("pending");

        assertEquals("pending", correoDePrueba.getStatus());
 
        bandeja.guardarNuevoBorrador(correoDePrueba);

        assertEquals("borrador", correoDePrueba.getStatus());
    }

    @Test
    public void testAbrirBorrador() {
        IBorradores servicioDeAlmacenamiento = new Borradores();
        BandejaDeBorradores bandeja = new BandejaDeBorradores(servicioDeAlmacenamiento);
        String asunto = "Asunto";
        String contenido = "Contenido";
        String remitente = "remitente@test.com";
        List<String> destinatarios = Arrays.asList("dest@test.com");
        Correo correoDePrueba = new Correo(asunto, contenido, remitente, destinatarios);

        String idGenerado = bandeja.guardarNuevoBorrador(correoDePrueba);    
        Correo correoCargado = bandeja.abrirBorrador(idGenerado);

        assertNotNull(correoCargado);
        assertEquals(asunto, correoCargado.getAsunto());
        assertEquals(remitente, correoCargado.getRemitente());
    }
    
    @Test
    public void testAbrirBorradorInexistente() {
        IBorradores servicioDeAlmacenamiento = new Borradores();
        BandejaDeBorradores bandeja = new BandejaDeBorradores(servicioDeAlmacenamiento);
        String asunto = "Asunto";
        String contenido = "Contenido";
        String remitente = "remitente@test.com";
        List<String> destinatarios = Arrays.asList("dest@test.com");
        Correo correoDePrueba = new Correo(asunto, contenido, remitente, destinatarios);
        Correo correoCargado = bandeja.abrirBorrador("id-falso-123");

        assertNull(correoCargado); 
    }

    @Test
    public void testDescartarBorrador() {
        IBorradores servicioDeAlmacenamiento = new Borradores();
        BandejaDeBorradores bandeja = new BandejaDeBorradores(servicioDeAlmacenamiento);
        String asunto = "Asunto";
        String contenido = "Contenido";
        String remitente = "remitente@test.com";
        List<String> destinatarios = Arrays.asList("dest@test.com");
        Correo correoDePrueba = new Correo(asunto, contenido, remitente, destinatarios);
        
        String idGenerado = bandeja.guardarNuevoBorrador(correoDePrueba);
        assertEquals(1, bandeja.getTodosLosBorradores().size()); // Verifica que se guardó

        // Act
        bandeja.eliminarBorrador(idGenerado);

        // Assert
        assertEquals(0, bandeja.getTodosLosBorradores().size()); // Verifica que se eliminó
        assertNull(bandeja.abrirBorrador(idGenerado)); // Verifica que no se puede cargar
    }
}