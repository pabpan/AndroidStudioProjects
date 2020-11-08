package pablo.suarez.petshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Visor extends AppCompatActivity {

    private TextView nombre_imagen;
    private RadioGroup grupo_opiniones;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);
        //Obtenemos las instancias de las views
        nombre_imagen = (TextView) findViewById(R.id.nombre_imagen);
        grupo_opiniones = (RadioGroup) findViewById(R.id.opiniones_group);
        enviar = (Button) findViewById(R.id.boton_enviar);

        //Obtenemos la instancia del Intent
        Intent intent = getIntent();
        //Extraemos el extra de tipo cadena
        String name = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);
        //Seteamos el valor del extra al Imageview
        nombre_imagen.setText(name);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtener del radiobutton seleccionado actualmente
                RadioButton seleccionado = (RadioButton) findViewById(grupo_opiniones.getCheckedRadioButtonId());
                //Obtener la cadena del radiobutton
                String opinion = seleccionado.getText().toString();
                //Crear un nuevo intent de respuesta
                Intent datos_respuesta = new Intent();
                //Añadir como Extra el texto del radiobutton
                datos_respuesta.putExtra("opinion", opinion);
                //Devolver por el canal de forma exitosa el mensaje del intent
                setResult(RESULT_OK, datos_respuesta);
                finish();
            }
        });
    }
}