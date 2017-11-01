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

public class jogo2Activity extends AppCompatActivity {

    TextView pergunta;
    ImageView img1, img2,img3,img4;
    private AlertDialog respostaCorreta, respostaIncorreta;
    int respostaCerta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo2);

        pergunta = (TextView)findViewById(R.id.txtPergunta2);

        img1 = (ImageView)findViewById(R.id.imgresposta);
        img2 = (ImageView)findViewById(R.id.imgresposta2);
        img3 = (ImageView)findViewById(R.id.imgresposta3);
        img4 = (ImageView)findViewById(R.id.imgresposta4);

        pergunta.setText("Qual destas imagens representa a palavra 'Kire' em parkatêjê ?");
        img1.setImageResource(R.drawable.cachorro);
        img2.setImageResource(R.drawable.jacare);
        img3.setImageResource(R.drawable.frutas);
        img4.setImageResource(R.drawable.canoa);
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
}
