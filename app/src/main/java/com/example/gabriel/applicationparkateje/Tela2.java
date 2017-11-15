package com.example.gabriel.applicationparkateje;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Gabriel on 19/09/2017.
 */

public class Tela2 extends AppCompatActivity{

    ListView listaDados;
    ArrayList<Dados>lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);
        listaDados = (ListView)findViewById(R.id.listaDados);

        lista = new ArrayList<Dados>();

        lista.add(new Dados(1, "Animais", "Animais em Parkatêjê", R.drawable.animal));
        lista.add(new Dados(2, "Objetos", "Objetos em Parkatêjê", R.drawable.objetos));
        lista.add(new Dados(3, "Plantas", "Plantas em Parkatêjê", R.drawable.plantas));
        lista.add(new Dados(4, "Frutas", "Frutas em Parkatêjê", R.drawable.frutas));

        Adapter adapter = new Adapter(getApplicationContext(), lista);
        listaDados.setAdapter(adapter);

        listaDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dados  obj = (Dados) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), Tela3.class);
                intent.putExtra("objeto", obj);

                startActivity(intent);
            }
        });
    }

}
