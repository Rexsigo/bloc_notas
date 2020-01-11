package com.example.sergio.proto2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NotaP_Adapter extends ArrayAdapter {
    private List<NotaPrincipal> ListaNotas;
    private Context context;
    private int resource;


    public NotaP_Adapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.ListaNotas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(this.context).inflate(this.resource,parent,false);

        //Extraer los controles que estan en el layout que servira como item de la lista
        TextView NombreNota = (TextView) convertView.findViewById(R.id.tvNombreItemNota);
        //texto defecha
        TextView Fecha = (TextView) convertView.findViewById(R.id.tv_Fecha);

        //Agregarles Datos
        NombreNota.setText(ListaNotas.get(position).getNombreNota());
        Fecha.setText(ListaNotas.get(position).getFecha());
        //Fecha.setText(ListaNotas.get(position));
        return convertView;
    }
}
