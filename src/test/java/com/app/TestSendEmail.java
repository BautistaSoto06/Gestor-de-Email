package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


public class TestSendEmail {

    @Test
    public void enviarCorreoyRecibirTest() {
        String asunto = "Prueba de correo";
        String contenido = "Este es un correo de prueba.";
        Usuario remitente = new Usuario("remitente@example.com");
        Usuario destinatario = new Usuario("destinatario@example.com");
        
        List<String> recipients = Arrays.asList(destinatario.getEmail());

        remitente.enviarCorreo(asunto, contenido, recipients, destinatario);

        
        // Obtenemos ambas bandejas
        BandejaRecibidos bandejaRemitente = remitente.getBandeja();
        BandejaRecibidos bandejaDestinatario = destinatario.getBandeja();

        //bandeja de destinatario debe tener 1 correo
        assertEquals(1, bandejaDestinatario.getCorreos().size()); 
        
        //bandeja de remitente debe estar vacía
        assertEquals(0, bandejaRemitente.getCorreos().size()); 

        Correo correoRecibido = bandejaDestinatario.getCorreos().get(0);
        // Todos estos métodos funcionarán si guardaste Correo.java
        assertEquals(asunto, correoRecibido.getAsunto());
        assertEquals(contenido, correoRecibido.getContenido());
        assertEquals(remitente.getEmail(), correoRecibido.getRemitente());
        assertEquals(recipients, correoRecibido.getDestinatarios());
    }
}