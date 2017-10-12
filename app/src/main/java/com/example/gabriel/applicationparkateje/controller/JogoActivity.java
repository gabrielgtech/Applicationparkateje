package com.example.gabriel.applicationparkateje.controller;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabriel.applicationparkateje.R;

import java.lang.reflect.Array;

public class JogoActivity extends AppCompatActivity {

    ImageView imagem;
    Button opcao1,opcao2,opcao3,opcao4;
    TextView pergunta;
    Button[] botoes = new Button[4];
    boolean pressionado = false;
    private AlertDialog respostaCorreta, respostaIncorreta;

    String[] Animais = {"Cachorro","Jiboia","Jacaré","paca"};
    String[] AnimaisParkateje = {"Kire","Hàkati","Mĩre","Kra"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        imagem = (ImageView)findViewById(R.id.imgJogo);
        opcao1 = (Button)findViewById(R.id.opcao1);
        opcao2 = (Button)findViewById(R.id.opcao2);
        opcao3 = (Button)findViewById(R.id.opcao3);
        opcao4 = (Button)findViewById(R.id.opcao4);
        pergunta = (TextView)findViewById(R.id.pergunta);
        botoes = new Button[]{opcao1, opcao2, opcao3, opcao4};

        final MediaPlayer audio = MediaPlayer.create(this, R.raw.cachorro);
        imagem.setImageResource(R.drawable.cachorro);

        opcao1.setText(AnimaisParkateje[0]);
        opcao2.setText(AnimaisParkateje[1]);
        opcao3.setText(AnimaisParkateje[2]);
        opcao4.setText(AnimaisParkateje[3]);
        pergunta.setText("Escute o audio pressionando a imagem a cima, e escolha a opção correta ?");

        //metodo que toca o audio
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
                    pressionado = true;
                    builder.setTitle("Resultado");
                    builder.setMessage(" Resposta Correta ");

                    builder.setIcon(R.drawable.check);
                    builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(),jogo2Activity.class );
                            startActivity(intent);
                        }
                    });

                    respostaCorreta = builder.create();
                    respostaCorreta.show();

                }
            });

        opcao2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                builder.setTitle("Resultado");
                builder.setMessage("! ! ! Resposta Incorreta ! ! !");
                builder.setIcon(R.drawable.incorrect);
                builder.setNegativeButton("Tente Novamente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                respostaIncorreta = builder.create();
                respostaIncorreta.show();

            }
        });

        opcao3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                builder.setTitle("Resultado");
                builder.setMessage("! ! ! Resposta Incorreta ! ! !");
                builder.setIcon(R.drawable.incorrect);
                builder.setNegativeButton("Tente Novamente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                respostaIncorreta = builder.create();
                respostaIncorreta.show();
            }
        });

        opcao4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                builder.setTitle("Resultado");
                builder.setMessage("! ! ! Resposta Incorreta ! ! !");
                builder.setIcon(R.drawable.incorrect);
                builder.setNegativeButton("Tente Novamente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                respostaIncorreta = builder.create();
                respostaIncorreta.show();

            }
        });

    }
}
