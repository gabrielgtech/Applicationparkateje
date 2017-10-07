package com.example.gabriel.applicationparkateje;

import java.io.Serializable;

/**
 * Created by Gabriel on 19/09/2017.
 */

public class Dados implements Serializable{
    private int Id;
    private String Titulo;
    private String Detalhes;
    private int Imagem;

    public Dados(int id, String titulo, String detalhes, int imagem) {
        Id = id;
        Titulo = titulo;
        Detalhes = detalhes;
        Imagem = imagem;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDetalhes() {
        return Detalhes;
    }

    public void setDetalhes(String detalhes) {
        Detalhes = detalhes;
    }

    public int getImagem() {
        return Imagem;
    }

    public void setImagem(int imagem) {
        Imagem = imagem;
    }
}
