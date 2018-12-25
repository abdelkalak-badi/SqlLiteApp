package com.example.badi_pc.app_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.badi_pc.app_sqlite.liste.MyAdapter;

import java.util.ArrayList;

public class ListeProdActivity extends AppCompatActivity {
    ListView myliste;
    ArrayList<Produits> MyArray;
    MyAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProduitsDAO pd=new ProduitsDAO(ListeProdActivity.this);
        setContentView(R.layout.activity_liste_prod);
        MyArray=new ArrayList<Produits>();
        MyArray.addAll(pd.findAll());
        myadapter=new MyAdapter(this,R.layout.produits_coll,MyArray);
        myliste=(ListView) findViewById(R.id.Myliste);
        myliste.setAdapter(myadapter);

    }
}
