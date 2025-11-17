package com.app;

import java.util.List;

public interface IBorradores {
    
    String guardarBorrador(Correo borrador);
    
    Correo cargarBorrador(String borradorId);
    
    List<Correo> listarBorradores();
    
    void eliminarBorrador(String borradorId);
    
    boolean existeBorrador(String borradorId);
}