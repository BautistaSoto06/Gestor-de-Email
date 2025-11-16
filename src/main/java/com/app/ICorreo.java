package com.app;

public interface ICorreo {

    // Envía el correo electrónico.
    void send();

    // Marca el correo como importante.
    void marcarImportante();

    // Devuelve el estado del envío (por ejemplo, "Enviado", "Error").
    String getStatus();
}
