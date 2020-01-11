package com.example.sergio.proto2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DaoRegistro {
    @Insert
    void Insertar(RegistroClass registroClass);

    @Delete
    void Eliminar(RegistroClass registroClass);

    @Update
    void Actualizar(RegistroClass registroClass);

    @Query("Select * From Usuarios")
    List<RegistroClass> ObtenerTodo();

    @Query("Select * From Usuarios Where Correo=:Email")
    RegistroClass ObtenerPorCorreo(String Email);

    @Query("Select * From Usuarios Where Correo=:Email")
    UsuarioPrincipal ObtenerUsrNota(String Email);

    @Query("Select * From Usuarios Where Correo=:Email")
    UsuarioPrincipal ObtenerUsrPapelera(String Email);

}
