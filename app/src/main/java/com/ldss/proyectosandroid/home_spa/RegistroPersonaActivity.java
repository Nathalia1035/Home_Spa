package com.ldss.proyectosandroid.home_spa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ldss.proyectosandroid.home_spa.modelo.Registro;

public class RegistroPersonaActivity extends AppCompatActivity {

    private EditText nombreR;
    private EditText apellidoR;
    private EditText direccionR;
    private EditText telefonoR;
    private EditText passwordR;
    Button registro;
    private EditText documentoR;



    //Variables para manejar la base de datos
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_persona);

        documentoR=findViewById(R.id.txtDocumentoRegistro);
        nombreR = findViewById(R.id.txtNombreRegistro);
        apellidoR = findViewById(R.id.txtApellidoRegistro);
        direccionR = findViewById(R.id.txtDireccionRegistro);
        telefonoR = findViewById(R.id.txtTelefonoRegistro);
        passwordR = findViewById(R.id.txtContrasenaRegistro);
        registro=findViewById(R.id.btnRegistrar);

        databaseReference = FirebaseDatabase.getInstance().getReference();

    }

    private void limpiarcajas() {
        documentoR.setText("");
        nombreR.setText("");
        apellidoR.setText("");
        direccionR.setText("");
        telefonoR.setText("");
        passwordR.setText("");
    }

    private void validacion() {
        String documento=documentoR.getText().toString();
        String nombre = nombreR.getText().toString();
        String apellido = apellidoR.getText().toString();
        String direccion = direccionR.getText().toString();
        String telefono = telefonoR.getText().toString();
        String password = passwordR.getText().toString();
        if (documento.isEmpty()) {
            documentoR.setError("Requerido");
        }else if (nombre.isEmpty()) {
            nombreR.setError("Requerido");
        } else if (apellido.isEmpty()) {
            apellidoR.setError("Requerido");
        } else if (direccion.isEmpty()) {
            direccionR.setError("Requerido");
        } else if (telefono.isEmpty()) {
            telefonoR.setError("Requerido");
        } else if (password.isEmpty()) {
            passwordR.setError("Requerido");
        }
    }


    public void RegistrarUsuario(View view) {
        String documento=documentoR.getText().toString();
        String nombre = nombreR.getText().toString();
        String apellido = apellidoR.getText().toString();
        String direccion = direccionR.getText().toString();
        String telefono = telefonoR.getText().toString();
        String password = passwordR.getText().toString();

        if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || password.isEmpty() || documento.isEmpty()) {
            Toast.makeText(this,"Todos los campos son obligatorios",Toast.LENGTH_SHORT).show();
            validacion();
        }else {
            Registro r = new Registro();
            r.setUID(documento);
            r.setNombreR(nombre);
            r.setApellidoR(apellido);
            r.setDireccionR(direccion);
            r.setTelefonoR(telefono);
            r.setPasswordR(password);

            // Depuración: mostrar los datos antes de enviarlos a Firebase
            Log.d("Registro", "Datos a registrar: ");
            Log.d("Registro", "Correo: " + r.getUID());
            Log.d("Registro", "Nombre: " + r.getNombreR());
            Log.d("Registro", "Apellido: " + r.getApellidoR());
            Log.d("Registro", "Dirección: " + r.getDireccionR());
            Log.d("Registro", "Teléfono: " + r.getTelefonoR());
            Log.d("Registro", "Contraseña: " + r.getPasswordR());

            databaseReference.child("Registro").child(documento.replace(".", ",")).setValue(r).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistroPersonaActivity.this,LoginActivity.class);
                    startActivity(intent);
                    limpiarcajas();
                } else {
                    Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}




