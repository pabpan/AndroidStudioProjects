package pablo.suarez.saludar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        final Button boton = (Button) findViewById(R.id.Boton);
        final TextView Resultado = (TextView) findViewById(R.id.Resultado);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = "Bienvenido " + Nombre.getText();
                Resultado.setText(mensaje);
            }
        });
    }

}