package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity {

    Button btnIniciarSesion;
    Button btnRegistro;
    final private  int req=111;

    EditText a1;
    EditText a2;

    ConexionSQLiteHelper helper= new ConexionSQLiteHelper(this,"db_usuarios",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permis();

        btnIniciarSesion=findViewById(R.id.btnIniciarSesion);
        btnRegistro=findViewById(R.id.btnRegistro);


        a1=findViewById(R.id.editTextTextEmailAddress3);
        a2=findViewById(R.id.editTextTextPassword);


        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=a1.getText().toString();
                String pass1=a2.getText().toString();

                if ("".equals(user)){
                    a1.setError("Rellene campo");

                    if ("".equals(pass1)){
                        a2.setError("Rellene campos");
                    }
                }else{
                    if ("".equals(pass1)){
                        a2.setError("Rellene campo");
                    }else{
                        try {
                            Cursor curs=helper.consultauser(user,pass1);
                            if (curs.getCount()>0){
                                Toast toast = Toast.makeText(getBaseContext(), "Bienvenido: "+user,Toast.LENGTH_SHORT);
                                toast.show();
                                Intent bf = new Intent(MainActivity.this,ActivityMenu.class);
                                startActivity(bf);
                            }else{
                              Toast toast = Toast.makeText(getBaseContext(), "Usuario/contraseña incorrectos",Toast.LENGTH_SHORT);
                              toast.show();
                            }
                        }catch (SQLException e){
                          e.printStackTrace();
                        }
                    }
                }
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

    private void permis() {

    int camara= ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
    int audio=ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE);
    int escrit=ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.RECORD_AUDIO);

    if (camara!= PackageManager.PERMISSION_GRANTED||audio!=PackageManager.PERMISSION_GRANTED||escrit!=PackageManager.PERMISSION_GRANTED){
       if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
           requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_EXTERNAL_STORAGE},req);
       }
    }

    }
}