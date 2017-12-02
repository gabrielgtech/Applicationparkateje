package com.example.gabriel.applicationparkateje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Done extends AppCompatActivity {

    Button btnJogarNovamente, prxLevel;
    TextView txResultScore, getTxtResultQuestions;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);



        txResultScore = (TextView)findViewById(R.id.txtTotalScore);
        getTxtResultQuestions = (TextView)findViewById(R.id.txtTotalQuestion);
        progressBar = (ProgressBar)findViewById(R.id.doneProgress);
        btnJogarNovamente = (Button)findViewById(R.id.btnJogarNovamente);
        prxLevel =(Button)findViewById(R.id.btnProximaFase);

        prxLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Done .this, com.example.gabriel.applicationparkateje.controller.jogo2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        btnJogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Done .this, Tela2.class);
                startActivity(intent);
                finish();
            }
        });

        Bundle extra = getIntent().getExtras();
        if (extra != null){

            int score = extra.getInt("PONTOS");
            int totalQuestion = extra.getInt("TOTAL");
            int respostaCerta = extra.getInt("CORRETA");

            txResultScore.setText(String.format("SCORE : %d", score));
            getTxtResultQuestions.setText(String.format("PASSED : %d / %d", respostaCerta, totalQuestion));

            progressBar.setMax(totalQuestion);
            progressBar.setProgress(respostaCerta);

            /*
            question_score.child(String.format("%s_%s", Common.currentUser,  Common.categoryId))
                    .setValue(new QuestionScore(String.format("%s_%s", Common.currentUser, Common.categoryId), String.valueOf(score)));
        */
        }
    }
}
