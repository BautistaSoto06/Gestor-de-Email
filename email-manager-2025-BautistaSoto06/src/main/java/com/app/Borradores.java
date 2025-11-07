package com.app;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Borradores implements IBorradores {
    
    // Almacenamiento simple en memoria
    private Map<String, SendMail> borradores = new HashMap<>();
    

    //guardar borrador de forma manual
    @Override
    public void guardarBorrador(SendMail borrador) {
        if (borrador != null) {
            String id = generarId(borrador);
            borradores.put(id, borrador);
        }
    }

    //cargar borrador por id
    @Override
    public SendMail cargarBorrador(String borradorId) {
        return borradores.get(borradorId);
    }
    
    //listar todos los borradores
    @Override
    public List<SendMail> listarBorradores() {
        return new ArrayList<>(borradores.values());
    }

    //Eliminar borrador por id
    @Override
    public void eliminarBorrador(String borradorId) {
        borradores.remove(borradorId);
    }

    // Verificar si un borrador existe
    @Override
    public boolean existeBorrador(String borradorId) {
        return borradores.containsKey(borradorId);
    }
    
    // Método auxiliar para generar IDs simples
    private String generarId(SendMail borrador) {
        return "draft_" + System.currentTimeMillis();
    }
}
