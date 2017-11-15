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

    private String pergunta1;
    private List<Integer> respostas1 = new ArrayList<>();
    private int respostaCerta1;


    public Questoes(String pergunta, int respostaCerta, String... respostas){
        this.pergunta = pergunta;
        this.respostas.add(respostas[0]);
        this.respostas.add(respostas[1]);
        this.respostas.add(respostas[2]);
        this.respostas.add(respostas[3]);
        this.respostaCerta = respostaCerta;
    }

    public Questoes(String pergunta, int respostaCerta, int []images){

        this.pergunta1 = pergunta;
        this.respostas1.add(images[0]);
        this.respostas1.add(images[1]);
        this.respostas1.add(images[2]);
        this.respostas1.add(images[3]);
        this.respostaCerta1 = respostaCerta;
    }



    public String getPergunta() {
        return pergunta;
    }
    public String getPergunta1() {
        return pergunta1;
    }

    public List<String> getRespostas() {
        return respostas;
    }
    public List<Integer> getRespostas1() {
        return respostas1;
    }
    public int getRespostaCerta1() {
        return respostaCerta1;
    }

    public int getRespostaCerta() {
        return respostaCerta;
    }


}
