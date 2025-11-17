package com.app;
import java.util.List;


public class Correo implements ICorreo { 
    
    private String asunto;
    private String contenido;
    private String remitente;
    private List<String> destinatarios;
    private boolean importante;
    private String status;
    
    // Tu constructor 
    public Correo(String asunto, String contenido, String remitente, List<String> destinatarios) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.remitente = remitente;
        this.destinatarios = destinatarios;
        this.importante = false;
        this.status = "pending"; 
    }

    @Override
    public void marcarImportante() {
        this.importante = true;
    }

    @Override
    public boolean esImportante() {
        return importante;
    }
    
    @Override
    public String getStatus() {
        return status;
    }
    
    
    public void setStatus(String status) {
        this.status = status;
    }

   
    public String getAsunto() { return asunto; }
    public String getContenido() { return contenido; }
    public String getRemitente() { return remitente; }
    public List<String> getDestinatarios() {return destinatarios;}

}