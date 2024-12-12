package com.ldss.proyectosandroid.home_spa.adaptador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ldss.proyectosandroid.home_spa.R;

public class galeriaimagenes extends BaseAdapter {
    private  Context miContext;
    public int [] arrayImagenes = {

            R.drawable.spapareja,
            R.drawable.camillas2,
            R.drawable.depilacion,
            R.drawable.fotospa,
            R.drawable.individual,
            R.drawable.individualfoto,
            R.drawable.mujerspa,
            R.drawable.camillafoto,
            R.drawable.spayamid,
    };
    public galeriaimagenes(Context miContext){ this.miContext=miContext;}

    @Override
    public int getCount() {
        return arrayImagenes.length;
    }

    @Override
    public Object getItem(int position) {
        return arrayImagenes[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ImageView imageView= new ImageView(miContext);
        imageView.setImageResource(arrayImagenes[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(
                new ViewGroup.LayoutParams(490,500)
        );
        return imageView;
    }
}

