package com.example.gabriel.applicationparkateje.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.gabriel.applicationparkateje.Done;
import com.example.gabriel.applicationparkateje.controller.JogoActivity;
import com.example.gabriel.applicationparkateje.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class jogo2Activity extends AppCompatActivity implements View.OnClickListener{

    TextView pergunta, txtScore, txtQuestionNum;
    Button img1, img2,img3,img4;
    private AlertDialog respostaCorreta, respostaIncorreta;
    int progressValue =0;
    int index=0, score=0 , thisQuestion=0,totalQuestion=0, respostaCerta;

    int [] images1 = {R.drawable.cachorro, R.drawable.cobra, R.drawable.jacare, R.drawable.animal};
    int [] images2 = {R.drawable.jacare, R.drawable.animal, R.drawable.cachorro, R.drawable.cobra};
    int [] images3 = {R.drawable.canoa, R.drawable.cobra, R.drawable.objetos, R.drawable.cachorro};
    int [] images4 = {R.drawable.cobra, R.drawable.cachorro, R.drawable.jacare, R.drawable.icn_paca};

    ProgressBar progressBar;

    List<Questoes> questoes = new ArrayList<Questoes>(){
        {
            add(new Questoes("Qual destas imagens representa a palavra 'Hàkati' em parkatêjê ?", images1, R.id.imgrespostaB, 1, "true"));
            add(new Questoes("Qual destas imagens representa a palavra 'Mĩre' em parkatêjê ?", images2,R.id.imgrespostaA, 2, "true"));
            add(new Questoes("Qual destas imagens representa a palavra 'rop' em parkatêjê ?",  images3, R.id.imgrespostaD, 3, "true"));
            add(new Questoes("Qual destas imagens representa a palavra 'Kra' em parkatêjê ?",  images4, R.id.imgrespostaD , 4, "true"));
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

        pergunta = (TextView) findViewById(R.id.txtPerguntaLevel2);

        img1 = (Button) findViewById(R.id.imgrespostaA);
        img2 = (Button) findViewById(R.id.imgrespostaB);
        img3 = (Button) findViewById(R.id.imgrespostaC);
        img4 = (Button) findViewById(R.id.imgrespostaD);

        txtScore = (TextView)findViewById(R.id.txtScoreLevel2);
        txtQuestionNum = (TextView)findViewById(R.id.txtTotalQuestionLevel2);
        progressBar = (ProgressBar)findViewById(R.id.progressBarLevel2);
        //pergunta.setText("Qual destas imagens representa a palavra 'Kire' em parkatêjê ?");


        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

        totalQuestion = questoes.size();
        carregarQuestao(0);

    }

    @Override
    public void onClick(View view) {

        if (index < totalQuestion){
            Button clickedButton = (Button)view;
            progressBar.setProgress(0);
            progressValue=0;

            if (clickedButton.getId() != questoes.get(index).getCategoriaID()){
                //resposta correta
                score+=10;
                respostaCerta++;
                carregarQuestao(++index);
            }else {
                //  preencheAlertDialog(builder, false);
                Intent intent = new Intent(this, Done.class);
                Bundle dataSend = new Bundle();
                dataSend.putInt("PONTOS", score);
                dataSend.putInt("TOTAL", totalQuestion);
                dataSend.putInt("CORRETA", respostaCerta);
                intent.putExtras(dataSend);
                startActivity(intent);
                finish();
            }

            txtScore.setText(String.format("%d",score));
        }
    }

    public void preencheAlertDialog(final AlertDialog.Builder builder, boolean respostaCerta) {
        if (respostaCerta) {
            builder.setTitle("Resultado");
            final Pontuacao pontos = new Pontuacao();
            pontos.setAcertos(1);
            builder.setMessage("Resposta certa " );

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

    private void carregarQuestao(int index){

        if (index < totalQuestion){
            thisQuestion++;
            txtQuestionNum.setText(String.format("%d / %d", thisQuestion, totalQuestion));
            progressBar.setProgress(0);
            progressValue=0;

            if (questoes.get(index).getIsImagem().equals("true")) {
                //    imagem.setImageResource(images[index]);
                img1.setBackgroundResource(images1[0]);
                img2.setBackgroundResource(images1[1]);
                img3.setBackgroundResource(images1[2]);
                img4.setBackgroundResource(images1[3]);
                pergunta.setText(questoes.get(index).getPergunta1());
            }
             if (questoes.get(index).getCategoriaID() ==2){
                    img1.setBackgroundResource(images2[0]);
                    img2.setBackgroundResource(images2[1]);
                    img3.setBackgroundResource(images2[2]);
                    img4.setBackgroundResource(images2[3]);
                    pergunta.setText(questoes.get(index).getPergunta1());

                }if (questoes.get(index).getCategoriaID() ==3){
                    img1.setBackgroundResource(images3[0]);
                    img2.setBackgroundResource(images3[1]);
                    img3.setBackgroundResource(images3[2]);
                    img4.setBackgroundResource(images3[3]);
                    pergunta.setText(questoes.get(index).getPergunta1());

                }if (questoes.get(index).getCategoriaID()==4){
                    img1.setBackgroundResource(images4[0]);
                    img2.setBackgroundResource(images4[1]);
                    img3.setBackgroundResource(images4[2]);
                    img4.setBackgroundResource(images4[3]);
                    pergunta.setText(questoes.get(index).getPergunta1());

                }else{

                pergunta.setText(questoes.get(index).getPergunta1());
                //   question_image.setVisibility(View.INVISIBLE);
                //   pergunta.setVisibility(View.VISIBLE);
            }


        }else {
            Intent intent = new Intent(this, Done.class);
            Bundle dataSend = new Bundle();
            dataSend.putInt("PONTOS", score);
            dataSend.putInt("TOTAL", totalQuestion);
            dataSend.putInt("CORRETA", respostaCerta);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();
        }


    }



}
