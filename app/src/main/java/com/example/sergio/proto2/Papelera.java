package com.example.sergio.proto2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys =
@ForeignKey(entity = RegistroClass.class,parentColumns = "Correo",childColumns = "Correo",
        onDelete = CASCADE,onUpdate = CASCADE))
public class Papelera {

    @PrimaryKey
    private int idNota;
    private String Correo;
    private String NombreNota;
    private String Fecha;
    private String Hora;
    private String Anotaciones;

    public Papelera() {
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public void setNombreNota(String nombreNota) {
        NombreNota = nombreNota;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public void setAnotaciones(String anotaciones) {
        Anotaciones = anotaciones;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public int getIdNota() {
        return idNota;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getNombreNota() {
        return NombreNota;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getAnotaciones() {
        return Anotaciones;
    }

    public String getHora() {
        return Hora;
    }
}

