package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnIniciarSesion;
    Button btnRegistro;

    // EditText a1; SOSPECHA DE ERRROR DE CIERRE
    // EditText a2; SOSPECHA DE ERRROR DE CIERRE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarSesion=findViewById(R.id.btnIniciarSesion);
        btnRegistro=findViewById(R.id.btnRegistro);
        //a1=findViewById(R.id.editTextTextEmailAddress); SOSPECHA DE ERRROR DE CIERRE
       // a2=findViewById(R.id.editTextTextPassword); SOSPECHA DE ERRROR DE CIERRE


       btnIniciarSesion.setOnClickListener(view -> {
            //if (a1.getText().toString().length()==0){ SOSPECHA DE ERRROR DE CIERRE
               Toast toast = Toast.makeText(getBaseContext(), "Bienvenido: ",Toast.LENGTH_SHORT);
               toast.show();
            //}else{ SOSPECHA DE ERRROR DE CIERRE
                Intent b = new Intent(MainActivity.this,ActivityMenu.class);
                startActivity(b);
            //}
       });

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //7Toast toast = new Toast.makeText(getBaseContext(), "Bienvenido: ", Toast.LENGTH_SHORT);
                ///toast.show();
                Intent c = new Intent( MainActivity.this, ActivityMenu.class);
                startActivity(c);
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