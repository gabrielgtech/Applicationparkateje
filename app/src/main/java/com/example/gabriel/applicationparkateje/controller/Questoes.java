package com.example.gabriel.applicationparkateje.controller;

import com.example.gabriel.applicationparkateje.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Gabriel on 30/10/2017.
 */

public class Questoes {

    private String pergunta;
    private List<String> respostas = new ArrayList<>();
    private int respostaCerta;



    public Questoes(String pergunta, int respostaCerta, String... respostas){
        this.pergunta = pergunta;
        this.respostas.add(respostas[0]);
        this.respostas.add(respostas[1]);
        this.respostas.add(respostas[2]);
        this.respostas.add(respostas[3]);
        this.respostaCerta = respostaCerta;
    }


    public String getPergunta() {
        return pergunta;
    }

    public List<String> getRespostas() {
        return respostas;
    }

    public int getRespostaCerta() {
        return respostaCerta;
    }


}
