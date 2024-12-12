package com.ldss.proyectosandroid.home_spa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CitasClienteActivity extends AppCompatActivity {

    private Button btnIrAVerMas1;
    private Button btnIrAVerMas2;
    private Button btnIrAVerMas3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_citas_cliente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Metodo para que el boton vaya a la activity registro
    public void IrAVerMas1 (View v){
        btnIrAVerMas1= (Button) findViewById(R.id.btnVerMas1);
        btnIrAVerMas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnIrAVerMas1 = new Intent(CitasClienteActivity.this, Reserva_ClienteActivity.class);
                startActivities(new Intent[]{btnIrAVerMas1});
            }
        });

    }

    public void IrAVerMas2 (View v){
        btnIrAVerMas2= (Button) findViewById(R.id.btnVerMas2);
        btnIrAVerMas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnIrAVerMas2 = new Intent(CitasClienteActivity.this, Reserva_ClienteActivity.class);
                startActivities(new Intent[]{btnIrAVerMas2});
            }
        });

    }

    public void IrAVerMas3 (View v){
        btnIrAVerMas3= (Button) findViewById(R.id.btnVerMas3);
        btnIrAVerMas3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnIrAVerMas3 = new Intent(CitasClienteActivity.this, Reserva_ClienteActivity.class);
                startActivities(new Intent[]{btnIrAVerMas3});
            }
        });

    }


}