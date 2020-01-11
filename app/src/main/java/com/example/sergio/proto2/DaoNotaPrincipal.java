package com.example.sergio.proto2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DaoNotaPrincipal {
    @Insert
    void Insertar(NotaPrincipal principal);

    @Delete
    void Eliminar(NotaPrincipal principal);

    @Update
    void Actualizar(NotaPrincipal principal);

    @Query("Select * From Principal")
    List<NotaPrincipal> ObtenerTodo();

    @Query("Select * From Principal Where Correo=:id")
    List<NotaPrincipal> ObtenerporId(String id);
}
