package com.example.gabriel.applicationparkateje.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabriel.applicationparkateje.R;

import java.util.ArrayList;
import java.util.List;

public class jogo2Activity extends AppCompatActivity {

    TextView pergunta;
    ImageView img1, img2,img3,img4;
    private AlertDialog respostaCorreta, respostaIncorreta;
    int respostaCerta;
    int [] images = {R.drawable.cachorro, R.drawable.cobra, R.drawable.jacare, R.drawable.animal};
    List<Questoes> questoes = new ArrayList<Questoes>(){
        {
            add(new Questoes("Qual destas imagens representa a palavra 'Kire' em parkatêjê ?", R.id.imgresposta, images.toString()));
            // add(new Questoes("",R.id.imgresposta));
            // add(new Questoes("",R.id.imgresposta2));
            //add(new Questoes("",R.id.imgresposta3));
            //add(new Questoes("",R.id.imgresposta4));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo2);

        pergunta = (TextView)findViewById(R.id.txtPergunta2);

        img1 = (ImageView)findViewById(R.id.imgresposta);
        img2 = (ImageView)findViewById(R.id.imgresposta2);
        img3 = (ImageView)findViewById(R.id.imgresposta3);
        img4 = (ImageView)findViewById(R.id.imgresposta4);

     //   pergunta.setText("Qual destas imagens representa a palavra 'Kire' em parkatêjê ?");
        carregarQuestao();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            preencheAlertDialog(builder, true);


            }
        });
    }

    public void preencheAlertDialog(AlertDialog.Builder builder, boolean respostaCerta) {
        if (respostaCerta) {
            builder.setTitle("Resultado");
            builder.setMessage(" Resposta Correta ");

            builder.setIcon(R.drawable.check);
            builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   //
                }
            });
            builder.setNegativeButton("", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            respostaCorreta = builder.create();
            respostaCorreta.show();
        } else {
            builder.setTitle("Resultado");
            builder.setMessage("! ! ! Resposta Incorreta ! ! !");
            builder.setIcon(R.drawable.incorrect);
            builder.setNegativeButton("Tente Novamente", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setPositiveButton("", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            respostaIncorreta = builder.create();
            respostaIncorreta.show();
        }

    }
    private void carregarQuestao(){

        Questoes q = questoes.remove(1);
        pergunta.setText(q.getPergunta());
        List<String> resposta = q.getRespostas();
        int resposta1 = Integer.parseInt(resposta.get(1));
        int resposta2 = Integer.parseInt(resposta.get(2));
        int resposta3 = Integer.parseInt(resposta.get(3));
        int resposta4 = Integer.parseInt(resposta.get(4));

        img1.setImageResource(resposta1);
        img2.setImageResource(resposta2);
        img3.setImageResource(resposta3);
        img4.setImageResource(resposta4);
        respostaCerta = q.getRespostaCerta();

    }
}
