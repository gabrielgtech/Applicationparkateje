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

    String[] Animais = {"Cachorro","Jiboia","Jacaré", "Paca"};
    Integer []ImagensAnimais = {R.drawable.cachorro, R.drawable.cobra, R.drawable.jacare, R.drawable.icn_paca};
    Integer []AudioAnimais = {R.raw.cachorro, R.raw.jiboia, R.raw.jacare, R.raw.gaviao, R.raw.paca};

    String[] Objetos = {"Flecha","Canoa","Rede","Casa"};
    Integer []ImagensObjetos = {R.drawable.flecha,R.drawable.canoa,R.drawable.rede,R.drawable.icn_casa};
    Integer []AudioObjetos = {R.raw.arco,R.raw.jiboia, R.raw.rede, R.raw.casa};


    String[] Plantas = {"Cipó","Embauba","Coração de Jabuti","Batata Braba"};
    Integer []ImagensPlantas = {R.drawable.icn_cipo,R.drawable.icn_embauba, R.drawable.img_coracao_jabuti,R.drawable.img_batata_braba};
    Integer []AudioPlantas = {R.raw.cipo,R.raw.embauba, R.raw.coracao_de_jabuti, R.raw.batata};

    String[] Frutas = {"Caju","Cupuaçu","Castanha ","Coco"};
    Integer []ImagensFrutas = {R.drawable.icn_caju,R.drawable.icn_cupuacu,R.drawable.icn_castanha, R.drawable.icn_oco};
    Integer []AudioFrutas = {R.raw.caju, R.raw.cupuacu,R.raw.castanha, R.raw.coco};

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
        btnPlay = (Button)findViewById(R.id.btnJogar);


        final MediaPlayer cachorro = MediaPlayer.create(this, R.raw.cachorro);
        final MediaPlayer jacare = MediaPlayer.create(this, R.raw.jacare);
        final MediaPlayer paca = MediaPlayer.create(this, R.raw.paca);
        final MediaPlayer jiboia = MediaPlayer.create(this, R.raw.jiboia);

        final MediaPlayer arco = MediaPlayer.create(this, R.raw.arco);
        final MediaPlayer casa = MediaPlayer.create(this, R.raw.casa);
        final MediaPlayer rede = MediaPlayer.create(this, R.raw.rede);

        final MediaPlayer cipo = MediaPlayer.create(this, R.raw.cipo);
        final MediaPlayer embauba = MediaPlayer.create(this, R.raw.embauba);
        final MediaPlayer coracao = MediaPlayer.create(this, R.raw.coracao_de_jabuti);
        final MediaPlayer batata = MediaPlayer.create(this, R.raw.batata);

        final MediaPlayer caju = MediaPlayer.create(this, R.raw.caju);
        final MediaPlayer cupuacu = MediaPlayer.create(this, R.raw.cupuacu);
        final MediaPlayer castanha = MediaPlayer.create(this, R.raw.castanha);
        final MediaPlayer coco = MediaPlayer.create(this, R.raw.coco);




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
                dados.add(new Dados_objetos(Plantas[i],i,ImagensPlantas[i],MediaPlayer.create(this,AudioPlantas[i])));
            }
        }else if (obj.getTitulo().equals("Frutas")){
            for (int i=0; i < ImagensObjetos.length; i++){

                dados.add(new Dados_objetos(Frutas[i],i,ImagensFrutas[i],MediaPlayer.create(this,AudioFrutas[i])));

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
                        }else if (op.getNome().equals("Paca")){
                            paca.start();
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
                            arco.start();
                        }else if (op.getNome().equals("Canoa")){
                            jiboia.start();
                        }else if (op.getNome().equals("Rede")){
                            rede.start();
                        }else if (op.getNome().equals("Casa")){
                            casa.start();
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
                            cipo.start();
                        }else if (op.getNome().equals("Embauba")){
                            embauba.start();
                        }else if (op.getNome().equals("Coração de Jabuti")){
                            coracao.start();
                        }else if (op.getNome().equals("Batata Braba")){
                            batata.start();
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
                            caju.start();
                        }else if (op.getNome().equals("Cupuaçu")){
                            cupuacu.start();
                        }else if (op.getNome().equals("Castanha")){
                            castanha.start();
                        }else if (op.getNome().equals("Coco")){
                            coco.start();
                        }
                    }});
            break;
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreLista(v);
            }
        });


    }
    public void abreLista(View view){
        Intent intent = new Intent(getApplicationContext(), JogoActivity.class);
        startActivity(intent);
    }

}
