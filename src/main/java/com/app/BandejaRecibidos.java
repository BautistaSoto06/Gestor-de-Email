package com.app;

import java.util.ArrayList;
import java.util.List;

public class BandejaRecibidos {
    private List<Correo> correosRecibidos;

    public BandejaRecibidos() {
        this.correosRecibidos = new ArrayList<>();
    }

    public void agregarCorreo(Correo correo) {
        correosRecibidos.add(correo);
    }

    public List<Correo> getCorreos() {
        return correosRecibidos;
    }
}