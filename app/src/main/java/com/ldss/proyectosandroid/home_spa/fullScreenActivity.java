package com.ldss.proyectosandroid.home_spa;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ldss.proyectosandroid.home_spa.adaptador.galeriaimagenes;

public class fullScreenActivity extends AppCompatActivity {

    ImageView imageViewDetalle;
    galeriaimagenes galeriaImagenesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_screen);

        imageViewDetalle=findViewById(R.id.detalleimagen);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setTitle("Fotos");
        }


        // flecha atras
        actionBar.setDisplayHomeAsUpEnabled(true);
        //color barra
        ColorDrawable color = new ColorDrawable(Color.parseColor("#EF73AB"));
        actionBar.setBackgroundDrawable(color);


        Intent i = getIntent();
        int posicion = i.getExtras().getInt("idimagen");
        galeriaImagenesAdapter = new galeriaimagenes(this);
        imageViewDetalle.setImageResource(galeriaImagenesAdapter.arrayImagenes[posicion]);
    }

    //funcionamiento flecha
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}