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

    public void enviarCorreo(String asunto, String contenido, List<String> recipients, List<Usuario> destinatariosUsuarios) {
        Correo correoAEnviar = new Correo(asunto, contenido, this.miDireccionDeEmail, new ArrayList<>(recipients));
        for (Usuario u : destinatariosUsuarios) {
        BandejaRecibidos bandeja = u.getBandeja();
        // opcional: clonar el Correo si quieres estados independientes
        bandeja.agregarCorreo(correoAEnviar);
    }
    correoAEnviar.setStatus("Enviado");
    }

}
