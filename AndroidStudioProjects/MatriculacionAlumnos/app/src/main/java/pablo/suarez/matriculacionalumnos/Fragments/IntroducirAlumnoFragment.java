package pablo.suarez.matriculacionalumnos.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import pablo.suarez.matriculacionalumnos.R;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class IntroducirAlumnoFragment extends DialogFragment {

    //CREAMOS EL LINSTENER QUE NOS LLEVARÁ DE VUELTA A LA ACTIVITY
    OnSimpleDialogListener listener;

    //INSTANCIAMOS LOS CAMPOS DE TEXTO
    private EditText dni_alumno;
    private EditText nombre_alumno;
    private EditText apellidos_alumno;

    //CREAMOS TRES STRINGS EN LOS QUE VAMOS A METER LOS ARGUMENTOS QUE RECIBIMOS DEL BUNDLE DE LA ACTIVITY
    private String dni_alu;
    private String nom_alu;
    private String ape_alu;

    //CREAMOS UN CONSTRUCTOR VACÍO
    public IntroducirAlumnoFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //CREAMOS UN DIALOG FRAGMENT Y LE PASAMOS LA ACTIVITY QUE RECOGE
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //INFLAMOS L LAYOUT DE LA ACTIVITY
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //CREAMOS UNA VISTA Y LE ASIGNAMOS EL LAYOUT DEL FRAGMENT
        View view = inflater.inflate(R.layout.fragment_introducir_alumno, null);

        //SETEAMOS LOS CAMPOS DE TEXTO
        dni_alumno = view.findViewById(R.id.editext_fragment_alumno_dni);
        nombre_alumno = view.findViewById(R.id.editext_fragment_alumno_nombre);
        apellidos_alumno = view.findViewById(R.id.editext_fragment_alumno_apellidos);

        //ESTA CONDICIÓN LA CUMPLE EL MÉTODO DE ACTUALIZAR, YA QUE ENVÍA AL FRAGMENT VARIOS ARGUMENTOS A TRAVÉS DE UN BUNDLE
        if (getArguments() != null) {
            dni_alu = getArguments().getString("dni_alu");
            nom_alu = getArguments().getString("nom_alu");
            ape_alu = getArguments().getString("ape_alu");

            dni_alumno.setText(dni_alu);
            nombre_alumno.setText(nom_alu);
            apellidos_alumno.setText(ape_alu);

            //CREAMOS LAS VISTA
            builder.setView(view)

                    //AÑADIMOS ACCIÓN AL BOTÓN DE GUARDAR
                    .setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            //RECOGEMOS EL TEXTO INTRODUCIDO
                            String aux = dni_alumno.getText().toString();
                            String aux1 = nombre_alumno.getText().toString();
                            String aux2 = apellidos_alumno.getText().toString();

                            //LE PASAMOS A LA ACTIVITY PRINCIPAL EL TEXTO RECOGIDO DE LOS CAMPOS A TRAVÉS DEL MÉTODO CREADO DEBAJO
                            listener.onPossitiveButtonClickActualizar(aux, aux1, aux2);
                        }
                    })
                    //AL CLICKAR CANCELAR VUELVE AL FRAGMENT
                    .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            IntroducirAlumnoFragment.this.getDialog().cancel();
                        }
                    });
            return builder.create();
        }

        //CREAMOS LAS VISTA
        builder.setView(view)

                //AÑADIMOS ACCIÓN AL BOTÓN DE GUARDAR
                .setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        //RECOGEMOS EL TEXTO INTRODUCIDO
                        String aux = dni_alumno.getText().toString();
                        String aux1 = nombre_alumno.getText().toString();
                        String aux2 = apellidos_alumno.getText().toString();

                        //LE PASAMOS A LA ACTIVITY PRINCIPAL EL TEXTO RECOGIDO DE LOS CAMPOS A TRAVÉS DEL MÉTODO CREADO DEBAJO
                        listener.onPossitiveButtonClick(aux, aux1, aux2);
                    }
                })
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        IntroducirAlumnoFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    //USAMOS ESTE MÉTODO PARA COMPROBAR SI LA ACTIVITY HA IMPLEMENTADO EL CALLABACK DEL LISTENER POR EL FRAGMENTO
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnSimpleDialogListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() +
                            " no implementó OnSimpleDialogListener");

        }
    }

    //CREAMOS EL MÉTODO QUE NOS DEVUELVE A LA PANTALLA PRINCIPAL CON EL VALOR DE LOS CAMPOS INTRODUCIDOS
    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick(String dni, String nombre, String apellidos);
        void onPossitiveButtonClickActualizar(String aux, String aux1, String aux2);
    }
}
