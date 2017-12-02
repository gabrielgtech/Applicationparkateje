package com.example.gabriel.applicationparkateje.controller;

import com.example.gabriel.applicationparkateje.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Gabriel on 30/10/2017.
 */

public class Questoes {

   // private String pergunta;
    //private List<String> respostas = new ArrayList<>();
   // private int respostaCerta;
    //private String isImageQuestion ;
    private String CategoryId, IsImageQuestion, Pergunta, RespostaA, RespostaB, RespostaC, RespostaD,  RespostaCorreta ;

    public Questoes() {
    }

    public Questoes(String categoryId, String isImageQuestion, String pergunta, String respostaA, String respostaB, String respostaC, String respostaD, String respostaCorreta) {
        CategoryId = categoryId;
        IsImageQuestion = isImageQuestion;
        Pergunta = pergunta;
        RespostaA = respostaA;
        RespostaB = respostaB;
        RespostaC = respostaC;
        RespostaD = respostaD;
        RespostaCorreta = respostaCorreta;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getIsImageQuestion() {
        return IsImageQuestion;
    }

    public void setIsImageQuestion(String isImageQuestion) {
        IsImageQuestion = isImageQuestion;
    }

    public String getPergunta() {
        return Pergunta;
    }

    public void setPergunta(String pergunta) {
        Pergunta = pergunta;
    }

    public String getRespostaA() {
        return RespostaA;
    }

    public void setRespostaA(String respostaA) {
        RespostaA = respostaA;
    }

    public String getRespostaB() {
        return RespostaB;
    }

    public void setRespostaB(String respostaB) {
        RespostaB = respostaB;
    }

    public String getRespostaC() {
        return RespostaC;
    }

    public void setRespostaC(String respostaC) {
        RespostaC = respostaC;
    }

    public String getRespostaD() {
        return RespostaD;
    }

    public void setRespostaD(String respostaD) {
        RespostaD = respostaD;
    }

    public String getRespostaCorreta() {
        return RespostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        RespostaCorreta = respostaCorreta;
    }

    private String pergunta1, IsImagem;
    private List<Integer> respostas1 = new ArrayList<>();
    private int respostaCerta1, categoriaID;

    public Questoes(String pergunta1, int []images, int respostaCerta1, int categoriaID, String Isimagem) {
        this.pergunta1 = pergunta1;
        this.respostas1.add(images[0]);
        this.respostas1.add(images[1]);
        this.respostas1.add(images[2]);
        this.respostas1.add(images[3]);
        this.respostaCerta1 = respostaCerta1;
        this.categoriaID = categoriaID;
        this.IsImagem = Isimagem;
    }

    public String getIsImagem() {
        return IsImagem;
    }

    public void setIsImagem(String isImagem) {
        IsImagem = isImagem;
    }

    public String getPergunta1() {
        return pergunta1;
    }

    public void setPergunta1(String pergunta1) {
        this.pergunta1 = pergunta1;
    }

    public List<Integer> getRespostas1() {
        return respostas1;
    }

    public void setRespostas1(List<Integer> respostas1) {
        this.respostas1 = respostas1;
    }

    public int getRespostaCerta1() {
        return respostaCerta1;
    }

    public void setRespostaCerta1(int respostaCerta1) {
        this.respostaCerta1 = respostaCerta1;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }
}
