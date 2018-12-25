package com.example.badi_pc.app_sqlite.liste;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.badi_pc.app_sqlite.ListeProdActivity;
import com.example.badi_pc.app_sqlite.Produits;
import com.example.badi_pc.app_sqlite.R;

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter<Produits> {


    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Produits> objects) {
        super(context, resource, objects);
    }




    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        LayoutInflater layoutInflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=layoutInflater.inflate(R.layout.produits_coll,null);
        Produits p=getItem(position);
        TextView id=(TextView)v.findViewById(R.id.txtID);
        TextView pord=(TextView)v.findViewById(R.id.txtPROD);
        TextView prodq=(TextView)v.findViewById(R.id.txtQ);
        id.setText(p.getID()+"");
        pord.setText(p.getProduits()+"");
        prodq.setText(p.getQProduits()+"");



        return v;
    }

}
