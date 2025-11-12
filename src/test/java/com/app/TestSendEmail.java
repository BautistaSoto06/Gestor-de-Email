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
        List<String> correos = Arrays.asList("a@example.com");
        List<Usuario> destinatarios = Arrays.asList(new Usuario("destinatario@example.com"));

        remitente.enviarCorreo(asunto, contenido, correos, destinatarios);

        // Obtenemos ambas bandejas
        BandejaRecibidos bandejaRemitente = remitente.getBandeja();
        BandejaRecibidos bandejaDestinatario = destinatarios.get(0).getBandeja();

        //bandeja de destinatario debe tener 1 correo
        assertEquals(1, bandejaDestinatario.getCorreos().size()); 
        
        //bandeja de remitente debe estar vacía
        assertEquals(0, bandejaRemitente.getCorreos().size()); 

        Correo correoRecibido = bandejaDestinatario.getCorreos().get(0);
        assertEquals(asunto, correoRecibido.getAsunto());
        assertEquals(contenido, correoRecibido.getContenido());
        assertEquals(remitente.getEmail(), correoRecibido.getRemitente());
        assertEquals(correos, correoRecibido.getDestinatarios());
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
}