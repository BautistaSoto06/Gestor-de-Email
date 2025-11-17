package com.app;

import java.util.List;

public class BandejaDeBorradores {
    
    private IBorradores almacenamientoBorrador;

    
    public BandejaDeBorradores(IBorradores borradorS) {
        this.almacenamientoBorrador = borradorS;
    }


    public String guardarNuevoBorrador(Correo borradorS) {
        borradorS.setStatus("borrador"); 
        return almacenamientoBorrador.guardarBorrador(borradorS);
    }

    
    public Correo abrirBorrador(String borradorId) {
        return almacenamientoBorrador.cargarBorrador(borradorId);
    }

    
    public void eliminarBorrador(String borradorId) {
        almacenamientoBorrador.eliminarBorrador(borradorId);
    }

    public List<Correo> getTodosLosBorradores() {
        return almacenamientoBorrador.listarBorradores();
    }
}