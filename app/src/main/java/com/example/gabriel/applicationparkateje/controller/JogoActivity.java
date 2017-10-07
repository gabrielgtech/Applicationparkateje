package com.example.gabriel.applicationparkateje.controller;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabriel.applicationparkateje.R;

public class JogoActivity extends AppCompatActivity {

    ImageView imagem;
    Button opcao1,opcao2,opcao3,opcao4;
    TextView pergunta;

    String[] Animais = {"Cachorro","Jiboia","Jacaré","paca"};
    String[] AnimaisParkateje = {"Kire","Hàkati","Mĩre","Kra"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        imagem = (ImageView)findViewById(R.id.imgJogo);
        opcao1 = (Button) findViewById(R.id.opcao1);
        opcao2 = (Button)findViewById(R.id.opcao2);
        opcao3 = (Button)findViewById(R.id.opcao3);
        opcao4 = (Button)findViewById(R.id.opcao4);
        pergunta = (TextView)findViewById(R.id.pergunta);

        final MediaPlayer audio = MediaPlayer.create(this, R.raw.cachorro);
        imagem.setImageResource(R.drawable.cachorro);

        opcao1.setText(AnimaisParkateje[1]);
        opcao2.setText(AnimaisParkateje[2]);
        opcao3.setText(AnimaisParkateje[3]);
        opcao4.setText(AnimaisParkateje[4]);
        pergunta.setText("Qual destas é a opção correta ?");

        //metodo que toca o audio
        imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio.start();

            }
        });

        if (!opcao1.isSelected()){
            Toast.makeText(getApplicationContext(),"Resposta Incorreta",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Resposta Correta",Toast.LENGTH_LONG).show();
        }
    }



}
