package com.example.sergio.proto2;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UsuarioPapelera {
    @Embedded
    private RegistroClass Usuario;

    @Relation(parentColumn = "Correo", entityColumn = "Correo")
    private List<Papelera> ListaNotas;

    public UsuarioPapelera() {
    }

    public void setUsuario(RegistroClass usuario) {
        Usuario = usuario;
    }

    public void setListaNotas(List<Papelera> listaNotas) {
        ListaNotas = listaNotas;
    }

    public RegistroClass getUsuario() {
        return Usuario;
    }

    public List<Papelera> getListaNotas() {
        return ListaNotas;
    }
}
