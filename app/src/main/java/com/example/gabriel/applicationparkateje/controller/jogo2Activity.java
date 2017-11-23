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
import com.example.gabriel.applicationparkateje.controller.JogoActivity;
import com.example.gabriel.applicationparkateje.R;

import java.io.Serializable;
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
            add(new Questoes("Qual destas imagens representa a palavra 'Kire' em parkatêjê ?", R.id.imgresposta,images ));
            // add(new Questoes("",R.id.imgresposta));
            // add(new Questoes("",R.id.imgresposta2));
            //add(new Questoes("",R.id.imgresposta3));
            //add(new Questoes("",R.id.imgresposta4));
        }
    };
    private Pontuacao pontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo2);

        pergunta = (TextView)findViewById(R.id.txtPergunta2);

        img1 = (ImageView)findViewById(R.id.imgresposta);
        img2 = (ImageView)findViewById(R.id.imgresposta2);
        img3 = (ImageView)findViewById(R.id.imgresposta3);
        img4 = (ImageView)findViewById(R.id.imgresposta4);

        //pergunta.setText("Qual destas imagens representa a palavra 'Kire' em parkatêjê ?");
        carregarQuestao();
        img1.setImageResource(R.drawable.cachorro);
        img2.setImageResource(R.drawable.jacare);
        img3.setImageResource(R.drawable.cobra);
        img4.setImageResource(R.drawable.canoa);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Intent intent = getIntent();
        pontuacao = (Pontuacao) intent.getSerializableExtra("Pontuação");

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            preencheAlertDialog(builder, true);
            }
        });
    }

    public void preencheAlertDialog(final AlertDialog.Builder builder, boolean respostaCerta) {
        if (respostaCerta) {
            builder.setTitle("Resultado");
            final Pontuacao pontos = new Pontuacao();
            pontos.setAcertos(1);
            builder.setMessage("Resposta certa " + (pontuacao.getAcertos() + 1));

            builder.setIcon(R.drawable.check);
            builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   Intent intent = new Intent(getApplicationContext(), Jogo3Activity.class);
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
        pergunta.setText(q.getPergunta1());
        List<Integer> resposta = q.getRespostas1();

        img1.setImageResource(resposta.get(0));
        img2.setImageResource(resposta.get(1));
        img3.setImageResource(resposta.get(2));
        img4.setImageResource(resposta.get(3));
        respostaCerta = q.getRespostaCerta1();

    }
}
