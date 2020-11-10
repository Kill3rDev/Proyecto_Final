package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity {

    Button btnIniciarSesion;
    Button btnRegistro;

    EditText a1;
    EditText a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarSesion=findViewById(R.id.btnIniciarSesion);
        btnRegistro=findViewById(R.id.btnRegistro);
        a1=findViewById(R.id.editTextTextEmailAddress);
        a2=findViewById(R.id.editTextTextPassword);


        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a1.setError("Prueba advertencia");
                //String user=a1.getText().toString();

                //if ("".equals(user)){
                  //  a1.setError("Rellene campo");
                //}

                Toast toast = Toast.makeText(getBaseContext(), "Bienvenido: ",Toast.LENGTH_SHORT);
                toast.show();
                Intent b = new Intent(MainActivity.this,ActivityMenu.class);
                startActivity(b);
            }
        });



        btnRegistro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent a= new Intent(MainActivity.this,ActivityRegis.class);
                startActivity(a);
            }
        });
    }
}