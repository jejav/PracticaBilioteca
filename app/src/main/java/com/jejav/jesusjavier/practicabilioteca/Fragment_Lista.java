package com.jejav.jesusjavier.practicabilioteca;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Lista extends Fragment {
    Button btnact;

    RecyclerView recyclerView;
    ArrayList<User> Items;
    UsuariosSQLiteHelper usuariosSQliteHelper;
    SQLiteDatabase dbuser;
    private Adaptador adapter;

    public Fragment_Lista() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lista, container, false);

        usuariosSQliteHelper=new UsuariosSQLiteHelper(getContext(),"usersBD",null,1);
        dbuser =usuariosSQliteHelper.getWritableDatabase();

        btnact=(Button)view.findViewById(R.id.act);


        btnact.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Items=new ArrayList<User>();
                Cursor cursor = dbuser.rawQuery("select * from usuarios",null);
                do {
                    User Usuariosbd = new User();
                    Usuariosbd.setUid(cursor.getInt(0));
                    Usuariosbd.setLibro(cursor.getString(1));
                    Usuariosbd.setAutor(cursor.getString(2));
                    Usuariosbd.setName(cursor.getString(3));
                    Usuariosbd.setPhone(cursor.getString(4));
                    Items.add(Usuariosbd);
                }while(cursor.moveToNext());

               recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
                adapter =new Adaptador(getContext(), Items);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            }
        });



        return view;
    }

}
