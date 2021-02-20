package pablo.suarez.matriculacionalumnos.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import pablo.suarez.matriculacionalumnos.Adaptadores.AdaptadorAsignatura;
import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.Entidades.AsignaturasAlumno;
import pablo.suarez.matriculacionalumnos.R;
import pablo.suarez.matriculacionalumnos.ViewModels.ViewModel;

public class AsignarAsignaturaFragment extends DialogFragment {

    //CREAMOS EL LINSTENER QUE NOS LLEVARÁ DE VUELTA A LA ACTIVITY
    OnSimpleDialogListener listener;

    String itemseleccionado = null;

    String[] nombres_asignaturas;

    //VARIABLE PARA EL VIEWMODEL
    private ViewModel viewModel, viewModel1;

    //CREAMOS UNA VARIABLE PARA COMPRAR LAS ASIGNATURAS DEL ALUMNO CON LAS QUE HAY REGISTRADAS
    private List<Asignatura> lista_asignaturas;

    public AsignarAsignaturaFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //CREAMOS UN ADAPTADOR PARA ASIGNAR AL VIEWHOLDER
//        final AdaptadorAsignatura adaptadorAsignatura = new AdaptadorAsignatura();
//
//        //EL VIEWMODEL NECESITA UN PROVIDER PARA DESACOPLAR LA CAPA DE APLICACIÓN DE LA CAPA DE DATOS
//        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
//        viewModel.getLista_asignaturas().observe(this, new Observer<List<Asignatura>>() {
//            @Override
//            public void onChanged(@Nullable List<Asignatura> lista_asignaturas) {
//                adaptadorAsignatura.setAsignaturas(lista_asignaturas);
//            }
//        });


        //NECESITAMOS UN ARRAY CON LAS ASIGNATURAS
//        String[] lista_asignaturas = {"fsadfd", "fdsadsfa", "fdesadsagfa"};

        nombres_asignaturas = new String[lista_asignaturas.size()];

        for (int i = 0; i< lista_asignaturas.size(); i++) {
            nombres_asignaturas[i] = lista_asignaturas.get(i).getNombre_asignatura();
        }

        //CREAMOS UN DIALOG FRAGMENT Y LE PASAMOS LA ACTIVITY QUE RECOGE
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //AÑADIMOS EL TÍTULO
        builder.setTitle("Asigna Asignatura a");

        builder.setSingleChoiceItems(nombres_asignaturas,0, (DialogInterface.OnClickListener) this);

        //ACCIONES AL SELECCIONAR CADA RADIOBUTTON
//        builder.setSingleChoiceItems(lista_asignaturas, 0, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                itemseleccionado = lista_asignaturas[which];
//
//                Toast.makeText(getContext(), "Has pulsado " + itemseleccionado, Toast.LENGTH_SHORT).show();
//            }
//        });

        //AÑADIMOS ACCIÓN AL BOTÓN DE GUARDAR
        builder.setPositiveButton("AÑADIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

                //LE PASAMOS A LA ACTIVITY PRINCIPAL EL TEXTO RECOGIDO DE LOS CAMPOS A TRAVÉS DEL MÉTODO CREADO DEBAJO
                listener.onPossitiveButtonClickAsingnar();
            }
        })
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AsignarAsignaturaFragment.this.getDialog().cancel();
                    }
                });
        builder.show();
        return builder.create();
    }

    //CREAMOS EL MÉTODO QUE NOS DEVUELVE A LA PANTALLA PRINCIPAL CON EL VALOR DE LOS CAMPOS INTRODUCIDOS
    public interface OnSimpleDialogListener {
        void onPossitiveButtonClickAsingnar();
    }
}