package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMenu extends AppCompatActivity {


   Button btn;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btn.findViewById(R.id.btnAgregandoNota);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b= new Intent(ActivityMenu.this,agregarnota.class);
                startActivity(b);
            }
        });




        }
    }



























