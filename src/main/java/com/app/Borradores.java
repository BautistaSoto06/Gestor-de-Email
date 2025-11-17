package com.app;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom; 

public class Borradores implements IBorradores {
    
    private Map<String, Correo> almacenDeBorradores = new HashMap<>();
    
    
    @Override
    public String guardarBorrador(Correo borrador) {
        if (borrador == null) {
            return null;
        }
        String id = generarId(borrador);
        almacenDeBorradores.put(id, borrador);
        
        return id;
    }

    @Override
    public Correo cargarBorrador(String borradorId) {
        return almacenDeBorradores.get(borradorId);
    }
    
    @Override
    public List<Correo> listarBorradores() {
        return new ArrayList<>(almacenDeBorradores.values());
    }

    @Override
    public void eliminarBorrador(String borradorId) {
        almacenDeBorradores.remove(borradorId);
    }

    @Override
    public boolean existeBorrador(String borradorId) {
        return almacenDeBorradores.containsKey(borradorId);
    }

    private String generarId(Correo borrador) {
        long id = ThreadLocalRandom.current().nextLong(1000, 100000);
        return Long.toString(id);
    }
}