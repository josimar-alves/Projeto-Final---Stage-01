package com.example.jr.projetofinal_stage01;

/**
 * Created by Jr on 07/04/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Jr on 07/04/2016.
 */
public class ImagemAdapter extends BaseAdapter {
    private int [] imagens;
    private Context context;

    public ImagemAdapter (Context c, int[] imagens) {
        this.context = c;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return imagens.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.adapter_imagem, parent, false);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setImageResource(imagens[position]);
        return view;
    }
}
