package com.app;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


public class TestEnviarCorreosyRecibirlos {

   @Test
    public void enviarCorreoYRecibir() {
        String asunto = "Hola";
        String contenido = "Mensaje simple.";
        Usuario remitente = new Usuario("sender@example.com");

        List<String> correos = Arrays.asList("x@example.com");
        Usuario destino = new Usuario("dest@example.com");

        remitente.enviarCorreo(asunto, contenido, correos, Arrays.asList(destino), false);

        // Bandejas
        BandejaRecibidos bandejaDest = destino.getBandeja();
        BandejaEnviados bandejaEnv = remitente.getBandejaEnviados();

        // Correcto: 1 en enviados, 1 en recibidos
        assertEquals(1, bandejaEnv.getCorreos().size());
        assertEquals(1, bandejaDest.getCorreos().size());

        // Verificar contenido del correo recibido
        Correo recibido = bandejaDest.getCorreos().get(0);
        assertEquals(asunto, recibido.getAsunto());
        assertEquals(contenido, recibido.getContenido());
    }


}