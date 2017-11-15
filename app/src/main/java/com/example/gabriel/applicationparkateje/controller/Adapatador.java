package com.example.gabriel.applicationparkateje.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabriel.applicationparkateje.Dados;
import com.example.gabriel.applicationparkateje.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 04/10/2017
 */

public class Adapatador extends BaseAdapter{
    Context context;
    List<Dados_objetos> listaObjetos;

    public Adapatador(Context context, List<Dados_objetos> listaObjetos) {
        this.context = context;
        this.listaObjetos = listaObjetos;

    }

    @Override
    public int getCount() {
        return listaObjetos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaObjetos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaObjetos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View visao = view;

        LayoutInflater inflate = LayoutInflater.from(context);
        visao = inflate.inflate(R.layout.grid_item, null);

        TextView nome =  visao.findViewById(R.id.txtTitulo2);
        ImageView imagem = visao.findViewById(R.id.imageView);

        nome.setText(listaObjetos.get(i).getNome());
        imagem.setImageResource(listaObjetos.get(i).getImagem());

        return visao;
    }
}
