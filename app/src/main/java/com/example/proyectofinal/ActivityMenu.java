package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityMenu extends AppCompatActivity {

    Button add;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        add=findViewById(R.id.btnAgregandoNota);

        add.setOnClickListener(view ->{
         Intent b= new Intent(ActivityMenu.this,agregarnota.class);
         startActivity(b);
        });
     }
}



























