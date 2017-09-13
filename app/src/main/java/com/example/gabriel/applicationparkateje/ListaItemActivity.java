package com.example.gabriel.applicationparkateje;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_item);

        ArrayList lista = new ArrayList<item>();

        item A = new item(R.drawable.animal, "Item A");
        item B = new item(R.drawable.objetos, "Item B");
        item C = new item(R.drawable.plantas, "Item C");
        item D = new item(R.drawable.frutas, "Item D");

        lista.add(A);
        lista.add(B);
        lista.add(C);
        lista.add(D);

        ListAdapterItem adapterItem = new ListAdapterItem(this, lista);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapterItem);
    }

}
