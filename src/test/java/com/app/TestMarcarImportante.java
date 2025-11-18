package com.app;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


public class TestMarcarImportante {
    @Test
    public void enviarCorreoyMarcarImportante() {
        String asunto = "Prueba de correo";
        String contenido = "Este es un correo de prueba.";
        Usuario remitente = new Usuario("remitente@example.com");

        List<String> correos = Arrays.asList("a@example.com");
        List<Usuario> destinatarios = Arrays.asList(new Usuario("destinatario@example.com"));

        // Enviar correo y marcar como importante
        remitente.enviarCorreo(asunto, contenido, correos, destinatarios , true);

        // Bandejas
        BandejaRecibidos bandejaRemitente = remitente.getBandeja();                // recibidos del remitente
        BandejaRecibidos bandejaDestinatario = destinatarios.get(0).getBandeja();  // recibidos del destino
        BandejaEnviados bandejaEnviados = remitente.getBandejaEnviados();          // enviados del remitente
        

        // El destinatario recibe 1 correo
        assertEquals(1, bandejaDestinatario.getCorreos().size());

        // El remitente NO recibe nada en su bandeja de recibidos
        assertEquals(0, bandejaRemitente.getCorreos().size());

        // El remitente sí tiene 1 correo en enviados
        assertEquals(1, bandejaEnviados.getCorreos().size());

        // Verificar correo del destinatario
        Correo correoRecibido = bandejaDestinatario.getCorreos().get(0);
        assertFalse(correoRecibido.esImportante());  // la copia no es importante
        assertEquals(asunto, correoRecibido.getAsunto());
        assertEquals(contenido, correoRecibido.getContenido());
        assertEquals(remitente.getEmail(), correoRecibido.getRemitente());
        assertEquals(correos, correoRecibido.getDestinatarios());

        // Verificar correo enviado por el remitente
        Correo correoEnviado = bandejaEnviados.getCorreos().get(0);
        assertTrue(correoEnviado.esImportante());   // el original sí es importante
    }

    @Test
    public void enviarSinImportante() {
        String asunto = "Prueba de correo";
        String contenido = "Este es un correo de prueba.";
        Usuario remitente = new Usuario("remitente@example.com");

        List<String> correos = Arrays.asList("a@example.com");
        List<Usuario> destinatarios = Arrays.asList(new Usuario("destinatario@example.com"));

        // Enviar correo y marcar como no importante
        remitente.enviarCorreo(asunto, contenido, correos, destinatarios, false);
        // Bandejas
        BandejaRecibidos bandejaRemitente = remitente.getBandeja();                // recibidos del remitente
        BandejaRecibidos bandejaDestinatario = destinatarios.get(0).getBandeja();  // recibidos del destino
        BandejaEnviados bandejaEnviados = remitente.getBandejaEnviados();          // enviados del remitente

        // El destinatario recibe 1 correo
        assertEquals(1, bandejaDestinatario.getCorreos().size());

        // El remitente NO recibe nada en su bandeja de recibidos
        assertEquals(0, bandejaRemitente.getCorreos().size());

        // El remitente sí tiene 1 correo en enviados
        assertEquals(1, bandejaEnviados.getCorreos().size());

        // Verificar correo del destinatario
        Correo correoRecibido = bandejaDestinatario.getCorreos().get(0);
        assertFalse(correoRecibido.esImportante());  // la copia no es importante
        assertEquals(asunto, correoRecibido.getAsunto());
        assertEquals(contenido, correoRecibido.getContenido());
        assertEquals(remitente.getEmail(), correoRecibido.getRemitente());
        assertEquals(correos, correoRecibido.getDestinatarios());

        // Verificar correo enviado por el remitente
        Correo correoEnviado = bandejaEnviados.getCorreos().get(0);
        assertFalse(correoEnviado.esImportante());  
    }

    
}
