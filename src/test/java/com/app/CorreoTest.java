package com.app;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CorreoTest {
    @Test
    public void correoBasics() {
        Correo c = new Correo("asunto","contenido","from@test.com", Arrays.asList("to@test.com"));
        assertEquals("asunto", c.getAsunto());
        assertEquals("contenido", c.getContenido());
        assertEquals("from@test.com", c.getRemitente());
        assertEquals(1, c.getDestinatarios().size());

        c.marcarImportante();
        assertTrue(c.esImportante());

        c.marcarLeido();
        assertTrue(c.isLeido());

        c.marcarNoLeido();
        assertFalse(c.isLeido());

        c.setStatus("pending");
        assertEquals("pending", c.getStatus());
    }

    @Test
    public void testGetLeidos() {
        BandejaRecibidos bandeja = new BandejaRecibidos();
        
        Correo c1 = new Correo("Leído", "Texto", "rem@test.com", Arrays.asList("test@test.com"));
        c1.marcarLeido(); 
        
        bandeja.agregarCorreo(c1);

        assertEquals(1, bandeja.getLeidos().size());
        assertTrue(bandeja.getLeidos().get(0).isLeido());
    }

    @Test
    public void testGetNoLeidos() {
        BandejaRecibidos bandeja = new BandejaRecibidos();
        
        Correo c2 = new Correo("Nuevo", "Texto", "rem@test.com", Arrays.asList("test@test.com"));
        bandeja.agregarCorreo(c2);

        assertEquals(1, bandeja.getNoLeidos().size());
        assertFalse(bandeja.getNoLeidos().get(0).isLeido());
    }
}

