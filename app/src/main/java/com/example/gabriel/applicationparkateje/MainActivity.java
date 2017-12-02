package com.example.gabriel.applicationparkateje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gabriel.applicationparkateje.controller.HistoryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAprender = (Button)findViewById(R.id.aprender);
        Button btnHistoria = (Button)findViewById(R.id.historia);
        btnAprender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreLista(view);
                            }
        });

        btnHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    public void abreLista(View view){
        Intent intent = new Intent(this, Tela2.class);
        startActivity(intent);
    }
}
