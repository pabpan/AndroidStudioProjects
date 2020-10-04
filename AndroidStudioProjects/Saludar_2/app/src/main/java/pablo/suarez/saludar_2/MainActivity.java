package pablo.suarez.saludar_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Nombre = (EditText) findViewById(R.id.Nombre);
        final Button Saludar = (Button) findViewById(R.id.Boton);
        final TextView Resultado = (TextView) findViewById(R.id.Resultado);

        Saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla_2 = new Intent(MainActivity.this, Pantalla_2.class);
                Bundle bunde_texto = new Bundle();
                String mensaje_de_paso = "Bienvenido " + Nombre.getText();
                bunde_texto.putString("Bundle_mensaje_de_paso", mensaje_de_paso);
                pantalla_2.putExtras(bunde_texto);
                startActivity(pantalla_2);
            }
        });
    }
}