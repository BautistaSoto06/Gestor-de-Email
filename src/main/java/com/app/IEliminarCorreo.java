package com.app;

import java.util.List;

public interface IEliminarCorreo {
    
    void moverAEliminados(Correo correo);

    boolean restaurar(String correoId);

    void eliminarDefinitivo(String correoId);

    List<Correo> listarEliminados();

    boolean existeEnEliminados(String correoId);

    String getIdDeCorreo(Correo correo);
}