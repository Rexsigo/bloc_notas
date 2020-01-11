package com.example.sergio.proto2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(version = 8, entities = {RegistroClass.class,NotaPrincipal.class,Papelera.class})
public abstract class dbProto extends RoomDatabase {
    public abstract DaoRegistro daoRegistro();
    public abstract DaoNotaPrincipal daoNotaPrincipal();
    public abstract DaoPapelera daoPapelera();
}
