package com.example.gabriel.applicationparkateje.palavras;

import android.media.MediaPlayer;

/**
 * Created by Gabriel on 22/09/2017.
 */

public class Objetos {
    String nome;
    int id;
    int imagem;
    MediaPlayer audio;


    public Objetos(String nome, int id, int imagem, MediaPlayer audio) {
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
