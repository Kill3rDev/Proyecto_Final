package com.example.proyectofinal;

import android.media.Image;
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

    private ArrayList<Modelo> modeloList;

    //PASO 3 crear el listener


    private RecyclerViewClickListener listener;

    ///PASO 5 agregar como parametro recyclerviewlistener a este metodo llamado adaptador

    public Adaptador(ArrayList<Modelo> modeloList,  RecyclerViewClickListener listener){

        this.modeloList = modeloList;
        this.listener = listener;
    }

    //PASO 4
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView txttitulo;
        private TextView txtDescripcion;
        private TextView  txtNota;
        private TextView txtFechaHora;

        public MyViewHolder(final View view ){

            super(view);

            ////Aqui creo que van las variables que estan los datos de la nota para que se invoquen en el nuevo activity, creo que los debe tomar del layout agregarnota

            ///pero no estoy seguro, lo marco asi entre comentarios

            //////////////////////////////////////////////////
            txttitulo = view.findViewById(R.id.textTitle);
            txtDescripcion = view.findViewById(R.id.txtDescripcion);
            txtNota = view.findViewById(R.id.txtNota);
            txtFechaHora = view.findViewById(R.id.fech);

            //////////////////////////////////////////////////////
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.OnClick(view, getAdapterPosition());

        }
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
        viewholder.setData(resource,titulo,cuerpo);
    }

    @Override
    public int getItemCount() {
        return modeloList.size();
    }






    //PASO 2

    public interface RecyclerViewClickListener {

        void OnClick ( View v , int position);

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

        private void setData(int imageResource, String titulotexto, String cuerpoTexto){

            imageView.setImageResource(imageResource);
            titulo.setText(titulotexto);
            cuerpo.setText(cuerpoTexto);
        }
    }
}


