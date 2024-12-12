package com.ldss.proyectosandroid.home_spa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ldss.proyectosandroid.home_spa.adaptador.Reserva;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.Query;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import android.util.Log;

public class HistorialActivity extends AppCompatActivity {

    private List<Reserva> listReserva = new ArrayList<Reserva>();
    ArrayAdapter<Reserva> reservasAdapter;
    private ListView listViewReservas;
    DatabaseReference databaseReference;
    Query queryReservas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseReference = FirebaseDatabase.getInstance().getReference("Reserva:" );
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historial);
        listViewReservas = findViewById(R.id.ListViewReservas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        Intent intent = getIntent();
        String uidReserva = intent.getStringExtra("uid");
        queryReservas = databaseReference.orderByChild("uid").equalTo(uidReserva);
        listReserva = new ArrayList<>();
        /*
        reservasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listReserva);
        listViewReservas.setAdapter(reservasAdapter);
        */
        queryReservas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listReserva.clear(); // Limpiar la lista antes de agregar nuevos datos

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Reserva reserva = snapshot.getValue(Reserva.class);
                    listReserva.add(reserva);
                }

                // Notificar al adaptador que los datos han cambiado
                reservasAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Manejar errores
                Log.e("Firebase", "Error al leer datos: " + databaseError.getMessage());
            }
        });
        reservasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listReserva);
        listViewReservas.setAdapter(reservasAdapter);
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