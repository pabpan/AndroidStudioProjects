package pablo.suarez.calculadorafragments1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Button mostrar_fragment_dinamico ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Obteniendo la instancia del botón add_fragment
        mostrar_fragment_dinamico = (Button)findViewById(R.id.mostrar_fragmento_dinamico);

        mostrar_fragment_dinamico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Paso 1: Obtener la instancia del administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager();

                //Paso 2: Crear una nueva transacción
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //Paso 3: Crear un nuevo fragmento y añadirlo
                CalculadoraFragmentDinamico fragmento_dinamico = new CalculadoraFragmentDinamico();
                transaction.add(R.id.contenedor_calculadora, fragmento_dinamico);

                //Paso 4: Confirmar el cambio
                transaction.commit();
            }
        });
    }
}