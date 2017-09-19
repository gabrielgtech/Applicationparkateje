package com.example.gabriel.applicationparkateje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gabriel on 19/09/2017.
 */

public class Adapter extends BaseAdapter{

    Context context;
    List<Dados>listaObjetos;

    public Adapter(Context context, List<Dados> listaObjetos) {
        this.context = context;
        this.listaObjetos = listaObjetos;
    }




    @Override
    public int getCount() {
        return listaObjetos.size(); // retorna a quantidade de elementos da lista
    }

    @Override
    public Object getItem(int position) {
        return listaObjetos.get(position); // retorna a posição do objeto
    }

    @Override
    public long getItemId(int position) {
        return listaObjetos.get(position).getId(); // retorna o id do objeto na posição
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View visao = view;

        LayoutInflater inflate = LayoutInflater.from(context);
        visao = inflate.inflate(R.layout.itemlista, null);

        ImageView imagem = (ImageView)visao.findViewById(R.id.imageView);
        TextView titulo = (TextView)visao.findViewById(R.id.txtTitulo);
        TextView descricao = (TextView)visao.findViewById(R.id.txtDescricao);

        imagem.setImageResource(listaObjetos.get(position).getImagem());
        titulo.setText(listaObjetos.get(position).getTitulo().toString());
        descricao.setText(listaObjetos.get(position).getDetalhes().toString());

        return visao;
    }
}
