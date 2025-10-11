
package main;

/**
 * Interfaz que declara el contrato mínimo para enviar correos electrónicos.
 */
public interface ISend {
    /**
     * Devuelve la información actual del correo a enviar (por ejemplo, destinatarios, asunto, contenido).
     */
    String[] getEmailInfo();

    /**
     * Envía el correo electrónico.
     */
    void send();

    /**
     * Marca el correo como importante.
     */
    void markImportant();

    /**
     * Devuelve el estado actual del correo (por ejemplo, enviado, pendiente, fallido).
     */
    String getStatus();
}
