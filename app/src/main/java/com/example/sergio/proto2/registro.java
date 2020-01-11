package com.example.sergio.proto2;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class registro extends AppCompatActivity {
    EditText edtNombre;
    EditText edtApellido;
    EditText edtCorreo;
    EditText edtContra;
    Button btnEnviar;
    TextView tvTienes;
   // ImageView ImagenGuardar;
    //Variable para invocar a la base de datos
    dbProto dbProto;
    //para obtener la imagen de galeria
    private static final int ImagenSeleccionada = 100;
    //Uri RutaImagenSeleccionada;
    //String RutaEnString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtApellido =(EditText) findViewById(R.id.edtApellido);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        edtContra = (EditText) findViewById(R.id.Contra);
        //ImagenGuardar = (ImageView) findViewById(R.id.imagenguardar);
        //ImagenGuardar.setImageResource(R.drawable.one);
        //instanciar a la base de datos
        //Parametros: ActividadActual, ClaseDeLaBaseDeDatos, NombreDeLaBaseDeDatos
        dbProto = Room.databaseBuilder(this,dbProto.class,"Proto").allowMainThreadQueries().build();

        //agregar evento al control ImagenView
       /* ImagenGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AbrirGaleria();
            }
        });*/

    }

    //abrir la galeria y obtener una imagen de ella mediante una actividad
   /* public void AbrirGaleria()
    {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        //Guardar la ruta supuestamente de la imagen seleccionada al abrir la actividad
        startActivityForResult(intent,ImagenSeleccionada);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == ImagenSeleccionada)
        {
            RutaImagenSeleccionada = data.getData();
            RutaEnString = RutaImagenSeleccionada.toString();
            ImagenGuardar.setImageURI(RutaImagenSeleccionada);
            edtContra.setText(RutaEnString);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
*/
    public void Guardar(View view)
    {
        //Toast.makeText(getApplicationContext(),edtNombre.getText().toString(),Toast.LENGTH_SHORT).show();
        RegistroClass NuevoUsuario = new RegistroClass();

        NuevoUsuario.setNombre(edtNombre.getText().toString());
        NuevoUsuario.setApellido(edtApellido.getText().toString());
        NuevoUsuario.setCorreo(edtCorreo.getText().toString());
        NuevoUsuario.setContra(edtContra.getText().toString());

        dbProto.daoRegistro().Insertar(NuevoUsuario);
        //Intent intent = new Intent(this,MainActivity.class);
        //startActivity(intent);
        finish();//finalizar una actividad
    }

    public void Regresar(View view)
    {
        finish();
    }
}
