package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.proyectofinal.Utilidades.utilidades;

import java.util.Calendar;

public class agregarnota extends AppCompatActivity {

    TextView te;
    DatePickerDialog datePickerDialog;
    Button fec;
    Button fec2;
    TextView te2;
    TimePickerDialog timePickerDialog;
    Button agre;

    // Variables para agregar nota
    EditText titu;
    EditText desc;
    EditText nott;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarnota);
        fec=(Button)findViewById(R.id.buttonfech);
        te=(TextView)findViewById(R.id.fech);
        te2=(TextView)findViewById(R.id.fech2);
        fec2=(Button)findViewById(R.id.fech22);
        agre=findViewById(R.id.btnAgregar);

        titu=findViewById(R.id.editTextTextPersonName4);
        desc= findViewById(R.id.editTextTextPersonName5);
        nott= findViewById(R.id.txtNota);



        fec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cc2=Calendar.getInstance();
                int hour=cc2.get(Calendar.HOUR);
                int minute=cc2.get(Calendar.MINUTE);
                timePickerDialog= new TimePickerDialog(agregarnota.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        te2.setText(i+":"+i1);
                    }
                },hour,minute,false);
                timePickerDialog.show();
            }
        });


        fec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cc=Calendar.getInstance();
                int year = cc.get(Calendar.YEAR);
                int mont=cc.get(Calendar.MONTH);
                int day=cc.get(Calendar.DAY_OF_MONTH);

                datePickerDialog= new DatePickerDialog(agregarnota.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        te.setText(day+"/"+(mont+1)+"/"+year);
                    }
                },year,mont,day);
                datePickerDialog.show();
            }
        });


        agre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a= new Intent(agregarnota.this,ActivityMenu.class);
                startActivity(a);
            }
        });
    }
}