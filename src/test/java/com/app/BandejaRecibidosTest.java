package com.app;

import main.BandejaRecibidos;
import main.Correo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BandejaRecibidosTest {

    private BandejaRecibidos bandeja;
    private Correo c1;
    private Correo c2;
    private Correo c3;

    @Before
    public void setUp() {
        bandeja = new BandejaRecibidos();
        String destinatario = "yo";
        String asunto1 = "Pago";
        String asunto2 = "Reunion";
        String asunto3 = "Aviso";
        String contenido1 = "Factura de luz";
        String contenido2 = "Agenda del curso";
        String contenido3 = "Actualización del sistema";
        Usuario remitente = new Usuario("sender@example.com");
        List<String> correos = Arrays.asList("x@example.com");
        Usuario destino = new Usuario("dest@example.com");

        c1 = new Correo(asunto1, contenido1, "re", "marcos@gmail.com", false, destinatario);
        c2 = new Correo(asunto2, contenido2, "Pedro", "juan@gmail.com", true, destinatario);
        c3 = new Correo(asunto3, contenido3, "Admin", "info@gmail.com", false, destinatario);

        bandeja.agregarCorreo(c1);
        bandeja.agregarCorreo(c2);
        bandeja.agregarCorreo(c3);
    }

    @Test
    public void testAgregarCorreo() {
        Assert.assertEquals(3, bandeja.getTodos().size());
    }

    @Test
    public void testBuscarPorAsunto() {
        List<Correo> r = bandeja.buscarPorAsunto("Pago");
        Assert.assertEquals(1, r.size());
        Assert.assertEquals("Pago", r.get(0).getAsunto());
    }

    @Test
    public void testBuscarPorAsuntoSinResultados() {
        List<Correo> r = bandeja.buscarPorAsunto("NO EXISTE");
        Assert.assertTrue(r.isEmpty());
    }

    @Test
    public void testBuscarPorRemitente() {
        List<Correo> r = bandeja.buscarPorRemitente("Pedro");
        Assert.assertEquals(1, r.size());
        Assert.assertEquals("Pedro", r.get(0).getRemitente());
    }

    @Test
    public void testBuscarPorRemitenteParcial() {
        List<Correo> r = bandeja.buscarPorRemitente("La");
        Assert.assertEquals(1, r.size());
        Assert.assertEquals("Lautaro", r.get(0).getRemitente());
    }


    @Test
    public void testBuscarPorContenido() {
        List<Correo> r = bandeja.buscarPorContenido("curso");
        Assert.assertEquals(1, r.size());
        Assert.assertEquals("Reunion", r.get(0).getAsunto());
    }

    @Test
    public void testBuscarPorContenidoCaseInsensitive() {
        List<Correo> r = bandeja.buscarPorContenido("factura");
        Assert.assertEquals(1, r.size());
        Assert.assertEquals("Pago", r.get(0).getAsunto());
    }

    @Test
    public void testBuscarPorContacto() {
        List<Correo> r = bandeja.buscarPorContacto("juan");
        Assert.assertEquals(1, r.size());
        Assert.assertEquals("Reunion", r.get(0).getAsunto());
    }

    @Test
    public void testBuscarPorContactoSinResultados() {
        List<Correo> r = bandeja.buscarPorContacto("pepito");
        Assert.assertTrue(r.isEmpty());
    }

    @Test
    public void testMarcarComoImportante() {
        bandeja.marcarComoImportante(c1);
        Assert.assertTrue(c1.esImportante());
    }



    @Test
    public void testEliminarCorreo() {
        bandeja.eliminarCorreo(c2);
        Assert.assertEquals(2, bandeja.getTodos().size());
        Assert.assertFalse(bandeja.getTodos().contains(c2));
    }

    @Test
    public void testEliminarCorreoInexistenteNoRompe() {
        Correo falso = new Correo("X", "Y", "Z", "a", false, "yo");
        bandeja.eliminarCorreo(falso); // no existe
        Assert.assertEquals(3, bandeja.getTodos().size());
    }

    @Test
    public void testGetTodos() {
        List<Correo> todos = bandeja.getTodos();
        Assert.assertEquals(3, todos.size());
        Assert.assertTrue(todos.contains(c1));
        Assert.assertTrue(todos.contains(c2));
        Assert.assertTrue(todos.contains(c3));
    }
}

