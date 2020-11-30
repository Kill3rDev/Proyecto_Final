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
 // este es el recycler

    //atributos del recycler
    ArrayList<Modelo> modeloList;
    RecyclerView  recyclerNotas;
    //List<Modelo> modeloList = new ArrayList<>();

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
        ConsultarListaNotas();


        //modeloList.add(new Modelo(R.drawable.ic_launcher_background, "Este es el titulo 1", "Este es el titulo 1 de usuario"));

        Adaptador adaptador = new Adaptador(modeloList);
        recyclerView.setAdapter(adaptador);

        adaptador.notifyDataSetChanged();
    }


    //metodo para consultar y agregar

    private void ConsultarListaNotas() {

        SQLiteDatabase db =coon.getReadableDatabase();

        Modelo modelo = null;

        Cursor cursor = db.rawQuery("SELECT * FROM  " + utilidades.TABLA_NOTA,null);

        while (cursor.moveToNext()){

            modelo = new Modelo();
            modelo.setTitulo(cursor.getString(1));
            modelo.setCuerpo(cursor.getString(2));

            modeloList.add(modelo);



        }
    }
}