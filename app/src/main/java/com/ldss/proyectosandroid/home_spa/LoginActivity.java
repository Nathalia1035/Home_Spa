package com.ldss.proyectosandroid.home_spa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    EditText txtNombreusuariologin;
    EditText txtContrasenausuariologin;
    Button Ingresa;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        auth=FirebaseAuth.getInstance();

        txtNombreusuariologin=findViewById(R.id.txtNombreusuarioLogin);
        txtContrasenausuariologin=(EditText) findViewById(R.id.txtContrasenaRegistro);


        Ingresa=findViewById(R.id.buttonLogin);


        Ingresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Correo = txtNombreusuariologin.getText().toString();
                String Password = txtContrasenausuariologin.getText().toString();

                auth.signInWithEmailAndPassword(Correo,Password)
                        .addOnCompleteListener(LoginActivity.this, task -> {
                            if (task.isSuccessful()) {
                                Intent nuevo = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(nuevo);
                            } else {
                                // Toast.makeText(LoginActivity.this, "Fallo en el login " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecta ", Toast.LENGTH_SHORT).show();
                            }
                        });

            }

        });
    }

    //Boton registrar
    public void btnRegistrar(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistroPersonaActivity.class);
        startActivity(intent);
    }

}




