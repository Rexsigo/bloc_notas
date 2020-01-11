package com.example.sergio.proto2;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UsuarioPrincipal {
    @Embedded
    private RegistroClass Usuario;

    @Relation(parentColumn = "Correo", entityColumn = "Correo")

    private List<NotaPrincipal> ListaNotas;

    public UsuarioPrincipal() {
    }

    public void setUsuario(RegistroClass usuario) {
        Usuario = usuario;
    }

    public void setListaNotas(List<NotaPrincipal> listaNotas) {
        ListaNotas = listaNotas;
    }

    public RegistroClass getUsuario() {
        return Usuario;
    }

    public List<NotaPrincipal> getListaNotas() {
        return ListaNotas;
    }
}
