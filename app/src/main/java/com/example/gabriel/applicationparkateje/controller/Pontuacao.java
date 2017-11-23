package com.example.gabriel.applicationparkateje.controller;

import java.io.Serializable;

/**
 * Created by Gabriel on 21/11/2017.
 */

public class Pontuacao implements Serializable{
    int acertos;
    int notaFinal;
    int Qtdperguntas;

    public int getQtdperguntas() {
        return Qtdperguntas;
    }

    public void setQtdperguntas(int qtdperguntas) {
        Qtdperguntas = qtdperguntas;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos += acertos ;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

}
