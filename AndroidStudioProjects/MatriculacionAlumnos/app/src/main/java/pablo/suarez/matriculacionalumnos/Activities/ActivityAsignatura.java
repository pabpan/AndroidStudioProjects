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

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import pablo.suarez.matriculacionalumnos.Adaptadores.AdaptadorAsignatura;
import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.Entidades.AsignaturasAlumno;
import pablo.suarez.matriculacionalumnos.Fragments.IntroducirAsignaturaFragment;
import pablo.suarez.matriculacionalumnos.R;
import pablo.suarez.matriculacionalumnos.ViewModels.ViewModel;

public class ActivityAsignatura extends AppCompatActivity implements IntroducirAsignaturaFragment.OnSimpleDialogListener {

    //VARIABLE PARA EL VIEWMODEL
    private ViewModel viewModel;

    //CREAMOS UNA VARIABLE PARA PASARLE LA LISTA DE ASIGNATURAS ACTUAL PARA LA SECCIÓN DE BORRAR TODAS
    private LiveData<List<Asignatura>> lista_asignaturas;

    //CREAMOS UNA VARIABLE A LA QUE LE ASIGNAREMOS LA ASIGNATURA A ACTUALIZAR
    private Asignatura asignatura_a_actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_asignaturas);

        //CON ESTO Y EL MÉTODO DEL FINAL PODEMOS ASIGNAR A LA BARRA DE LA APP EN LABEL DEL ACTIVITY EN EL QUE ESTEMOS
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //AQUÍ CREAMOS EL RECYCLERVIEW QUE OBTENDRÁ LA LISTA DE ÍTEMS A TRAVÉS DEL ADAPTADOR
        RecyclerView recyclerView_asignatura = findViewById(R.id.RecyclerView_listar_Asignaturas);
        recyclerView_asignatura.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_asignatura.setHasFixedSize(true);

        //CREAMOS UN ADAPTADOR PARA ASIGNAR AL VIEWHOLDER
        final AdaptadorAsignatura adaptadorAsignatura = new AdaptadorAsignatura();
        recyclerView_asignatura.setAdapter(adaptadorAsignatura);

        //EL VIEWMODEL NECESITA UN PROVIDER PARA DESACOPLAR LA CAPA DE APLICACIÓN DE LA CAPA DE DATOS
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getLista_asignaturas().observe(this, new Observer<List<Asignatura>>() {
            @Override
            public void onChanged(@Nullable List<Asignatura> lista_asignaturas) {
                adaptadorAsignatura.setAsignaturas(lista_asignaturas);
            }
        });

        //LE ASIGNAMOS AL ADAPTADOR EL LISTENER QUE DEBE HACER CON CADA BOTON
        adaptadorAsignatura.setItemListener(new AdaptadorAsignatura.ItemListener() {

            //ACCIONES A LPULSAR SOBRE EL ITEM ASIGNATURA
            @Override
            public void onClick(Asignatura asigntura) {
            }

            //ACCIONES AL PULSAR EL ITEMVIEW DE BORRAR UNA ASIGNATURA
            @Override
            public void alPulsarBotonBorrar(Asignatura asignatura) {
                viewModel.borrarAsignatura(asignatura);
            }

            //ACCIONES AL PULSAR EL ITEMVIEW DE EDITAR
            @Override
            public void alPulsarBotonEditar(Asignatura asignatura) {

                //LE PASO LOS VALORES DE LA ASIGNATURA ACTUAL A LA VARIABLE DEFINIDA ARRIBA PARA POSTERIORMENTE ACTUALIZARLA
                asignatura_a_actualizar=asignatura;

                //ABRIMOS EL DIALOG FRAGMENT Y LE PASAMOS LOS VALORES QUE TIENE LA ACTIVIDAD ACTUAL
                DialogFragment fragmento = new IntroducirAsignaturaFragment();

                //CON EL BUNDLE SE LOS PASAMOS
                Bundle args = new Bundle();
                args.putString("cod_asig", asignatura.getCodigo_asignatura());
                args.putString("nom_asig", asignatura.getNombre_asignatura());
                fragmento.setArguments(args);
                fragmento.show(getSupportFragmentManager(), "Fragment editar Asignatura");
            }
        });

        //ACCIÓN DEL BOTÓN CREAR ASIGNATURA
        findViewById(R.id.boton_crear_asignatura)
                .setOnClickListener(view -> CrearAsignatura());

    }

    //CREAMOS EL MENÚ SUPERIOR
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_superior, menu);
        return true;
    }

    //ACCIÓN AL PULSAR EN EL ICONO DE BORRAR TODAS LAS ASIGNATURAS
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

    //MÉTODO PARA BORRAR TODAS LAS ASIGNATURAS
    private void EliminarTodas() {
        lista_asignaturas = viewModel.getLista_asignaturas();
        viewModel.borrarAsignaturas(lista_asignaturas);
        if (lista_asignaturas.getValue().size() == 0) {
            Toast.makeText(this, "¡No hay asignaturas que borrar!", Toast.LENGTH_SHORT).show();
        }
        return;
    }

    //MÉTODO PARA CREAR UNA ASIGNATURA NUEVA
    private void CrearAsignatura() {

        //Abrimos fragment dialog con el formulario de alta de Asignatura
        DialogFragment fragmento = new IntroducirAsignaturaFragment();
        fragmento.show(getSupportFragmentManager(), "Fragment añadir Asignatura");
    }

    //MÉTODO QUE RECIBO DEL FRAGMENT
    @Override
    public void onPossitiveButtonClick(String recepcion_codigo, String nombre_asignatura) {

        //VALORES QUE RECIBO DEL FRAGMENT
        String cod = recepcion_codigo;
        String nom = nombre_asignatura;

        //IGNORAR ACCIÓN SI HAY 0 CARACTERES
        if (cod.isEmpty()) {
            return;
        }
        if (nom.isEmpty()) {
            return;
        }

        //CREO LA ASIGNATURA CON LOS VALORES RECIBIDO DEL FRAGMENT
        asignatura_a_actualizar.setCodigo_asignatura(cod);
        asignatura_a_actualizar.setNombre_asignatura(nom);
        viewModel.actualizarAsignatura(asignatura_a_actualizar);

        //CREO LA ASIGNATURA CON LOS VALORES RECIBIDO DEL FRAGMENT
        Asignatura asignatura = new Asignatura();
        asignatura.setCodigo_asignatura(cod);
        asignatura.setNombre_asignatura(nom);
        viewModel.insertarAsignatura(asignatura);
    }

    //MÉTODO QUE NOS DEVUELVE EL FRAGMENT A LA HORA DE ACTUALIZAR UNA ASIGNATURA
    @Override
    public void onPossitiveButtonClickActualizar(String aux, String aux1) {

        //VALORES QUE RECIBO DEL FRAGMENT
        String cod = aux;
        String nom = aux1;

        //IGNORAR ACCIÓN SI HAY 0 CARACTERES
        if (cod.isEmpty()) {
            return;
        }
        if (nom.isEmpty()) {
            return;
        }
    }

    //CON ESTE MÉTODO IMPLEMENTAMOS EL CÓDIGO DE ARRIBA DE LA BARRA DE LA APP
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}