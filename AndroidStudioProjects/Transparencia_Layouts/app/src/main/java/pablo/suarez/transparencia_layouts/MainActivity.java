package pablo.suarez.transparencia_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boton_lineal = (Button)findViewById(R.id.boton_act_1);
        final Button boton_tabla = (Button)findViewById(R.id.boton_act_2);
        final Button boton_relativo = (Button)findViewById(R.id.boton_act_3);
        final Button boton_grid = (Button)findViewById(R.id.boton_act_4);

        boton_lineal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana_lineal = new Intent(MainActivity.this, Lineal_Activity.class);
                startActivity(ventana_lineal);
            }
        });
        boton_tabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana_tabla = new Intent(MainActivity.this, Tabla_Activity.class);
                startActivity(ventana_tabla);
            }
        });
        boton_relativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana_relativo = new Intent(MainActivity.this, Relativo_Activity.class);
                startActivity(ventana_relativo);
            }
        });
        boton_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana_grid = new Intent(MainActivity.this, Grid_activiy.class);
                startActivity(ventana_grid);
            }
        });
    }
}