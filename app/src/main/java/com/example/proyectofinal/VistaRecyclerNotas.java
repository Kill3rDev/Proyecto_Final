package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.proyectofinal.Utilidades.utilidades;

import java.util.ArrayList;
import java.util.List;

public class VistaRecyclerNotas extends AppCompatActivity {

    ArrayList<Modelo> modeloList;
    RecyclerView  recyclerNotas;
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

        setOnClickListener();
        Adaptador adaptador = new Adaptador(modeloList);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerView.getChildAdapterPosition(view);
                view.findViewById(R.id.textTitle);

                String info=modeloList.get(recyclerView.getChildAdapterPosition(view)).getTitulo().toString();


                Toast toast = Toast.makeText(getBaseContext(), "esto manda: " + info,Toast.LENGTH_SHORT);
                toast.show();
                Intent bf = new Intent(VistaRecyclerNotas.this,detalle.class);
                startActivity(bf);

            }
        });

        recyclerView.setAdapter(adaptador);
        ConsultarListaNotas();
        adaptador.notifyDataSetChanged();

    }

    private void setOnClickListener() {
        listener = new Adaptador.RecyclerViewClickListener() {
            @Override
            public void OnClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), detalle.class);

                intent.putExtra("titulo" , modeloList.get(position).getTitulo());
                intent.putExtra("cuerpo", modeloList.get(position).getCuerpo());
                intent.putExtra("imageIcon" , modeloList.get(position).getImagenIcono());
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