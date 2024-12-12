package com.ldss.proyectosandroid.home_spa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HistorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historial);

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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.icon_calificacion) {
            Intent intent = new Intent(HistorialActivity.this, CalficacionActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.icon_inicio) {
            Intent intent = new Intent(HistorialActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.icon_reserva) {
            Intent intent = new Intent(HistorialActivity.this, ServiciosActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.icon_perfil) {
            Intent intent = new Intent(HistorialActivity.this, perfilActivity.class);
            startActivity(intent);
        }


            return false;
        }
    }