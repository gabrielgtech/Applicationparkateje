package com.example.gabriel.applicationparkateje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAprender = (Button)findViewById(R.id.aprender);
        btnAprender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreLista(view);
                            }
        });
    }

    public void abreLista(View view){
        Intent intent = new Intent(this, Tela2.class);
        startActivity(intent);
    }
}
