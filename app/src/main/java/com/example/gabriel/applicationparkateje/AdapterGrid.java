package com.example.gabriel.applicationparkateje;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gabriel on 20/09/2017.
 */

public class AdapterGrid extends BaseAdapter {

    private Context context;
    private List<Dados> lista;

    public AdapterGrid(Context context, List<Dados> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
         return lista.get(position).getId();
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {


            LayoutInflater inflate = LayoutInflater.from(context);
            view = inflate.inflate(R.layout.grid_item, null);

           // LinearLayout linear = (LinearLayout) view.findViewById(R.id.griditem);
            final ImageView imagem = view.findViewById(R.id.imageView);
            TextView titulo = view.findViewById(R.id.txtTitulo2);

            imagem.setImageResource(lista.get(position).getImagem());
            titulo.setText(lista.get(position).getTitulo().toString());




        return view;
    }
}
