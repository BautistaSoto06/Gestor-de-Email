package com.app; 

import java.util.ArrayList;
import java.util.List;

public class GestorContactos {

        //Atributos propios
        private List<Contacto> listaContactos = new ArrayList<>();

        //Constructor vacío
        public GestorContactos(){
        }

        //Métodos
        public void add(Contacto contacto){
            this.listaContactos.add(contacto);
        }

        public int tamañoLista(){
            return this.listaContactos.size();
        }

        public List<Contacto> getListaContactos() {
            return this.listaContactos;
        }


        public List<Contacto> buscarPorNombre(String criterio){
        List<Contacto> resultados = new ArrayList<>();
        String criterioLower = criterio.toLowerCase();
        for(Contacto contacto:listaContactos){
            //Buscamos al contacto por el nombre
            String nombreContacto = contacto.getNombre().toLowerCase();

            if(nombreContacto.contains(criterioLower)){
                resultados.add(contacto); //Si coincide lo agregamos a "resultados."
                }
            }
        return resultados;
        }

        public void crearContacto(String nombre, String email) {
            Contacto nuevoContacto = new Contacto(nombre, email);
            this.add(nuevoContacto);
        }

        public List<Contacto> eliminarContacto(String criterio){
        List<Contacto> contactosParaEliminar = new ArrayList<>();
        String criterioLower = criterio.toLowerCase();
        for(Contacto contacto: listaContactos){
            String nombreContacto = contacto.getNombre().toLowerCase();
            if(nombreContacto.contains(criterioLower)){
                // Agregamos a la lista temporal, NO borramos todavía
                contactosParaEliminar.add(contacto); 
            }
        }
        listaContactos.removeAll(contactosParaEliminar);
        return contactosParaEliminar;
    }

    }