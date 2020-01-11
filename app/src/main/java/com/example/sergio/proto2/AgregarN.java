package com.example.sergio.proto2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AgregarN extends AppCompatActivity {
    EditText NombreNota;
    Button Agregar;
    String Correo;
    dbProto proto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_n);
        NombreNota = (EditText) findViewById(R.id.tvNombreNota);
        Agregar = (Button) findViewById(R.id.btAgregar);
        Correo = getIntent().getStringExtra("CorreoUSR");
        Toast.makeText(this,Correo, Toast.LENGTH_LONG).show();
        proto = Room.databaseBuilder(this,dbProto.class,"Proto").allowMainThreadQueries().build();
    }

    public void Guardar(View view)
    {
        NotaPrincipal notaPrincipal = new NotaPrincipal();
        notaPrincipal.setCorreo(Correo);
        notaPrincipal.setNombreNota(NombreNota.getText().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YY", Locale.getDefault());
        Date date = new Date();
        String Fecha = simpleDateFormat.format(date);
        notaPrincipal.setFecha(Fecha);
        proto.daoNotaPrincipal().Insertar(notaPrincipal);
        Intent intent = new Intent();
        intent.putExtra("NotaAgregada",notaPrincipal);
        setResult(RESULT_OK,intent);
        finish();
    }
}
