package pablo.suarez.matriculacionalumnos.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import pablo.suarez.matriculacionalumnos.Adaptadores.AdaptadorAlumno;
import pablo.suarez.matriculacionalumnos.Adaptadores.AdaptadorAsignatura;
import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.Fragments.AsignarAsignaturaFragment;
import pablo.suarez.matriculacionalumnos.Fragments.IntroducirAlumnoFragment;
import pablo.suarez.matriculacionalumnos.Fragments.IntroducirAsignaturaFragment;
import pablo.suarez.matriculacionalumnos.R;
import pablo.suarez.matriculacionalumnos.Repositorios.Repositorio;
import pablo.suarez.matriculacionalumnos.ViewModels.ViewModel;

public class ActivityAlumno extends AppCompatActivity implements IntroducirAlumnoFragment.OnSimpleDialogListener {

    //VARIABLE PARA EL VIEWMODEL
    private ViewModel viewModel;

    //CREAMOS UNA VARIABLE PARA PASARLE LA LISTA DE ALUMNOS ACTUAL PARA LA SECCIÓN DE BORRAR TODOS
    private LiveData<List<Alumno>> lista_alumnos;

    //CREAMOS UNA VARIABLE A LA QUE LE ASIGNAREMOS EL ALUMNO A ACTUALIZAR
    private Alumno alumno_a_actualizar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alumnos);

        //CON ESTO Y EL MÉTODO DEL FINAL PODEMOS ASIGNAR A LA BARRA DE LA APP EN LABEL DEL ACTIVITY EN EL QUE ESTEMOS
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //AQUÍ CREAMOS EL RECYCLERVIEW QUE OBTENDRÁ LA LISTA DE ÍTEMS A TRAVÉS DEL ADAPTADOR
        RecyclerView recyclerView_alumno = findViewById(R.id.RecyclerView_listar_Alumnos);
        recyclerView_alumno.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_alumno.setHasFixedSize(true);

        //CREAMOS UN ADAPTADOR PARA ASIGNAR AL VIEWHOLDER
        final AdaptadorAlumno adaptadorAlumno = new AdaptadorAlumno();
        recyclerView_alumno.setAdapter(adaptadorAlumno);

        //EL VIEWMODEL NECESITA UN PROVIDER PARA DESACOPLAR LA CAPA DE APLICACIÓN DE LA CAPA DE DATOS
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getLista_alumnos().observe(this, new Observer<List<Alumno>>() {
            @Override
            public void onChanged(@Nullable List<Alumno> lista_alumnos) {
                adaptadorAlumno.setAlumnos(lista_alumnos);
            }
        });

        //LE ASIGNAMOS AL ADAPTADOR EL LISTENER QUE DEBE HACER CON CADA BOTON
        adaptadorAlumno.setItemListener(new AdaptadorAlumno.ItemListener() {
            @Override
            public void onClick(Alumno alumno) {

            }

            @Override
            public void alPulsarBotonBorrar(Alumno alumno) {
                viewModel.borrarAlumno(alumno);
            }

            @Override
            public void alPulsarBotonEditar(Alumno alumno) {

                //LE PASO LOS VALORES DEL ALUMNO ACTUAL A LA VARIABLE DEFINIDA ARRIBA PARA POSTERIORMENTE ACTUALIZARLA
                alumno_a_actualizar=alumno;

                //ABRIMOS EL DIALOG FRAGMENT Y LE PASAMOS LOS VALORES QUE TIENE LA ACTIVIDAD ACTUAL
                DialogFragment fragmento = new IntroducirAlumnoFragment();

                //CON EL BUNDLE SE LOS PASAMOS
                Bundle args = new Bundle();
                args.putString("dni_alu", alumno.getDni_alumno());
                args.putString("nom_alu", alumno.getNombre_alumno());
                args.putString("ape_alu", alumno.getApellidos_alumno());
                fragmento.setArguments(args);
                fragmento.show(getSupportFragmentManager(), "Fragment editar Alumno");
            }

            @Override
            public void alPulsarBotonAsignarAsignaturas(Alumno alumno) {

                //INCIAMOS LA ACTIVIDAD PARA ASIGNAR ASIGNATURAS
                Intent intent = new Intent(ActivityAlumno.this, ActivityAsignaturasDelAlumno.class);
                intent.putExtra("alumno", alumno);
                startActivity(intent);
            }
        });

        //ACCIÓN DEL BOTÓN CREAR ALUMNO
        findViewById(R.id.boton_crear_alumno)
                .setOnClickListener(view -> CrearAlumno());
    }

    //CREAMOS EL MENÚ SUPERIOR
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_superior, menu);
        return true;
    }

    //ACCIÓN AL PULSAR EN EL ICONO DE BORRAR TODOS LOS ALUMNOS
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.eliminar_todas:
                EliminarTodas();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //FUNCIÓN PARA BORRAR TODOS LOS ALUMNOS
    private void EliminarTodas() {
        lista_alumnos = viewModel.getLista_alumnos();
        viewModel.borrarAlumnos(lista_alumnos);
        if (lista_alumnos.getValue().size() == 0) {
            Toast.makeText(this, "¡No hay alumnos que borrar!", Toast.LENGTH_SHORT).show();
        }
        return;
    }

    //MÉTODO PARA CREAR UN ALUMNO NUEVO
    private void CrearAlumno() {

        //Abrimos fragment dialog con el formulario de alta de Alumno
        DialogFragment fragmento = new IntroducirAlumnoFragment();
        fragmento.show(getSupportFragmentManager(), "Fragment añadir Alumno");
    }

    //MÉTODO QUE RECIBO DEL FRAGMENT
    @Override
    public void onPossitiveButtonClick(String recepcion_dni, String recepcion_nombre_alumno, String recepcion_apellidos) {

        //VALORES QUE RECIBO DEL FRAGMENT
        String dni = recepcion_dni;
        String nom = recepcion_nombre_alumno;
        String ape = recepcion_apellidos;

        //IGNORAR ACCIÓN SI HAY 0 CARACTERES
        if (dni.isEmpty()) {
            return;
        }
        if (nom.isEmpty()) {
            return;
        }
        if (ape.isEmpty()) {
            return;
        }

        //CREO EL ALUMNO CON LOS VALORES RECIBIDO DEL FRAGMENT
        Alumno alumno = new Alumno();
        alumno.setDni_alumno(dni);
        alumno.setNombre_alumno(nom);
        alumno.setApellidos_alumno(ape);
        viewModel.insertarAlumno(alumno);
    }

    //MÉTODO QUE NOS DEVUELVE EL FRAGMENT A LA HORA DE ACTUALIZAR UN ALUMNO
    @Override
    public void onPossitiveButtonClickActualizar(String aux, String aux1, String aux2) {

        //VALORES QUE RECIBO DEL FRAGMENT
        String dni = aux;
        String nom = aux1;
        String ape = aux2;

        //IGNORAR ACCIÓN SI HAY 0 CARACTERES
        if (dni.isEmpty()) {
            return;
        }
        if (nom.isEmpty()) {
            return;
        }
        if (ape.isEmpty()) {
            return;
        }

        //CREO EL ALUMNO CON LOS VALORES RECIBIDO DEL FRAGMENT
        alumno_a_actualizar.setDni_alumno(dni);
        alumno_a_actualizar.setNombre_alumno(nom);
        alumno_a_actualizar.setApellidos_alumno(ape);
        viewModel.actualizarAlumno(alumno_a_actualizar);
    }

    //CON ESTE MÉTODO IMPLEMENTAMOS EL CÓDIGO DE ARRIBA DE LA BARRA DE LA APP
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}