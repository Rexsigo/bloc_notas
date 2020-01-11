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

public class UsuarioAdapter extends ArrayAdapter {

    private List<RegistroClass> Usuarios;
    private int resource;
    private Context context;

    public UsuarioAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource,objects);
        this.context = context;
        this.resource = resource;
        this.Usuarios = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(this.context).inflate(this.resource,parent,false);
        //obtener los controles
        TextView tvNombre = (TextView) convertView.findViewById(R.id.tvNombreItem);
        TextView tvApellido = (TextView) convertView.findViewById(R.id.tvApellidoItem);
        TextView tvCorreo = (TextView) convertView.findViewById(R.id.tvCorreoItem);
        TextView tvContra = (TextView) convertView.findViewById(R.id.tvContraItem);

        //setear los item de la lista
        tvNombre.setText(Usuarios.get(position).getNombre());
        tvApellido.setText(Usuarios.get(position).getApellido());
        tvCorreo.setText(Usuarios.get(position).getCorreo());
        tvContra.setText(Usuarios.get(position).getContra());
        return convertView;
    }
}
