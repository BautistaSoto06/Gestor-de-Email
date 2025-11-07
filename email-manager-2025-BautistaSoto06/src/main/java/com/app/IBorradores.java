package com.app;

import java.util.List;

public interface IBorradores {
    // funciones basicas de gestión de borradores
    void guardarBorrador(SendMail borrador);
    SendMail cargarBorrador(String borradorId);
    List<SendMail> listarBorradores();
    void eliminarBorrador(String borradorId);
    
    // Verificación
    boolean existeBorrador(String borradorId);

}