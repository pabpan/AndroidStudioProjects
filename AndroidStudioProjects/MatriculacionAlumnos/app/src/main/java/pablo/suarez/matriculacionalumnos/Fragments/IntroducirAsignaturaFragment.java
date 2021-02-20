package pablo.suarez.matriculacionalumnos.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import pablo.suarez.matriculacionalumnos.R;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class IntroducirAsignaturaFragment extends DialogFragment {

    //CREAMOS EL LINSTENER QUE NOS LLEVARÁ DE VUELTA A LA ACTIVITY
    OnSimpleDialogListener listener;

    //INSTANCIAMOS LOS CAMPOS DE TEXTO
    private EditText codigo_asignatura;
    private EditText nombre_asignatura;

    //CREAMOS DOS STRINGS EN LOS QUE VAMOS A METER LOS ARGUMENTOS QUE RECIBIMOS DEL BUNDLE DE LA ACTIVITY
    private String cod_asig;
    private String nom_asig;

    //CREAMOS UN CONSTRUCTOR VACÍO
    public IntroducirAsignaturaFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //CREAMOS UN DIALOG FRAGMENT Y LE PASAMOS LA ACTIVITY QUE RECOGE
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //INFLAMOS L LAYOUT DE LA ACTIVITY
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //CREAMOS UNA VISTA Y LE ASIGNAMOS EL LAYOUT DEL FRAGMENT
        View view = inflater.inflate(R.layout.fragment_introducir_asignatura, null);

        //SETEAMOS LOS CAMPOS DE TEXTO
        codigo_asignatura = view.findViewById(R.id.editext_fragment_asignatura_codigo);
        nombre_asignatura = view.findViewById(R.id.editext_fragment_nombre_asignatura);

        //ESTA CONDICIÓN LA CUMPLE EL MÉTODO DE ACTUALIZAR, YA QUE ENVÍA AL FRAGMENT VARIOS ARGUMENTOS A TRAVÉS DE UN BUNDLE
        if (getArguments() != null) {
            cod_asig = getArguments().getString("cod_asig");
            nom_asig = getArguments().getString("nom_asig");

            codigo_asignatura.setText(cod_asig);
            nombre_asignatura.setText(nom_asig);

            //CREAMOS LAS VISTA
            builder.setView(view)

                    //AÑADIMOS ACCIÓN AL BOTÓN DE GUARDAR
                    .setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            //RECOGEMOS EL TEXTO INTRODUCIDO
                            String aux = codigo_asignatura.getText().toString();
                            String aux1 = nombre_asignatura.getText().toString();
                            //LE PASAMOS A LA ACTIVITY PRINCIPAL EL TEXTO RECOGIDO DE LOS CAMPOS A TRAVÉS DEL MÉTODO CREADO DEBAJO
                            listener.onPossitiveButtonClickActualizar(aux, aux1);
                        }
                    })
                    //AL CLICKAR CANCELAR VUELVE AL FRAGMENT
                    .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            IntroducirAsignaturaFragment.this.getDialog().cancel();
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
                        String aux = codigo_asignatura.getText().toString();
                        String aux1 = nombre_asignatura.getText().toString();

                        //LE PASAMOS A LA ACTIVITY PRINCIPAL EL TEXTO RECOGIDO DE LOS CAMPOS A TRAVÉS DEL MÉTODO CREADO DEBAJO
                        listener.onPossitiveButtonClick(aux, aux1);
                    }
                })
                //AL CLICKAR CANCELAR VUELVE AL FRAGMENT
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        IntroducirAsignaturaFragment.this.getDialog().cancel();
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
        void onPossitiveButtonClick(String codigo, String nombre);
        void onPossitiveButtonClickActualizar(String aux, String aux1);
    }
}
