

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import main.ISend;
import main.SendMail;

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
        
        System.out.println("✓ Test enviado correctamente - Estado: " + email.getStatus());
        System.out.println("✓ Información del correo: " + Arrays.toString(emailInfo));
    }
}   
    