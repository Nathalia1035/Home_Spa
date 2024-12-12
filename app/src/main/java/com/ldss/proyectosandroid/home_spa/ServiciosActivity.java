package com.ldss.proyectosandroid.home_spa;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ServiciosActivity extends AppCompatActivity {
    Button btn;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_servicios);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button buttonRubi = findViewById(R.id.btnRubi);
        buttonRubi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRubi();
            }
        });

        Button buttonAmbar = findViewById(R.id.btnAmbar);
        buttonAmbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAmbar();
            }
        });


        Button buttonDiamante = findViewById(R.id.btnDiamante);
        buttonDiamante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDiamante();
            }
        });

        Button buttonTurquesa = findViewById(R.id.btnTurquesa);
        buttonTurquesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTurquesa();
            }
        });


        Button buttonLove = findViewById(R.id.btnLove);
        buttonLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLove();
            }
        });

        Button buttonKids = findViewById(R.id.btnKids);
        buttonKids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showKids();
            }
        });

        Button buttonLimpieza = findViewById(R.id.btnLimpieza);
        buttonLimpieza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLimpieza();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.icon_calificacion){
            Intent intent = new Intent(ServiciosActivity.this, CalficacionActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.icon_historial) {
            Intent intent = new Intent(ServiciosActivity.this, HistorialActivity.class);
            startActivity(intent);
        } else if (item.getItemId()==R.id.icon_inicio) {
            Intent intent= new Intent(ServiciosActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId()== R.id.icon_perfil) {
            Intent intent = new Intent(ServiciosActivity.this, perfilActivity.class);
            startActivity(intent);

        }

        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showRubi(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.activity_rubi, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        Button btnReservaRubi = dialogView.findViewById(R.id.btnReservaRubi);
        Button btnCerrar = dialogView.findViewById(R.id.btnCerrarRubi);
        btnReservaRubi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiciosActivity.this,ReservaActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void showAmbar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.ambar, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        Button btnReservaAmbar = dialogView.findViewById(R.id.btnReservaAmbar);
        Button btnCerrarAmbar = dialogView.findViewById(R.id.btnCerrarAmbar);
        btnReservaAmbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiciosActivity.this,ReservaActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();

        btnCerrarAmbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void showDiamante(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.diamante, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        Button btnReservaDiamante = dialogView.findViewById(R.id.btnReservaDiamante);
        Button btnCerrarDiamante = dialogView.findViewById(R.id.btnCerrarDiamante);
        btnReservaDiamante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiciosActivity.this,ReservaActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();

        btnCerrarDiamante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void showTurquesa(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.turquesa, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        Button btnReservaTurquesa = dialogView.findViewById(R.id.btnReservaTurquesa);
        Button btnCerrarTurquesa = dialogView.findViewById(R.id.btnCerrarTurquesa);
        btnReservaTurquesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiciosActivity.this,ReservaActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();

        btnCerrarTurquesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void showLove(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.love, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        Button btnReservaLove = dialogView.findViewById(R.id.btnReservaTurquesa);
        btnReservaLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showKids(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.kids, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        Button btnReservaKids = dialogView.findViewById(R.id.btnReservaKids);
        btnReservaKids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showLimpieza(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.limpiezafacial, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        Button btnReservaLimpieza = dialogView.findViewById(R.id.btnReservaLimpieza);
        btnReservaLimpieza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    public void btnReserva(View view) {
        Intent intent = new Intent(ServiciosActivity.this,ReservaActivity.class);
        startActivity(intent);
    }

}



