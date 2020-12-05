package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.Utilidades.utilidades;

public class ActivityRegis extends AppCompatActivity {


    Button regis;
    EditText nombre;
    EditText usuario;
    EditText contrasena;
    EditText confirmarContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        regis=findViewById(R.id.btnRegistrar);
        nombre=findViewById(R.id.editTxtNombre);
        usuario=findViewById(R.id.editTxtUsuario);
        contrasena=findViewById(R.id.editTxtPassContraseña);
        confirmarContrasena=findViewById(R.id.editTxtPassConfirmarContra);


        regis.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {

                String d11=nombre.getText().toString();
                String d12=usuario.getText().toString();
                String d13=contrasena.getText().toString();
                String d14=confirmarContrasena.getText().toString();

                if ("".equals(d11)||"".equals(d12)||"".equals(d13)||"".equals(d14)){
                    Toast toast = Toast.makeText(getBaseContext(), "Faltan campos por rellenar",Toast.LENGTH_SHORT);
                    toast.show();
              }else{

                }
                registrarUsuarios();
               Intent bf = new Intent(ActivityRegis.this,MainActivity.class);
               startActivity(bf);
            }
      });
    }





    private void registrarUsuarios() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(utilidades.CAMPO_NOMBRE, nombre.getText().toString());
        values.put(utilidades.CAMPO_USUARIO, usuario.getText().toString());
        values.put(utilidades.CAMPO_CONTRASEÑA, contrasena.getText().toString());

        Long nombreResultante = db.insert(utilidades.TABLA_USUARIO, utilidades.CAMPO_NOMBRE, values);
        Toast.makeText(getApplicationContext(),"Registrado correctamente",Toast.LENGTH_SHORT).show();
        db.close();
    }
}
