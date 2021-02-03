package pablo.suarez.matriculacionalumnos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pablo.suarez.matriculacionalumnos.R;

public class AsignaturasDelAlumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas_del_alumno);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}