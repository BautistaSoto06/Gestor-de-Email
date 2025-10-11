
package main;

/**
 * Interfaz que declara el contrato mínimo para recibir correos electrónicos de la bandeja de entrada.
 */
public interface IInboxReceiver {
	/**
	 * Devuelve la lista de correos recibidos en la bandeja de entrada.
	 */
	String[][] getInboxEmails();

	/**
	 * Actualiza la lista de correos recibidos (simula la recepción de nuevos correos).
	 */
	void receive();

	/**
	 * Marca un correo de la bandeja de entrada como leído.
	 */
	void markRead(int index);

	/**
	 * Devuelve el número de correos no leídos en la bandeja de entrada.
	 */
	int getUnreadCount();
}
