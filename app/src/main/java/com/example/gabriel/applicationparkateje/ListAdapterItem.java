package com.example.gabriel.applicationparkateje;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gabriel on 13/09/2017.
 */

public class ListAdapterItem extends ArrayAdapter<item> {

    private Context context;
    private ArrayList<item> lista;

    public ListAdapterItem(Context context, ArrayList<item> lista){
        super(context,0, lista);
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        item itemPosicao = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item, null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        imageView.setImageResource(itemPosicao.getImagem());

        TextView textView = (TextView) convertView.findViewById(R.id.txtNome);
        textView.setText(itemPosicao.getNome());

        return convertView;
    }
}
