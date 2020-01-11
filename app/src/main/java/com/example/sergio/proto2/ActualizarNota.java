package com.example.sergio.proto2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActualizarNota extends AppCompatActivity {

    EditText editText;
    EditText tvNombre;
    NotaPrincipal notaPrincipal;
    dbProto proto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_nota);
        editText = findViewById(R.id.edt_MultiLine);
        tvNombre = findViewById(R.id.tv_Nombre);

        notaPrincipal =(NotaPrincipal) getIntent().getExtras().get("NotaP");
        editText.setText(notaPrincipal.getAnotaciones());
        tvNombre.setText(notaPrincipal.getNombreNota());
        proto = Room.databaseBuilder(this,dbProto.class,"Proto").allowMainThreadQueries().build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_guardar_deactualizar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mn_item_actualizar:
                notaPrincipal.setAnotaciones(editText.getText().toString());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YY", Locale.getDefault());
                Date date = new Date();
                String Fecha = simpleDateFormat.format(date);
                notaPrincipal.setFecha(Fecha);
                notaPrincipal.setNombreNota(tvNombre.getText().toString());
                proto.daoNotaPrincipal().Actualizar(notaPrincipal);
                Intent intent = new Intent();
                intent.putExtra("NotaActualizada",notaPrincipal);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.mn_item_cancelar:
                setResult(RESULT_CANCELED);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
