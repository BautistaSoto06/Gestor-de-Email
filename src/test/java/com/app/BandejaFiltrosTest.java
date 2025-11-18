package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class BandejaFiltrosTest {

    private BandejaRecibidos bandeja;
    private Correo cJavaImportante;
    private Correo cJavaNoImportante;
    private Correo cOtro;

    @BeforeEach
    public void setUp() {
        bandeja = new BandejaRecibidos();

        // 1. Correo Importante: Usamos 'marcarImportante()' en lugar de setImportante
        cJavaImportante = new Correo("Curso Java", "Aprender Streams", "profe@java.com", new ArrayList<>());
        cJavaImportante.marcarImportante(); // ESTE ES EL MÉTODO QUE SÍ TIENES

        // 2. Correo No Importante (nace false por defecto en tu constructor)
        cJavaNoImportante = new Correo("Duda Java", "No entiendo nada", "alumno@java.com", new ArrayList<>());

        // 3. Otro correo Importante
        cOtro = new Correo("Oferta", "Descuentos en ropa", "tienda@shop.com", new ArrayList<>());
        cOtro.marcarImportante(); // ESTE ES EL MÉTODO QUE SÍ TIENES

        // Agregamos a la bandeja usando 'agregarCorreo' en lugar de recibirCorreo
        bandeja.agregarCorreo(cJavaImportante);     // ESTE ES EL MÉTODO QUE SÍ TIENES
        bandeja.agregarCorreo(cJavaNoImportante);
        bandeja.agregarCorreo(cOtro);
    }

    @Test
    public void testBuscarPorAsunto() {
        List<Correo> resultado = bandeja.buscarPorAsunto("Java");
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(cJavaImportante));
        assertTrue(resultado.contains(cJavaNoImportante));
    }

    @Test
    public void testBuscarPorRemitente() {
        List<Correo> resultado = bandeja.buscarPorRemitente("profe");
        assertEquals(1, resultado.size());
        assertEquals("profe@java.com", resultado.get(0).getRemitente());
    }

    @Test
    public void testBuscarPorContenido() {
        List<Correo> resultado = bandeja.buscarPorContenido("Descuentos");
        assertEquals(1, resultado.size());
        assertEquals("Oferta", resultado.get(0).getAsunto());
    }

    @Test
    public void testFiltrarPorAsuntoYEsImportante() {
        // Buscamos "Java" (hay 2), pero solo 1 es importante
        List<Correo> resultado = bandeja.filtrarPorAsuntoYEsImportante("Java");

        assertEquals(1, resultado.size());
        assertEquals(cJavaImportante, resultado.get(0));
        assertTrue(resultado.get(0).esImportante());
    }

    @Test
    public void testFiltrarPorAsuntoYEsImportante_NoEncuentra() {
        List<Correo> resultado = bandeja.filtrarPorAsuntoYEsImportante("Duda");
        assertEquals(0, resultado.size());
    }

    @Test
    public void testFiltrarPorRemitenteYContenido() {
        List<Correo> resultado = bandeja.filtrarPorRemitenteYContenido("alumno", "entiendo");
        assertEquals(1, resultado.size());
        assertEquals(cJavaNoImportante, resultado.get(0));
    }

    @Test
    public void testFiltrarPorRemitenteYContenido_FallaUno() {
        // Coincide remitente pero no contenido
        List<Correo> resultado = bandeja.filtrarPorRemitenteYContenido("alumno", "streams");
        assertEquals(0, resultado.size());
    }
}