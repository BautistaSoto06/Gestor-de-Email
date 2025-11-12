package com.app;

public interface ISend {

    // Envía el correo electrónico.
    void send();

    // Marca el correo como importante.
    void markImportant();

    // Devuelve el estado del envío (por ejemplo, "Enviado", "Error").
    String getStatus();
}
