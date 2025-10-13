package main;

import java.util.List;


//Clase que implementa la interfaz ISend para enviar correos electrónicos.

public class SendMail implements ISend {
    private String subject;
    private String content;
    private String sender;
    private List<String> recipients;
    private boolean important;
    private String status;

    // Constructor
    public SendMail(String subject, String content, String sender, List<String> recipients) {
        this.subject = subject;
        this.content = content;
        this.sender = sender;
        this.recipients = recipients;
        this.important = false;
        this.status = "pending";
    }


    //Info del correo
    @Override
    public String[] getEmailInfo() {
        String recs = String.join(", ", recipients);
        return new String[]{subject, content, sender, recs};
    }

    // Envía el correo electrónico.
    @Override
    public void send() {
        // Simula el envío
        status = "sent";
    }

    // Marca el correo como importante.
    @Override
    public void markImportant() {
        important = true;
    }

    // Devuelve el estado del envío (por ejemplo, "Enviado", "Error").
    @Override
    public String getStatus() {
        return status;
    }

    // Getters para tests o uso externo
    public String getSubject() { return subject; }
    public String getContent() { return content; }
    public String getSender() { return sender; }
    public List<String> getRecipients() { return recipients; }
    public boolean isImportant() { return important; }
}
