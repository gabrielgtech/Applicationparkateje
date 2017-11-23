package com.example.gabriel.applicationparkateje.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabriel.applicationparkateje.R;

import java.util.ArrayList;
import java.util.List;

public class Jogo3Activity extends AppCompatActivity {

    ImageView imagem;
    Button opcao1, opcao2, opcao3, opcao4;
    TextView pergunta;
    int respostaCerta;

    private AlertDialog respostaCorreta, respostaIncorreta;
    String[] AnimaisParkateje = {"Kire", "Mĩre", "Hàkati", "Kra"};
    List<Questoes> questoes = new ArrayList<Questoes>(){
        {
            add(new Questoes("Pressione a imagem acima, e escolha a opção correta ?", R.id.btnRespostaC, AnimaisParkateje));
            // add(new Questoes("",R.id.imgresposta2));
            //add(new Questoes("",R.id.imgresposta3));
            //add(new Questoes("",R.id.imgresposta4));
        }
    };

    private Pontuacao pontuacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo3);

        imagem = (ImageView) findViewById(R.id.question_image);
        opcao1 = (Button) findViewById(R.id.btnRespostaA);
        opcao2 = (Button) findViewById(R.id.btnRespostaB);
        opcao3 = (Button) findViewById(R.id.btnRespostaC);
        opcao4 = (Button) findViewById(R.id.btnRespostaD);
        pergunta = (TextView) findViewById(R.id.question_text);

        final MediaPlayer audio = MediaPlayer.create(this, R.raw.jiboia);
        imagem.setImageResource(R.drawable.cobra);

        //pergunta.setText("Escute o audio pressionando a imagem a cima, e escolha a opção correta ?");
        //metodo que toca o audio
        carregarQuestao();
        imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio.start();

            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        opcao1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                preencheAlertDialog(builder, false);

            }
        });

        opcao2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                preencheAlertDialog(builder, false);

            }
        });

        opcao3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                preencheAlertDialog(builder, true);
            }
        });

        opcao4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                preencheAlertDialog(builder, false);

            }
        });
    }

    public void preencheAlertDialog(AlertDialog.Builder builder, boolean respostaCerta) {
        if (respostaCerta) {
            builder.setTitle("Resultado");

            builder.setMessage("Resposta certa ");

            builder.setIcon(R.drawable.check);
            builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(getApplicationContext(), Jogo4Activity.class);

                    startActivity(intent);
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

        Questoes q = questoes.remove(0);
        pergunta.setText(q.getPergunta());
        List<String> resposta = q.getRespostas();
        opcao1.setText(resposta.get(0));
        opcao2.setText(resposta.get(1));
        opcao3.setText(resposta.get(2));
        opcao4.setText(resposta.get(3));
        respostaCerta = q.getRespostaCerta();

    }
}
