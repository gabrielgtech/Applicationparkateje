package com.example.gabriel.applicationparkateje.controller;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabriel.applicationparkateje.Done;
import com.example.gabriel.applicationparkateje.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;




public class JogoActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imagem, question_image;
    Button opcao1, opcao2, opcao3, opcao4;
    TextView pergunta, txtScore, txtQuestionNum;
    int progressValue =0;
    int index=0, score=0 , thisQuestion=0,totalQuestion=0, respostaCerta;
    int [] images = {R.drawable.cachorro, R.drawable.cobra, R.drawable.jacare, R.drawable.icn_paca,
                     R.drawable.icn_cupuacu,R.drawable.icn_caju, R.drawable.icn_castanha, R.drawable.icn_oco};
    int [] audios = {R.raw.cachorro, R.raw.jiboia, R.raw.jacare, R.raw.paca,
                     R.raw.cupuacu,R.raw.caju,R.raw.castanha,R.raw.coco};

    ProgressBar progressBar;
    private AlertDialog respostaCorreta, respostaIncorreta;

   // String[] AnimaisParkateje = {"Kire", "Hàkati", "Mĩre", "Kra"};

    List<Questoes> questoes = new ArrayList<Questoes>(){
        {
            add(new Questoes("1","true","Escute o audio pressionando a imagem abaixo, e escolha a opção correta ?",
                    "Rop", "Hàkati", "Mĩre", "Kra", "Rop"));
            add(new Questoes("2","true","Escute o audio pressionando a imagem abaixo, e escolha a opção correta ?",
                    "Mĩre", "Kra", "Rop", "Hàkati", "Hàkati"));
            add(new Questoes("3","true","Escute o audio pressionando a imagem abaixo, e escolha a opção correta ?",
                    "Hàkati", "Rop", "Mĩre", "Kra", "Mĩre"));
            add(new Questoes("4","true","Escute o audio pressionando a imagem abaixo, e escolha a opção correta ?",
                    "Kra", "Hàkati", "Mĩre", "Rop", "Kra"));

            add(new Questoes("5","true","Escute o audio pressionando a imagem abaixo, e escolha a opção correta ?",
                    "aKrýtýtikô", "Kôtài", "pàrhô", "rôti", "Kôtài"));//cupuaçu
            add(new Questoes("6","true","Escute o audio pressionando a imagem abaixo, e escolha a opção correta ?",
                    "pàrhô", "aKrýtýtikô", "Kôtài", "rôti", "aKrýtýtikô"));//caju
            add(new Questoes("7","true","Escute o audio pressionando a imagem abaixo, e escolha a opção correta ?",
                    "rôti", "pàrhô", "Kôtài", "aKrýtýtikô", "pàrhô"));//castanha
            add(new Questoes("8","true","Escute o audio pressionando a imagem abaixo, e escolha a opção correta ?",
                    "Kôtài", "aKrýtýtikô", "rôti", "pàrhô", "rôti"));//coco

        }
    };
    //final AlertDialog.Builder builder = new AlertDialog.Builder(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        imagem = (ImageView) findViewById(R.id.question_image);
        opcao1 = (Button) findViewById(R.id.btnRespostaA);
        opcao2 = (Button) findViewById(R.id.btnRespostaB);
        opcao3 = (Button) findViewById(R.id.btnRespostaC);
        opcao4 = (Button) findViewById(R.id.btnRespostaD);
        pergunta = (TextView) findViewById(R.id.question_text);

        txtScore = (TextView)findViewById(R.id.txtScore);
        txtQuestionNum = (TextView)findViewById(R.id.txtTotalQuestion);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        opcao1.setOnClickListener(this);
        opcao2.setOnClickListener(this);
        opcao3.setOnClickListener(this);
        opcao4.setOnClickListener(this);

        totalQuestion = questoes.size();

        carregarQuestao(0);



    }

    @Override
    public void onClick(View view) {

        if (index < totalQuestion){
            Button clickedButton = (Button)view;
            progressBar.setProgress(0);
            progressValue=0;

            if (clickedButton.getText().equals(questoes.get(index).getRespostaCorreta())){
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

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void preencheAlertDialog(AlertDialog.Builder builder, boolean respostaCerta) {
        if (respostaCerta) {
            builder.setTitle("Resultado");
          //  final Pontuacao pontos = new Pontuacao();
           // pontos.setAcertos(1);
            builder.setMessage(" Resposta Correta  ");

            builder.setIcon(R.drawable.check);
            builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(getApplicationContext(), jogo2Activity.class);
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

            if (questoes.get(index).getIsImageQuestion().equals("true")){
                final MediaPlayer audio = MediaPlayer.create(this, audios[index]);

                imagem.setImageResource(images[index]);
                pergunta.setText(questoes.get(index).getPergunta());

                //metodo que toca o audio
                imagem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        audio.start();
                    }
                });


              //  question_image.setVisibility(View.VISIBLE);
               // pergunta.setVisibility(View.INVISIBLE);

            }else{

                pergunta.setText(questoes.get(index).getPergunta());
             //   question_image.setVisibility(View.INVISIBLE);
             //   pergunta.setVisibility(View.VISIBLE);
            }

            opcao1.setText(questoes.get(index).getRespostaA());
            opcao2.setText(questoes.get(index).getRespostaB());
            opcao3.setText(questoes.get(index).getRespostaC());
            opcao4.setText(questoes.get(index).getRespostaD());

            //mCountDown.start(); // iniciando o contador
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
/*
        Questoes q = questoes.remove(0);
        pergunta.setText(q.getPergunta());
        List<String> resposta = q.getRespostas();
        opcao1.setText(resposta.get(0));
        opcao2.setText(resposta.get(1));
        opcao3.setText(resposta.get(2));
        opcao4.setText(resposta.get(3));
        respostaCerta = q.getRespostaCerta();*/

    }

}
