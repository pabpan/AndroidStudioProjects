package pablo.suarez.matriculacionalumnos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pablo.suarez.matriculacionalumnos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnasig = (Button) findViewById(R.id.boton_asignaturas);
        final Button btnalum = (Button) findViewById(R.id.boton_alumnos);

        //BOTÓN PARA IR A LA PANTALLA DE ASIGNATURAS
        btnasig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla_asignaturas = new Intent (MainActivity.this, Asignaturas.class);
                startActivity(pantalla_asignaturas);
            }
        });

        //BOTÓN PARA IR A LA PANTALLA DE ALUMNOS
        btnalum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla_alumnos = new Intent (MainActivity.this, Alumnos.class);
                startActivity(pantalla_alumnos);
            }
        });
    }
}