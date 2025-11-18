package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


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

    public List<Correo> getLeidos() {
        List<Correo> leidos = new ArrayList<>();
        for (Correo e : correosRecibidos) {
            if (e.isLeido()) leidos.add(e);
        }
        return leidos;
    }

    public List<Correo> getNoLeidos() {
        List<Correo> noLeidos = new ArrayList<>();
            for (Correo e : correosRecibidos) {
                if (!e.isLeido()) noLeidos.add(e);
            }
            return noLeidos;
    }

    public List<Correo> buscarPorAsunto(String criterio){
        return correosRecibidos.stream()
                .filter(c -> c.getAsunto().toLowerCase().contains(criterio.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Correo> buscarPorRemitente(String criterio){
        return correosRecibidos.stream()
                .filter(c -> c.getRemitente().toLowerCase().contains(criterio.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Correo> buscarPorContenido(String criterio){
        return correosRecibidos.stream()
                .filter(c -> c.getContenido().toLowerCase().contains(criterio.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Correo> filtrarPorAsuntoYEsImportante(String texto) {
    String t = texto.toLowerCase();
        Predicate<Correo> porAsunto = e -> 
                e.getAsunto().toLowerCase().contains(t);
        Predicate<Correo> porImportante = Correo::esImportante;
    return correosRecibidos.stream()
            .filter(porAsunto.and(porImportante))
            .toList();
    }


    public List<Correo> filtrarPorRemitenteYContenido(String remitenteParcial, String textoContenido) {
    String r = remitenteParcial.toLowerCase();
    String c = textoContenido.toLowerCase();
        Predicate<Correo> porRemitente = e ->
                e.getRemitente().toLowerCase().contains(r);
        Predicate<Correo> porContenido = e ->
                e.getContenido().toLowerCase().contains(c);

    return correosRecibidos.stream()
            .filter(porRemitente.and(porContenido))
            .toList();
    }



}