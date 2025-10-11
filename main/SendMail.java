package main;

import java.util.List;

/**
 * Implementación concreta de ISend que sigue SOLID y los requisitos del usuario.
 */
public class SendMail implements ISend {
    private String subject;
    private String content;
    private String sender;
    private List<String> recipients;
    private boolean important;
    private String status;

    public SendMail(String subject, String content, String sender, List<String> recipients) {
        this.subject = subject;
        this.content = content;
        this.sender = sender;
        this.recipients = recipients;
        this.important = false;
        this.status = "pending";
    }

    @Override
    public String[] getEmailInfo() {
        String recs = String.join(", ", recipients);
        return new String[]{subject, content, sender, recs};
    }

    @Override
    public void send() {
        // Simula el envío
        status = "sent";
    }

    @Override
    public void markImportant() {
        important = true;
    }

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
