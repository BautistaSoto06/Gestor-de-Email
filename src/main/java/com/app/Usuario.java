package com.app;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
    
    private String miDireccionDeEmail;
    private BandejaRecibidos miBandeja;

    public Usuario(String email) {
        this.miDireccionDeEmail = email;
        this.miBandeja = new BandejaRecibidos();
    }

    public BandejaRecibidos getBandeja() {
        return this.miBandeja;
    }

    public String getEmail() {
        return this.miDireccionDeEmail;
    }

    public void enviarCorreo(String subject, String content, List<String> recipients, Usuario destinatario) {
        Correo correoAEnviar = new Correo(subject, content, this.miDireccionDeEmail, recipients);
        BandejaRecibidos bandejaDelOtro = destinatario.getBandeja();
        bandejaDelOtro.agregarCorreo(correoAEnviar);
        correoAEnviar.setStatus("Enviado");
    }

}
