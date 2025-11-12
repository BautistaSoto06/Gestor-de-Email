package com.app;

import java.util.List;

/**
 * Lightweight alias for Correo to satisfy types used across the project.
 * Extends Correo so it reuses the existing implementation.
 */
public class SendMail extends Correo {
    public SendMail(String asunto, String contenido, String remitente, List<String> destinatarios) {
        super(asunto, contenido, remitente, destinatarios);
    }
}
