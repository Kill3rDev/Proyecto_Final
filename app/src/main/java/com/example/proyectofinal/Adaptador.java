package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Viewholder> {

    private List<Modelo> modeloclaseList;

    public Adaptador(List<Modelo> modeloclaseList){

        this.modeloclaseList = modeloclaseList;
    }



    @NonNull
    @Override
    public Adaptador.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.Viewholder viewholder, int position) {

        int resource = modeloclaseList.get(position).getImagenIcono();
        String titulo = modeloclaseList.get(position).getTitulo();
        String cuerpo = modeloclaseList.get(position).getCuerpo();
        viewholder.setData(resource,titulo,cuerpo);


    }

    @Override
    public int getItemCount() {
        return modeloclaseList.size();
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


