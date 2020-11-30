package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Viewholder> {
    //Este es el adaptador

    private ArrayList<Modelo> modeloList;

    public Adaptador(ArrayList<Modelo> modeloList){

        this.modeloList = modeloList;
    }



    @NonNull
    @Override
    public Adaptador.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.Viewholder viewholder, int position) {

        int resource = modeloList.get(position).getImagenIcono();
        String titulo = modeloList.get(position).getTitulo();
        String cuerpo = modeloList.get(position).getCuerpo();
        viewholder.setData(resource,titulo,cuerpo);


    }

    @Override
    public int getItemCount() {
        return modeloList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {


        private ImageView imageView;
        private TextView titulo;
        private TextView cuerpo;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewnota);
            titulo = itemView.findViewById(R.id.textTitle);
            cuerpo = itemView.findViewById(R.id.txtDescripcion);

        }

        private void setData(int imageResource,  String titulotexto, String cuerpoTexto){

            imageView.setImageResource(imageResource);
            titulo.setText(titulotexto);
            cuerpo.setText(cuerpoTexto);

        }

    }
}


