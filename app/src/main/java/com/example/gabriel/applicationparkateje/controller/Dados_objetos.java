package com.example.gabriel.applicationparkateje.controller;

import android.media.MediaPlayer;

import java.io.Serializable;

/**
 * Created by Gabriel on 04/10/2017.
 */

public class Dados_objetos implements Serializable{


    String nome;
    int id;
    int imagem;
    MediaPlayer audio;

    public Dados_objetos(String nome, int id, int imagem, MediaPlayer audio) {
        this.nome = nome;
        this.id = id;
        this.imagem = imagem;
        this.audio = audio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public MediaPlayer getAudio() {
        return audio;
    }

    public void setAudio(MediaPlayer audio) {
        this.audio = audio;
    }
}
