package com.ldss.proyectosandroid.home_spa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ldss.proyectosandroid.home_spa.adaptador.galeriaimagenes;

public class MainActivity extends AppCompatActivity {

    private GridView gridViewImagenes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridViewImagenes=findViewById(R.id.vistaImagenes);
        gridViewImagenes.setAdapter(new galeriaimagenes(this));
        gridViewImagenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),fullScreenActivity.class);
                intent.putExtra("idimagen", position);
                startActivity(intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.icon_calificacion){
            Intent intent = new Intent(MainActivity.this,CalficacionActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.icon_historial) {
            Intent intent = new Intent(MainActivity.this,HistorialActivity.class);
            startActivity(intent);
        } else if (item.getItemId()==R.id.icon_reserva) {
            Intent intent= new Intent(MainActivity.this,ServiciosActivity.class);
            startActivity(intent);
        } else if (item.getItemId()== R.id.icon_perfil) {
            Intent intent = new Intent(MainActivity.this,perfilActivity.class);
            startActivity(intent);
        }

        return false;
    }
    }



