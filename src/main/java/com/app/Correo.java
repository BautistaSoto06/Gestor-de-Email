package com.app;

import java.util.ArrayList;
import java.util.List;

public class Correo implements ICorreo { 
    
    private String asunto;
    private String contenido;
    private String remitente;
    private List<String> destinatarios;
    private boolean importante;
    private String status;
    private boolean leido;
    
    // Constructor 1 (El que ya tenías)
    public Correo(String asunto, String contenido, String remitente, List<String> destinatarios) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.remitente = remitente;
        this.destinatarios = destinatarios;
        this.importante = false;
        this.status = "pending"; 
        this.leido = false;
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

    @Override
    public void marcarLeido() {
        this.leido = true;
    }
    
    @Override
    public void marcarNoLeido() {
        this.leido = false;
    }

    // Getters necesarios
    public String getAsunto() { return asunto; }
    public String getContenido() { return contenido; }
    public String getRemitente() { return remitente; }
    public List<String> getDestinatarios() { return destinatarios; }
    public boolean isLeido() { return leido; }

}