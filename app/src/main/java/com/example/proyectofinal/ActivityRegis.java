package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegis extends AppCompatActivity {

    Button regis;
    EditText d1;
    EditText d2;
    EditText d3;
    EditText d4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        regis=findViewById(R.id.btnRegistrar);
        d1=findViewById(R.id.editTextTextEmailAddress);
        d2=findViewById(R.id.editTextTextEmailAddress2);
        d3=findViewById(R.id.editTextTextPassword2);
        d4=findViewById(R.id.editTextTextPassword3);


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d11=d1.getText().toString();
                String d12=d2.getText().toString();
                String d13=d3.getText().toString();
                String d14=d4.getText().toString();

                if ("".equals(d11)||"".equals(d12)||"".equals(d13)||"".equals(d14)){
                    Toast toast = Toast.makeText(getBaseContext(), "Faltan campos por rellenar",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getBaseContext(), "Usuario registrado con exito",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
