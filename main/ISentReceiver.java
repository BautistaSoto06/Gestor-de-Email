
package main;

/**
 * Interfaz que declara el contrato mínimo para consultar correos electrónicos enviados.
 */
public interface ISentReceiver {
	/**
	 * Devuelve la lista de correos enviados.
	 */
	String[][] getSentEmails();

	/**
	 * Actualiza la lista de correos enviados (simula el envío de nuevos correos).
	 */
	void updateSent();

	/**
	 * Marca un correo enviado como importante.
	 */
	void markImportant(int index);

	/**
	 * Devuelve el número de correos enviados.
	 */
	int getSentCount();
}
