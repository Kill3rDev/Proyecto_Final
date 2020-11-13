package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.Utilidades.utilidades;

public class ActivityRegis extends AppCompatActivity {
 /// cambie los nombres de las variables y de los ID por unos que se puedan identificar mas facil
    /// para evitar confusiones hector!
    /// para no estar d1, d2 , d3.....dn  jeje xD



    Button regis;
    EditText nombre;
    EditText usuario;
    EditText contraseña;
    EditText confirmarContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        regis=findViewById(R.id.btnRegistrar);
        nombre=findViewById(R.id.editTxtNombre);
        usuario=findViewById(R.id.editTxtUsuario);
        contraseña=findViewById(R.id.editTxtPassContraseña);
        confirmarContraseña=findViewById(R.id.editTxtPassConfirmarContra);


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d11=nombre.getText().toString();
                String d12=usuario.getText().toString();
                String d13=contraseña.getText().toString();
                String d14=confirmarContraseña.getText().toString();

                if ("".equals(d11)||"".equals(d12)||"".equals(d13)||"".equals(d14)){
                    Toast toast = Toast.makeText(getBaseContext(), "Faltan campos por rellenar",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getBaseContext(), "Usuario registrado con exito",Toast.LENGTH_SHORT);
                    toast.show();
                }

                registrarUsuarios();
            }

        });


    }

    private void registrarUsuarios() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(utilidades.CAMPO_NOMBRE, nombre.getText().toString());
        values.put(utilidades.CAMPO_USUARIO, usuario.getText().toString());
        values.put(utilidades.CAMPO_CONTRASEÑA, contraseña.getText().toString());

        Long nombreResultante = db.insert(utilidades.TABLA_USUARIO, utilidades.CAMPO_NOMBRE, values);

        Toast.makeText(getApplicationContext(),"Registrado"+nombreResultante,Toast.LENGTH_SHORT).show();

    }


}
