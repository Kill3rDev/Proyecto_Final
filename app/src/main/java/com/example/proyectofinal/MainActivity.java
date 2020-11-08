package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;

    EditText a1;
    EditText a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button2);
        btn2=findViewById(R.id.button);
        a1=findViewById(R.id.editTextTextEmailAddress);
        a2=findViewById(R.id.editTextTextPassword);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (a1.getText().toString().length()==0){
                    Toast toast = Toast.makeText(getBaseContext(), "Bienvenido: ",Toast.LENGTH_SHORT);
                    toast.show();
                //}else{
                    Intent b= new Intent(MainActivity.this,ActivityMenu.class);
                    startActivity(b);
                //}
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent a= new Intent(MainActivity.this,ActivityRegis.class);
                startActivity(a);
            }
        });
    }
}