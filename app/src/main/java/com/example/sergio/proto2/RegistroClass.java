package com.example.sergio.proto2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "Usuarios")
public class RegistroClass implements Serializable {

    @PrimaryKey()
    @NonNull
    private String Correo;
    private String Nombre;
    private String Apellido;
    private String Contra;

    public RegistroClass() {
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setContra(String contra) {
        Contra = contra;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getContra() {
        return Contra;
    }
}
