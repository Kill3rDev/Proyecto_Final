package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VistaRecyclerNotas extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_recycler_notas);

        recyclerView=findViewById(R.id.RecyclerView);

        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        List<Modelo> modeloList = new ArrayList<>();
        modeloList.add(new Modelo(R.drawable.ic_launcher_background, "Este es el titulo 1", "Este es el titulo 1 de usuario"));

        Adaptador adaptador = new Adaptador(modeloList);
        recyclerView.setAdapter(adaptador);

        adaptador.notifyDataSetChanged();
    }
}