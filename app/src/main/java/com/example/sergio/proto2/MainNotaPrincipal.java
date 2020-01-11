package com.example.sergio.proto2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainNotaPrincipal extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView ListaNota;
    //NotaPrincipal notaPrincipal;
    UsuarioPrincipal usuarioPrincipal;
    //List<RegistroClass> ListNotaPrincipal;
    dbProto proto;
    RegistroClass Usr;
    String Correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nota_principal);
        setTitle("Notas");

        ListaNota = (ListView) findViewById(R.id.lvListaNotas);

        Usr = (RegistroClass) getIntent().getExtras().get("Usuario");

        proto = Room.databaseBuilder(this,dbProto.class,"Proto").allowMainThreadQueries().build();

        Correo = Usr.getCorreo();

        UpdateList();

        registerForContextMenu(ListaNota);

        ListaNota.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }

    public void UpdateList()
    {
        usuarioPrincipal = proto.daoRegistro().ObtenerUsrNota(Correo);
        NotaP_Adapter adapter = new NotaP_Adapter(this,R.layout.item_notas,usuarioPrincipal.getListaNotas());
        ListaNota.setAdapter(adapter);
    }

    public void Mas(View view)
    {
        Intent intent = new Intent(this,AgregarN.class);
        //String Correo = data.getExtras().get("");
        intent.putExtra("CorreoUSR",Usr.getCorreo());
        //startActivity(intent);
        startActivityForResult(intent,111);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pricipal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_item,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_Agregar:
                Intent intent = new Intent(this,AgregarN.class);
                intent.putExtra("CorreoUSR",Usr.getCorreo());
                startActivityForResult(intent,111);
                Toast.makeText(this,"OptionItemAgregar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subMenu_Papelera:
                Intent intent2 = new Intent(this,MainPapelera.class);
                intent2.putExtra("CorreoUSR",Usr.getCorreo());
                startActivityForResult(intent2,113);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId())
        {
            case R.id.context_menu_Eliminar:
                Toast.makeText(this,"Elminar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.context_menu_Enviar_Papelera:

        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK)
        {
            if (requestCode == 111)
            {
                //Actualizar la lista
                //NotaPrincipal notaPrincipal =(NotaPrincipal) data.getExtras().get("NotaAgregada");
                //usuarioPrincipal = proto.daoRegistro().ObtenerUsrNota(Correo);
                //usuarioPrincipal.getListaNotas().add(notaPrincipal);
                //usuarioPrincipal = proto.daoRegistro().ObtenerUsrNota(Correo);
                //NotaP_Adapter np = (NotaP_Adapter) ListaNota.getAdapter();
                //np.notifyDataSetChanged();
                Toast.makeText(this,"Regresando de Agregar", Toast.LENGTH_SHORT).show();
                UpdateList();
            }

            if (requestCode == 112)
            {
                //Actualizar la lista de items
                Toast.makeText(this,"Regresando de la actualizacion", Toast.LENGTH_SHORT).show();
                UpdateList();
            }

        }else if (resultCode == RESULT_CANCELED)
        {
            if (requestCode == 112)
            {
                Toast.makeText(this,"Cancelado Actualizar", Toast.LENGTH_SHORT).show();
            }

            if (requestCode == 111)
            {
                Toast.makeText(this,"Cancelado el Insert", Toast.LENGTH_SHORT).show();
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        NotaPrincipal notaPrincipal = (NotaPrincipal) adapterView.getItemAtPosition(i);
        //Toast.makeText(this,notaPrincipal.getNombreNota(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ActualizarNota.class);
        intent.putExtra("NotaP",notaPrincipal);
        startActivityForResult(intent,112);
    }
/*
    private void ListViewUpdate()
    {
        ((NotaP_Adapter) ListaNota.getAdapter()).notifyDataSetChanged();
    }
    */
}
