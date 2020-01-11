package com.example.sergio.proto2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainPapelera extends AppCompatActivity {

    ListView ListaPapelera;
    UsuarioPrincipal usuarioPrincipal;
    dbProto proto;
    String Correo;
    //RegistroClass Usr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_papelera);
        setTitle("Papelera");
        ListaPapelera = (ListView) findViewById(R.id.lvListaPapelera);

        //Usr = (RegistroClass) getIntent().getExtras().get("Usuario");

    }
/*
    public void UpdateList()
    {
        usuarioPrincipal = proto.daoRegistro().ObtenerUsrPapelera(Correo);
        //usamos el mismo adaptador de UsuarioNotas ya que la papelera contiene los mismos parametros y solo
        //se mostrara la lista de nombre de las notas ya que estas para poder ser editaas se deben restaurar primero
        NotaP_Adapter adapter = new NotaP_Adapter(this,R.layout.item_notas,usuarioPrincipal.getListaNotas());
        ListaPapelera.setAdapter(adapter);
    }
*/
}
