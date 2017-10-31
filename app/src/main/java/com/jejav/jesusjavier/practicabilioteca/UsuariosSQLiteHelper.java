package com.jejav.jesusjavier.practicabilioteca;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jesus Javier on 31/10/2017.
 */

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {
    private String DATA_BASE_NAME="usersBD";
    private int DATA_VERSION=1;

    private String sqlCreate="CREATE TABLE usuarios ("+ //CAMPO 0
            "id             INTEGER PRIMARY KEY AUTOINCREMENT,"+ //CAMPO 1
            "libro            TEXT,"+ //CAMPO 2
            "autor            TEXT,"+ //CAMPO 3
            "nombre           TEXT,"+ //CAMPO 3
            "telefono         TEXT)"; //CAMPO 4

    public UsuariosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TALE IF EXISTS contactos");
        db.execSQL(sqlCreate);
    }
}
