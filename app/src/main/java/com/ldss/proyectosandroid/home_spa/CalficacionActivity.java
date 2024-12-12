package com.ldss.proyectosandroid.home_spa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ldss.proyectosandroid.home_spa.adaptador.Calificacion;


import java.util.ArrayList;
import java.util.List;

public class CalficacionActivity extends AppCompatActivity {

    private EditText opinionR;
    private RatingBar ratingBar;
    Button enviarDatos;
    private ListView listViewOpinion;


    private List<Calificacion> listOpinion = new ArrayList<Calificacion>();
    ArrayAdapter<Calificacion> opinionAdapter;
    Calificacion calificacionSelected;


    //Variables para manejar la base de datos
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calficacion);

        opinionR=findViewById(R.id.txtOpinionReseña);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        enviarDatos=findViewById(R.id.btnEnviarReseña);
        listViewOpinion=findViewById(R.id.ListViewCalificacion);



        databaseReference = FirebaseDatabase.getInstance().getReference("Reseñas");


        opinionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOpinion);
        listViewOpinion.setAdapter(opinionAdapter);

        /*ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(CalficacionActivity.this, "Hola", Toast.LENGTH_SHORT).show();
            }
        });*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        leerCalificacion();
    }
    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreatePanelMenu(featureId, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.icon_inicio){
            Intent intent = new Intent(CalficacionActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.icon_historial) {
            Intent intent = new Intent(CalficacionActivity.this, HistorialActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.icon_reserva) {
            Intent intent = new Intent(CalficacionActivity.this, ServiciosActivity.class);
            startActivity(intent);
        } else if(item.getItemId() == R.id.icon_perfil) {
            Intent intent = new Intent(CalficacionActivity.this, perfilActivity.class);
            startActivity(intent);
        }
        return false;
    }


    public void EnviarCalificacion(View view) {
        String opinion = opinionR.getText().toString();
        Float estrella= ratingBar.getRating();

        if (opinion.isEmpty()){
            opinionR.setError("Escribe tu opinion");
            return;
        }


        // Obtener la fecha y la hora actuales
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Formato de fecha
        String fechaActual = dateFormat.format(new Date()); // Obtener la fecha actual


        Calificacion data = new Calificacion();

        String id= databaseReference.push().getKey();
        if (id !=null){
            databaseReference.child(id).setValue(data).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    opinionR.setText("");
                    ratingBar.setRating(0);
                    Toast.makeText(this, "Reseña enviado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Error al enviar la reseña", Toast.LENGTH_SHORT).show();
                }

            });
        }

    }

    private void leerCalificacion() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listOpinion.clear();
                for (DataSnapshot objSnapshot : snapshot.getChildren()) {
                    Calificacion c = objSnapshot.getValue(Calificacion.class);
                    if (c != null) {
                        listOpinion.add(c);
                    }
                }
                // Notificamos al adaptador que los datos han cambiado
                opinionAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}