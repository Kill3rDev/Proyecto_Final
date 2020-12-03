package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.proyectofinal.Utilidades.utilidades;

import java.util.ArrayList;
import java.util.List;

public class VistaRecyclerNotas extends AppCompatActivity {

    ArrayList<Modelo> modeloList;
    RecyclerView  recyclerNotas;

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



        Adaptador adaptador = new Adaptador(modeloList);
        recyclerView.setAdapter(adaptador);
        ConsultarListaNotas();
        adaptador.notifyDataSetChanged();
    }

    private void ConsultarListaNotas() {

        SQLiteDatabase db =coon.getReadableDatabase();

        Modelo modelo = null;

        Cursor cursor = db.rawQuery("SELECT * FROM  " + utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){

            modelo = new Modelo();
            modelo.setImagenIcono(R.drawable.note);
            modelo.setTitulo(cursor.getString(0));
            modelo.setCuerpo(cursor.getString(1));
            modeloList.add(modelo);
        }
    }
}