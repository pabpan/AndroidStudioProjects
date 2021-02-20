package pablo.suarez.matriculacionalumnos.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pablo.suarez.matriculacionalumnos.Adaptadores.AdaptadorAsignatura;
import pablo.suarez.matriculacionalumnos.Adaptadores.AdaptadorAsignaturasAlumno;
import pablo.suarez.matriculacionalumnos.BaseDeDatos.BaseDeDatos;
import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.Entidades.AsignaturasAlumno;
import pablo.suarez.matriculacionalumnos.Fragments.AsignarAsignaturaFragment;
import pablo.suarez.matriculacionalumnos.R;
import pablo.suarez.matriculacionalumnos.Repositorios.Repositorio;
import pablo.suarez.matriculacionalumnos.ViewModels.ViewModel;

public class ActivityAsignaturasDelAlumno extends AppCompatActivity implements AsignarAsignaturaFragment.OnSimpleDialogListener {

    //VARIABLE PARA EL VIEWMODEL
    private ViewModel viewModel, viewModel1;

    //CREAMOS UNA VARIABLE PARA COMPRAR LAS ASIGNATURAS DEL ALUMNO CON LAS QUE HAY REGISTRADAS
    private List<AsignaturasAlumno> lista_asignaturas_alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas_del_alumno);

        //CON ESTO Y EL MÉTODO DEL FINAL PODEMOS ASIGNAR A LA BARRA DE LA APP EN LABEL DEL ACTIVITY EN EL QUE ESTEMOS
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Alumno alumno = (Alumno) getIntent().getSerializableExtra("alumno");

        //AQUÍ CREAMOS EL RECYCLERVIEW QUE OBTENDRÁ LA LISTA DE ÍTEMS A TRAVÉS DEL ADAPTADOR
        RecyclerView recyclerView_asignar_asigntura = findViewById(R.id.RecyclerView_Asignar_Asignatura_Alumno);
        recyclerView_asignar_asigntura.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_asignar_asigntura.setHasFixedSize(true);

        //CREAMOS UN ADAPTADOR PARA ASIGNAR AL VIEWHOLDER
        final AdaptadorAsignaturasAlumno adaptadorAsignaturasAlumno = new AdaptadorAsignaturasAlumno();
        recyclerView_asignar_asigntura.setAdapter(adaptadorAsignaturasAlumno);

        //EL VIEWMODEL NECESITA UN PROVIDER PARA DESACOPLAR LA CAPA DE APLICACIÓN DE LA CAPA DE DATOS
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getLista_AsignaturasAlumno().observe(this, new Observer<List<AsignaturasAlumno>>() {
            @Override
            public void onChanged(List<AsignaturasAlumno> asignaturasAlumnos) {

                //AQUÍ BUSCAMOS SOLO LAS ASIGNATURAS QUE CORRESPONDAN CON EL DNI DEL ALUMNO SELECCIONADO
                lista_asignaturas_alumno = asignaturasAlumnos;
                List<AsignaturasAlumno> aux = new ArrayList<>();

                for (int i = 0; i < lista_asignaturas_alumno.size(); i++) {
                    if (alumno.getDni_alumno().equals(lista_asignaturas_alumno.get(i).getDni_alumno())) {
                        aux.add(lista_asignaturas_alumno.get(i));
                    }
                    adaptadorAsignaturasAlumno.setAsignaturasAlumno(aux);
                }
            }
        });

        adaptadorAsignaturasAlumno.setItemListener(new AdaptadorAsignaturasAlumno.ItemListener() {
            @Override
            public void onClick(AsignaturasAlumno asignaturasAlumno) {
            }

            @Override
            public void alPulsarBotonBorrar(AsignaturasAlumno asignaturasAlumno) {
                viewModel.borrarAsignaturaAlumno(asignaturasAlumno);
            }
        });

        findViewById(R.id.boton_asignar_asignatura)
                .setOnClickListener(view -> AsignarAsignatura());
    }

    private void AsignarAsignatura() {
        //Abrimos fragment dialog con el formulario de alta de Alumno
        DialogFragment fragmento = new AsignarAsignaturaFragment();
        fragmento.show(getSupportFragmentManager(), "Fragment asignar asignatura");
    }

    //CON ESTE MÉTODO IMPLEMENTAMOS EL CÓDIGO DE ARRIBA DE LA BARRA DE LA APP
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onPossitiveButtonClickAsingnar() {

    }
}