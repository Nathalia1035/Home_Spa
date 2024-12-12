package com.ldss.proyectosandroid.home_spa;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.gms.common.api.Status;
import android.util.Log; // Importa Log

import com.ldss.proyectosandroid.home_spa.modelo.Reserva;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.PlaceFeature;
import com.google.android.libraries.places.api.model.Place;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ldss.proyectosandroid.home_spa.modelo.Registro;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ReservaActivity extends AppCompatActivity {

    private static final int AUTOCOMPLETE_REQUEST_CODE = 1;
    CalendarView calendario;
    TextView fecha;
    TextView Thora;
    TextView txtdireccion;
    TextView nombre;
    TextView telefono;
    Button reserva;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reserva);


        calendario = findViewById(R.id.calendario);
        fecha = findViewById(R.id.txtFechaReserva);
        Thora = findViewById(R.id.txtHoraReserva);
        txtdireccion = findViewById(R.id.txtDireccionReserva);
        nombre = findViewById(R.id.txtNombreCompletoReserva);
        telefono = findViewById(R.id.nmTelefonoRerserva);

        databaseReference = FirebaseDatabase.getInstance().getReference("Reserva:" );

        Places.initialize(getApplicationContext(), "YOUR_API_KEY");
        Button searchButton = findViewById(R.id.btnmapa);
        searchButton.setOnClickListener(v -> openAutocomplete());


        //Funcionalidad calendario
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String Fecha = dayOfMonth + " / " + (month + 1) + "/ " + year;
                fecha.setText(Fecha);
            }
        });
    }
    private void limpiarcajas() {
        fecha.setText("");
        Thora.setText("");
        nombre.setText("");
        txtdireccion.setText("");
        telefono.setText("");
    }

    public void guardarReserva(View view){
        String Fecha = fecha.getText().toString();
        String Hora = Thora.getText().toString();
        String Nombre = nombre.getText().toString();
        String Direccion = txtdireccion.getText().toString();
        String Telefono = telefono.getText().toString();


        Reserva r = new Reserva();
        r.setUID(Nombre);
        r.setFecha(Fecha);
        r.setHora(Hora);
        r.setNombre(Nombre);
        r.setDireccion(Direccion);
        r.setTelefono(Telefono);
        String id= databaseReference.push().getKey();
        databaseReference.child(id).setValue(r).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(this, "Reserva exitosa", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ReservaActivity.this, HistorialActivity.class);
                startActivity(intent);
                limpiarcajas();

            } else {
                Toast.makeText(this, " " + task.getException(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void openAutocomplete() {
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS);

        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);
    }

    //Boton mapa
    public void Mapa(View view) {
        Intent objMapa = new Intent(ReservaActivity.this, MapaActivity.class);
        startActivity(objMapa);
    }

    //Barra menu
    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    //Accion de los iconos del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.icon_calificacion) {
            Intent intent = new Intent(ReservaActivity.this, CalficacionActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.icon_inicio) {
            Intent reserva = new Intent(ReservaActivity.this, MainActivity.class);
            startActivity(reserva);

        }

        return false;
    }


    public void abrirHora(View view) {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(calendar.HOUR_OF_DAY);
        int min = calendar.get(calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(ReservaActivity.this, R.style.TimePicker, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourForDay, int minute) {
                String am_pm;
                if (hourForDay > 12) {
                    hourForDay = hourForDay - 12;
                    am_pm = "PM";
                } else {
                    am_pm = "AM";
                }
                Thora.setText(hourForDay + ":" + minute + " " + am_pm);
            }
        }, hora, min, false);
        tpd.show();
    }

    public void btncancelar(View view) {
        Toast.makeText(this, "Reserva cancelada", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ReservaActivity.this, ServiciosActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                String address = place.getAddress();

                // Busca el EditText y actualiza su contenido
                EditText editText = findViewById(R.id.txtDireccionReserva);
                editText.setText(address);
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i("TAG", status.getStatusMessage());
            }
        }
    }






}