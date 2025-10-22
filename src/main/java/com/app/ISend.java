package com.app;

public interface ISend {
    // Devuelve la información actual del correo a enviar (por ejemplo, destinatarios, asunto, contenido).
    String[] getEmailInfo();

    // Envía el correo electrónico.
    void send();

    // Marca el correo como importante.
    void markImportant();

    // Devuelve el estado del envío (por ejemplo, "Enviado", "Error").
    String getStatus();
}
