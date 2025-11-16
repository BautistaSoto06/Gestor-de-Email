package com.app;

import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private String miDireccionDeEmail;
    private BandejaRecibidos miBandeja;
    private BandejaEnviados bandejaEnviados;

    public Usuario(String email) {
        this.miDireccionDeEmail = email;
        this.miBandeja = new BandejaRecibidos();
        this.bandejaEnviados = new BandejaEnviados();
    }

    public BandejaRecibidos getBandeja() {
        return this.miBandeja;
    }

    public BandejaEnviados getBandejaEnviados() {
        return this.bandejaEnviados;
    }

    public String getEmail() {
        return this.miDireccionDeEmail;
    }

    public void enviarCorreo(String asunto, String contenido, List<String> recipients, List<Usuario> destinatariosUsuarios,Boolean importante) {

        
        Correo correoEnviado = new Correo(asunto, contenido, this.miDireccionDeEmail,new ArrayList<>(recipients)
        );

        if (Boolean.TRUE == importante) {
            correoEnviado.marcarImportante();
        }

        // Copias independientes a cada destinatario
        for (Usuario u : destinatariosUsuarios) {
            Correo copia = new Correo(
                    asunto, contenido, this.miDireccionDeEmail,
                    new ArrayList<>(recipients)
            );

            copia.setStatus("Recibido");
            u.getBandeja().agregarCorreo(copia);
        }

        // Se marca como enviado
        correoEnviado.setStatus("Enviado");

        // Se guarda en Enviados
        this.bandejaEnviados.agregarCorreo(correoEnviado);
    }
}
