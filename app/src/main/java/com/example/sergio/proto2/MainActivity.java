package com.example.sergio.proto2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtCorreo;
    EditText edtContra;
    Button btnLogin;
    TextView tvRegistro;
    TextView tvError;
    ListView lista;
    String NombreUsuario;
    dbProto dbProto;
   // RegistroClass User;
    private List<RegistroClass> ListaUsuarios = new ArrayList<>();

    //private static final int PICK_IMAGE = 100;
    //private Uri ImgUri;
    //ImageView imPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Inicio de Sesion");
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        edtContra = (EditText) findViewById(R.id.edtContra);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegistro = (TextView) findViewById(R.id.tvRegistro);
        tvError = (TextView) findViewById(R.id.tvEerror);
        lista = (ListView) findViewById(R.id.lvUsuarios);

        //instanciar a la base de datos
        //Parametros: ActividadActual, ClaseDeLaBaseDeDatos, NombreDeLaBaseDeDatos
        dbProto = Room.databaseBuilder(this,dbProto.class,"Proto").allowMainThreadQueries().build();
        ListaUsuarios.addAll(dbProto.daoRegistro().ObtenerTodo());
        UsuarioAdapter adapter = new UsuarioAdapter(this,R.layout.layout_item_user,ListaUsuarios);
        lista.setAdapter(adapter);
        //List<RegistroClass> reg = dbProto.daoRegistro().ObtenerTodo();

        //UsuarioAdapter adapter = new UsuarioAdapter(this, R.layout.layout_item_user, reg);
        //lista.setAdapter(adapter);
        //imPrueba = (ImageView) findViewById(R.id.imagendeprueba);
        //imPrueba.setImageResource(R.drawable.one);
        //imPrueba.setImageResource(R.drawable.one);
        /*imPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AbrirGaleria();
            }
        });*/
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE);
        {
            ImgUri = data.getData();
            //uriString = ImgUri.toString();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void AbrirGaleria()
    {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent,PICK_IMAGE);
    }
*/
    public void Registrarse( View view)
    {
        Intent intent = new Intent(this,registro.class);
        intent.putExtra("Usuario", NombreUsuario);
        startActivity(intent);
    }

    public void Login(View view)
    {
        String Email;
        String Contra;
        Email = edtCorreo.getText().toString();
        Contra = edtContra.getText().toString();

        RegistroClass Usr = dbProto.daoRegistro().ObtenerPorCorreo(Email);
        //RegistroClass Usr = dbProto.daoRegistro().ObtenerPorId(Integer.parseInt(Email));
        //Contra = String.valueOf(Usr.getId_Usuario());
        //Toast.makeText(this,Usr.getCorreo(),Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,MainNotaPrincipal.class);
        intent.putExtra("Usuario",Usr);
        startActivity(intent);
    }
}
