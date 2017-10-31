package com.jejav.jesusjavier.practicabilioteca;


import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPrincipal extends Fragment {

    EditText edId,edLibro,edAutor,edUsuario,edTelefono;
    Button btncrear,btneliminar,btnactualizar;

    UsuariosSQLiteHelper usuariosSQliteHelper;
    SQLiteDatabase dbuser;


    public FragmentPrincipal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_principal, container, false);

        usuariosSQliteHelper=new UsuariosSQLiteHelper(getContext(),"usersBD",null,1);
        dbuser =usuariosSQliteHelper.getWritableDatabase();


        edId=(EditText)view.findViewById(R.id.edIdent);
        edLibro=(EditText)view.findViewById(R.id.edlibro);
        edAutor=(EditText)view.findViewById(R.id.edAutor);
        edUsuario=(EditText)view.findViewById(R.id.edPersona);
        edTelefono=(EditText)view.findViewById(R.id.edTelefono);
        btncrear=(Button)view.findViewById(R.id.btnCrear);
        btneliminar=(Button)view.findViewById(R.id.btnEliminar);
        btnactualizar=(Button)view.findViewById(R.id.btnActualizar);

        View.OnClickListener listener = new View.OnClickListener()
        {

            public void onClick(View view) {
                // TODO Auto-generated method stub
                int id=view.getId();

                //final int uid= edId.getText;
                String name =edUsuario.getText().toString();
                String autor =edAutor.getText().toString();
                String libro =edLibro.getText().toString();
                String phone =edTelefono.getText().toString();

                ContentValues data=new ContentValues();

                switch (id){
                    case R.id.btnCrear:

                        data.put("libro",libro);
                        data.put("autor",autor);
                        data.put("nombre",name);
                        data.put("telefono",phone);
                        dbuser.insert("usuarios",null,data);
                        break;
                    case R.id.btnEliminar:
                        dbuser.delete("usuarios","nombre = '"+name+"'",null);
                        break;
                    case R.id.btnActualizar:
                        data.put("libro",libro);
                        data.put("autor",autor);
                        data.put("telefono",phone);
                        dbuser.update("usuarios",data,"nombre = '"+name+"'",null);

                        break;
                }

            }

        };
        btnactualizar.setOnClickListener(listener);
        btneliminar.setOnClickListener(listener);
        btncrear.setOnClickListener(listener);

        return view;
    }



}
