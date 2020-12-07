package com.example.proyectofinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


///Hector Voy a comentar el codigo para que veas lo que hice paso a paso
public class detalle extends AppCompatActivity {

    MediaRecorder grabacion;
    String salida=null;
    Button btnRe;
    ImageView imag;
    Button bimag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        btnRe=(Button)findViewById(R.id.btgrab);
        imag=(ImageView)findViewById(R.id.imagxd);
        bimag=(Button)findViewById(R.id.btimag);

        //PASO 1
        /// Primeramente aqui en el oncreate
        // //Asigne los textview que estan en el layout detalle a una variable de su mismo tipo, osea textview


        TextView textTitulo = findViewById(R.id.textViewTitulo);
        TextView textDescripcion = findViewById(R.id.textViewDescripcion);
        TextView textNota = findViewById(R.id.textViewNota);
        TextView textHoraFecha = findViewById(R.id.textViewHorayFecha);

        ///Paso 8
        String titulo = "titulo not set";
        String Descripcion = "Descripcion not set";
        String nota = "nota not set";
        String Horafecha = "Hora o Fecha not set";

        Bundle extras  = getIntent().getExtras();
        if (extras != null){
            titulo = extras.getString("titulo");
            Descripcion = extras.getString("Descripcion");
            nota = extras.getString("nota");
            Horafecha = extras.getString("Hora Fecha");

        }



        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(detalle.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
    }


    public void recorder(View view){
        if (grabacion==null){
            salida= Environment.getExternalStorageDirectory().getAbsolutePath()+"/grabacion.mp3";
            grabacion= new MediaRecorder();
            grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
            grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            grabacion.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            grabacion.setOutputFile(salida);
            try{
                grabacion.prepare();
                grabacion.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(),"Grabando", Toast.LENGTH_SHORT).show();

        }else if(grabacion!= null){
            grabacion.stop();
            grabacion.release();
            grabacion=null;
            Toast.makeText(getApplicationContext(),"Grabacion finalizada", Toast.LENGTH_SHORT).show();
        }
    }

    public void reproducir(View view){
        MediaPlayer media= new MediaPlayer();
        try{
            media.setDataSource(salida);
            media.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        media.start();
        Toast.makeText(getApplicationContext(),"Reproduciendo", Toast.LENGTH_SHORT).show();
    }

    public void loadimag(View view){
        Intent intent= new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Sleccione aplicación"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imag.setImageURI(path);
        }
    }
}