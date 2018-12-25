package com.example.badi_pc.app_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProduitsDAO extends AbstractDAO {
    public static final String TABLE_NAME="Produits";//Nom de la table STOCK
    // Nom de colonnes Table STOCK
    public static final String KEY_ID="ID";
    public static final String KEY_Produits="Produit";
    public static final String KEY_QProduits="QProduits";


    public ProduitsDAO(Context context) {
        super(context);
    }
    public boolean add(Produits prod) {
        boolean ok=true;
        try {
            SQLiteDatabase db = openWrite();
            ContentValues values = new ContentValues();
           // values.put(ProduitsDAO.KEY_ID, prod.getID());
            // Stock Libelle
            values.put(ProduitsDAO.KEY_Produits, prod.getProduits());
            // Stock Tarif
            values.put(ProduitsDAO.KEY_QProduits, prod.getQProduits());
            // Stock
            db.insert(ProduitsDAO.TABLE_NAME, null, values);
            close();
            // fermer la connection BD
        }catch (Exception e){
            ok=false;
        }
        return ok;
        }

    public boolean delete(Produits prod) {
        boolean ok=true;
        try {
        SQLiteDatabase db = openWrite();
        db.delete(TABLE_NAME, ProduitsDAO.KEY_ID + " = ?", new String[] { String.valueOf(prod.getID()) });
        db.close();
    }catch (Exception e){
        ok=false;
    }
        return ok;
    }
   public Produits findByID(int id) {
       Produits P= new Produits(0,"Null",0);
        try {
            SQLiteDatabase db = openRead();
            Cursor cursor = db.query(TABLE_NAME,new String[] { ProduitsDAO.KEY_ID, ProduitsDAO.KEY_Produits,
                            ProduitsDAO.KEY_QProduits},ProduitsDAO.KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null,
                    null, null);
            if (cursor != null)
                cursor.moveToFirst();
            if (cursor != null)
                 P = new Produits(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
        }catch (Exception e){
            return P= new Produits(0,"Null",0);
        }

        return P;     }
    public List<Produits> findAll() {

    List<Produits> list =new ArrayList<Produits>();
    Produits p;
        try {
            SQLiteDatabase db = openRead();
            Cursor cursor = db.rawQuery("Select * from "+TABLE_NAME,null);
            if (cursor != null)
                cursor.moveToFirst();
            do {
                p = new Produits(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
                list.add(p);
            }while (cursor.moveToNext());
        }catch (Exception e){
            return null;
        }

        return list;
    }


    }
