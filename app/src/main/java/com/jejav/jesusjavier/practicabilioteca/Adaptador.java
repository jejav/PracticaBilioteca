package com.jejav.jesusjavier.practicabilioteca;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Jesus Javier on 31/10/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.WeViewHolder> {


   private final LayoutInflater inflater;

    private ArrayList<User> items;

    public Adaptador(Context context,ArrayList<User> items){
        //this.context=context;
        inflater=LayoutInflater.from(context);
        this.items=items;
    }


    @Override
    public WeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = inflater.inflate(R.layout.adaptador_layout,parent,false);
        WeViewHolder item=new WeViewHolder(row);

        return item;
    }

    @Override
    public void onBindViewHolder(WeViewHolder holder, int position) {

        //((Item)holder).libro.setText(items[position]);
        holder.libro.setText(items.get(position).getLibro());
        holder.autor.setText(items.get(position).getAutor());
        holder.usuario.setText(items.get(position).getName());
       holder.phone.setText(items.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class WeViewHolder extends RecyclerView.ViewHolder{
        TextView libro,autor,usuario,phone;
        public WeViewHolder(View itemView) {
            super(itemView);
            libro=(TextView)itemView.findViewById(R.id.tbook);
            autor=(TextView)itemView.findViewById(R.id.tautor);
            usuario=(TextView)itemView.findViewById(R.id.tuser);
            phone=(TextView)itemView.findViewById(R.id.tphone);

        }
    }
}
