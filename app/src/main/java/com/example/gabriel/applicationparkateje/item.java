package com.example.gabriel.applicationparkateje;

/**
 * Created by Gabriel on 13/09/2017.
 */

public class item {
    private int imagem;
    private String nome;

    public item(int imagem, String nome){
        this.imagem = imagem;
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
