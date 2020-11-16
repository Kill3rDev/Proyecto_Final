package com.example.proyectofinal;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectofinal.Utilidades.utilidades;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(utilidades.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);

    }


    public Cursor consultauser(String usu,String pass)throws SQLException{

        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query("usuarios",new String[]{"user",
                "nombre","usuario","contraseña"},"user like '"+usu+"' "+
                "and contraseña like '"+pass+"' ",null,null,null,null);
        return  mcursor;
    }
}
