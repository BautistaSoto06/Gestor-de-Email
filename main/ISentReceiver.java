package main;

public interface ISentReceiver {
	//lista de correos enviados
	String[][] getSentEmails();

	//actualiza la lista de correos enviados
	void updateSent();

	//marca un correo enviado como importante
	void markImportant(int index);

	//devuelve el número de correos enviados
	int getSentCount();
}
