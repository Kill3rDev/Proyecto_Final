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
    //EditText user=(EditText)findViewById(R.id.editTextTextEmailAddress);
    //EditText pass=(EditText)findViewById(R.id.editTextTextPassword);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button2);
        btn2=findViewById(R.id.button);

        //String user2=user.getText().toString();
        //String pass2=pass.getText().toString();


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (user2=="admin" && pass2=="admin"){
                    Intent b= new Intent(MainActivity.this,ActivityMenu.class);
                    startActivity(b);
                //}else{
                    //Toast.makeText(getBaseContext(),"Usuario no valido",Toast.LENGTH_SHORT).show();
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