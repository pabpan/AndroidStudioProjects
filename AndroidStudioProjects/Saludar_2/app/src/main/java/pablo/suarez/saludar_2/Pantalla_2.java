package pablo.suarez.saludar_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Pantalla_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_2);

        final TextView segundo_saludo = (TextView) findViewById(R.id.Resultado);

        Bundle bundle_recoger_saludo = getIntent().getExtras();
        segundo_saludo.setText(bundle_recoger_saludo.getString("Bundle_mensaje_de_paso"));
    }
}