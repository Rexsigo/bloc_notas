package com.example.sergio.proto2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DaoPapelera {
    @Insert
    void Insertar(Papelera papelera);

    @Delete
    void Eliminar(Papelera papelera);

    @Query("Select * From Papelera")
    List<Papelera> ObtenerTodo();

    @Query("Select * From Papelera Where Correo=:id")
    List<Papelera> ObtenerporId(String id);
}
