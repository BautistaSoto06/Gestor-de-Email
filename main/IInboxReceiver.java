
package main;


public interface IInboxReceiver {
	//lista de correos en la bandeja de entrada
	String[][] getInboxEmails();
	
	//actualiza la bandeja de entrada
	void receive();

	//marca un correo de la bandeja de entrada como leído
	void markRead(int index);

	//devuelve el número de correos no leídos en la bandeja de entrada
	int getUnreadCount();
}
