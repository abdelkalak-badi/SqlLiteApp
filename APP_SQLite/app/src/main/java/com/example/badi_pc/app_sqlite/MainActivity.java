package com.example.badi_pc.app_sqlite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText id,prod,qprod;
ProduitsDAO produitsDAO;
Produits p ;
boolean ok=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText) findViewById(R.id.txtid);
        prod=(EditText) findViewById(R.id.txtprod);
        qprod =(EditText) findViewById(R.id.txtqprod);
        produitsDAO =new ProduitsDAO(this);
        p=new Produits();

    }

    public void Add(View view) {
       // p.setID(Integer.parseInt(id.getText().toString()));
        p.setProduits(prod.getText().toString());
        p.setQProduits(Integer.parseInt(qprod.getText().toString()));
        ok=produitsDAO.add(p);
        if (ok){
            id.setText("");
            prod.setText("");
            qprod.setText("");
            Toast.makeText(MainActivity.this, "Add ok !", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Add ERRER !", Toast.LENGTH_SHORT).show();
        }

    }

    public void Lookup(View view) {
        p=produitsDAO.findByID(Integer.parseInt(id.getText().toString()));
        prod.setText(p.Produits+"");
        qprod.setText(p.QProduits+"");
    }

    public void Remove(View view) {
        p.setID(Integer.parseInt(id.getText().toString()));
        p.setProduits(prod.getText().toString());
        p.setQProduits(Integer.parseInt(qprod.getText().toString()));
        ok=produitsDAO.delete(p);
        if (ok){
            id.setText("");
            prod.setText("");
            qprod.setText("");
            Toast.makeText(MainActivity.this, "Remove OK !", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "Remove ERROR !", Toast.LENGTH_SHORT).show();
        }

    }

    public void clickListe(View view) {
        startActivity(new Intent(MainActivity.this,ListeProdActivity.class));
    }
}
