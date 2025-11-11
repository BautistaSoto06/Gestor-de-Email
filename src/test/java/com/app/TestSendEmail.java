package com.app;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

import com.app.ISend;
import com.app.SendMail;
import org.junit.jupiter.api.Test;


public class TestSendEmail {

    @Test
    public void testSendEmail() {
        //Configurar los datos del test
        String subject = "Test Email Subject";
        String content = "Este es el contenido del correo de prueba";
        String sender = "test@example.com";
        List<String> recipients = Arrays.asList("recipient1@example.com");
        
        //Crear el correo y enviarlo
        SendMail email = new SendMail(subject, content, sender, recipients);
        
        // Verificar estado inicial
        assert email.getStatus().equals("pending") : "El estado inicial debe ser 'pending'";
        assert !email.isImportant() : "El correo no debe estar marcado como importante inicialmente";
        
        // Enviar el correo
        email.send();
        
        // Verificar que el correo se envió correctamente
        assert email.getStatus().equals("sent") : "El estado debe ser 'sent' después del envío";
        
        // Verificar que la información del correo es correcta
        String[] emailInfo = email.getEmailInfo();
        assert emailInfo[0].equals(subject) : "El asunto debe coincidir";
        assert emailInfo[1].equals(content) : "El contenido debe coincidir";
        assert emailInfo[2].equals(sender) : "El remitente debe coincidir";
        assert emailInfo[3].equals("recipient1@example.com") : "Los destinatarios deben coincidir";
        
    }



    @Test
    public void testWasReceivedBy(){
        String subject = "Test Email Subject";
        String content = "Este es el contenido del correo de prueba";
        String sender = "test@example.com";
        List<String> recipients = Arrays.asList("recipient1@example.com");
        SendMail email = new SendMail(subject, content, sender, recipients);
        
        assert email.getStatus().equals("pending") : "El estado inicial debe ser 'pending'";

        email.send();
        assert email.getStatus().equals("sent") : "El estado debe ser 'sent' después del envío";

        // Verificar si el correo fue recibido por el destinatario
        assert email.wasReceivedBy("recipient1@example.com") : "El correo debe haber sido recibido por recipient1@example.com";
        assert !email.wasReceivedBy("recipient2@example.com") : "El correo no debe haber sido recibido por recipient2@example.com";
    }

   @Test
    public void testWasReceivedBy2Users(){
        String subject = "Test Email Subject";
        String content = "Este es el contenido del correo de prueba";
        String sender = "test@example.com";
        List<String> recipients = Arrays.asList("recipient1@example.com", "recipient2@example.com");
        
        SendMail email = new SendMail(subject, content, sender, recipients);

        assert email.getStatus().equals("pending") : "El estado inicial debe ser 'pending'";

        // Solo enviamos a un destinatario
        email.send();

        assert email.getStatus().equals("sent") : "El estado debe ser 'sent' después del envío";

        // Verificar resultados
        assert email.wasReceivedBy("recipient1@example.com") : "El correo debe haber sido recibido por recipient1@example.com";
        assert email.wasReceivedBy("recipient2@example.com") : "El correo no debe haber sido recibido por recipient2@example.com";
        assert !email.wasReceivedBy("recipient3@example.com") : "El estado de entrega para recipient3@example.com debe ser false";

    }

}







    

    