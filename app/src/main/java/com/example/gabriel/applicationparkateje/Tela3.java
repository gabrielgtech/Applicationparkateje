package com.example.gabriel.applicationparkateje;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabriel.applicationparkateje.controller.Adapatador;
import com.example.gabriel.applicationparkateje.controller.Dados_objetos;
import com.example.gabriel.applicationparkateje.controller.JogoActivity;
import com.example.gabriel.applicationparkateje.palavras.Animais;
import com.example.gabriel.applicationparkateje.palavras.Frutas;
import com.example.gabriel.applicationparkateje.palavras.Objetos;
import com.example.gabriel.applicationparkateje.palavras.Plantas;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Tela3 extends AppCompatActivity {

    GridView grade;
    ArrayList<Dados_objetos>dados;

    String[] Animais = {"Cachorro","Jiboia","Jacaré"};
    Integer []ImagensAnimais = {R.drawable.cachorro, R.drawable.cobra, R.drawable.jacare};
    Integer []AudioAnimais = {R.raw.cachorro, R.raw.jiboia, R.raw.jacare, R.raw.gaviao, R.raw.paca};

    String[] Objetos = {"Flecha","Canoa","Rede","Tora"};
    Integer []ImagensObjetos = {R.drawable.flecha,R.drawable.canoa,R.drawable.rede,R.drawable.tora};
    Integer []AudioObjetos = {R.raw.casa,R.raw.jiboia, R.raw.jacare, R.raw.gaviao};


    String[] Plantas = {"Cipó","Embauba","Coração de Jabuti","Batata Braba"};
    String[] Frutas = {"Caju","Cupuaçu","Castanha ","Coco"};

    ImageView imagem;
    TextView titulo;
    Button btnPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        grade =(GridView) findViewById(R.id.grid);
        imagem = (ImageView)findViewById(R.id.imageView);
        titulo = (TextView)findViewById(R.id.txtTitulo2);
        //btnPlay = (Button)findViewById(R.id.btnJogar);

        final MediaPlayer gaviao = MediaPlayer.create(this, R.raw.gaviao);
        final MediaPlayer cachorro = MediaPlayer.create(this, R.raw.cachorro);
        final MediaPlayer jacare = MediaPlayer.create(this, R.raw.jacare);
        final MediaPlayer paca = MediaPlayer.create(this, R.raw.paca);
        final MediaPlayer casa = MediaPlayer.create(this, R.raw.casa);
        final MediaPlayer jiboia = MediaPlayer.create(this, R.raw.jiboia);


        Dados obj = (Dados) getIntent().getExtras().getSerializable("objeto");

        dados = new ArrayList<Dados_objetos>();

        //imagem.setImageResource(imagesArrayList.get(i));
        if(obj.getTitulo().equals("Animais")){

            for (int i=0; i < ImagensAnimais.length; i++){

                dados.add(new Dados_objetos(Animais[i],i,ImagensAnimais[i],MediaPlayer.create(this,AudioAnimais[i])));
            }
        }else if(obj.getTitulo().equals("Objetos")){
            for (int i=0; i < ImagensObjetos.length; i++){

                dados.add(new Dados_objetos(Objetos[i],i,ImagensObjetos[i],MediaPlayer.create(this,AudioObjetos[i])));
            }
        }else if (obj.getTitulo().equals("Plantas")){
            for (int i=0; i < ImagensObjetos.length; i++){

                //dados.add(new Dados(i,Plantas[i] ,"",ImagensObjetos[i]));
            }
        }else if (obj.getTitulo().equals("Frutas")){
            for (int i=0; i < ImagensObjetos.length; i++){

              //  dados.add(new Dados(i,Frutas[i] ,"",ImagensObjetos[i]));

            }
        }

        Adapatador adapter = new Adapatador(getApplicationContext(), dados);
        grade.setAdapter(adapter);


        switch (obj.getId()){

            case 1:
                //Animais
                grade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Dados_objetos op = (Dados_objetos) adapterView.getItemAtPosition(i);


                        if (op.getNome().equals("Cachorro")){
                            cachorro.start();
                        }else if (op.getNome().equals("Jiboia")){
                            jiboia.start();
                        }else if (op.getNome().equals("Jacaré")){
                            jacare.start();
                        }else if (op.getNome().equals("Frutas")){

                        }
                    }});
            break;
            //Objetos
            case 2:
                grade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Dados_objetos op = (Dados_objetos) adapterView.getItemAtPosition(i);


                        if (op.getNome().equals("Flecha")){
                            casa.start();
                        }else if (op.getNome().equals("Canoa")){
                            jiboia.start();
                        }else if (op.getNome().equals("Rede")){
                            jacare.start();
                        }else if (op.getNome().equals("Tora")){

                        }
                    }});
            break;

             //Plantas
            case 3:
                grade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Dados_objetos op = (Dados_objetos) adapterView.getItemAtPosition(i);


                        if (op.getNome().equals("Cipó")){
                            cachorro.start();
                        }else if (op.getNome().equals("Embauba")){
                            jiboia.start();
                        }
                    }});

            break;

            //frutas
            case 4:
                grade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Dados_objetos op = (Dados_objetos) adapterView.getItemAtPosition(i);


                        if (op.getNome().equals("Caju")){
                            cachorro.start();
                        }else if (op.getNome().equals("Cupuaçu")){
                            jiboia.start();
                        }else if (op.getNome().equals("Castanha")){
                            jacare.start();
                        }else if (op.getNome().equals("Coco")){

                        }
                    }});
            break;
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), JogoActivity.class);
                intent.putExtra("objeto", dados);
                startActivity(intent);
            }
        });


    }


}
