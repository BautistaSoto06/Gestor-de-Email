package com.app;

import java.util.ArrayList;
import java.util.List;

public class BandejaEnviados {

    private List<Correo> correos;

    public BandejaEnviados() {
        this.correos = new ArrayList<>();
    }

    public void agregarCorreo(Correo correo) {
        this.correos.add(correo);
    }

    public List<Correo> getCorreos() {
        return this.correos;
    }

    public int cantidadCorreos() {
        return this.correos.size();
    }
}

