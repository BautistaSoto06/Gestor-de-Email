package com.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class BandejaDeEliminados implements IEliminarCorreo {
    
    private Map<String, Correo> almacenDeEliminados = new HashMap<>();
    
    private Map<Correo, String> idsInversos = new HashMap<>();

    public BandejaDeEliminados() {
    }

    @Override
    public void moverAEliminados(Correo correo) {
        if (correo != null) {
            correo.setStatus("eliminado");
            String id = generarId();
            almacenDeEliminados.put(id, correo);
            idsInversos.put(correo, id); 
        }
    }

    @Override
    public boolean restaurar(String correoId) {
        if (almacenDeEliminados.containsKey(correoId)) {
            Correo c = almacenDeEliminados.remove(correoId);
            if (c != null) {
                idsInversos.remove(c);
                c.setStatus("recibido"); 
            }
            return true;
        }
        return false;
    }

    // Método compatible con tus tests antiguos
    public boolean restaurarCorreo(String correoId) {
        return restaurar(correoId);
    }

    @Override
    public void eliminarDefinitivo(String correoId) {
        Correo c = almacenDeEliminados.remove(correoId);
        if (c != null) {
            idsInversos.remove(c);
        }
    }

    @Override
    public List<Correo> listarEliminados() {
        return new ArrayList<>(almacenDeEliminados.values());
    }

    public List<Correo> getTodosLosEliminados() {
        return listarEliminados();
    }

    @Override
    public boolean existeEnEliminados(String correoId) {
        return almacenDeEliminados.containsKey(correoId);
    }

    public boolean existeEliminado(String correoId) {
        return existeEnEliminados(correoId);
    }

    @Override
    public String getIdDeCorreo(Correo correo) {
        return idsInversos.get(correo);
    }

    // Generador de ID aleatorio (Lógica de Borradores)
    private String generarId() {
        long id = ThreadLocalRandom.current().nextLong(1000, 100000);
        return Long.toString(id);
    }
}