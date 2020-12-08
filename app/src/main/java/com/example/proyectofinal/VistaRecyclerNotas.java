package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.proyectofinal.Utilidades.utilidades;

import java.util.ArrayList;
import java.util.List;

public class VistaRecyclerNotas extends AppCompatActivity {

    ArrayList<Modelo> modeloList;
    RecyclerView  recyclerNotas;
//// PASO 6 crear variable listener de tipo adaptador
    private Adaptador.RecyclerViewClickListener listener;


    ConexionSQLiteHelper coon;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vista_recycler_notas);

        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        coon = new ConexionSQLiteHelper(getApplicationContext(), "db_usuarios",null,1);
         modeloList = new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(layoutManager);



        ///Paso 7 implementar este medodo
        setOnClickListener();
        //paso 8 , agregar como parametro el listener,
        Adaptador adaptador = new Adaptador(modeloList);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerView.getChildAdapterPosition(view);
                view.findViewById(R.id.textTitle);

                Modelo modelo = new Modelo();

               modelo = modeloList.get(recyclerView.getChildAdapterPosition(view));





            }
        });

        recyclerView.setAdapter(adaptador);
        ConsultarListaNotas();
        adaptador.notifyDataSetChanged();

    }

    ///Paso7.1
    private void setOnClickListener() {
        listener = new Adaptador.RecyclerViewClickListener() {
            @Override
            public void OnClick(View v, int position) {
                //Aqui es donde va la el layout detalle
                Intent intent = new Intent(getApplicationContext(), detalle.class);

                ///Aqui creo que van mas cosas de la nota pero estoy algo confundido como nada mas las toma del la clase modelo que es como la que contruye la nota
                /// (opcion)lo podriamos dejar asi

                intent.putExtra("titulo" , modeloList.get(position).getTitulo());
                intent.putExtra("cuerpo", modeloList.get(position).getCuerpo());
                intent.putExtra("imageIcon" , modeloList.get(position).getImagenIcono());

                //IniciandoActividad
                startActivity(intent);

            }
        };
    }

    private void ConsultarListaNotas() {

        SQLiteDatabase db =coon.getReadableDatabase();

        Modelo modelo = null;

        Cursor cursor = db.rawQuery("SELECT * FROM  " + utilidades.TABLA_NOTAS,null);

        while (cursor.moveToNext()){

            modelo = new Modelo();
            modelo.setImagenIcono(R.drawable.note);
            modelo.setTitulo(cursor.getString(0));
            modelo.setCuerpo(cursor.getString(1));
            modeloList.add(modelo);
        }
    }
}