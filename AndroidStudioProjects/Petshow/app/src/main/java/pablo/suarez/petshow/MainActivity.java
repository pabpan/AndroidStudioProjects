package pablo.suarez.petshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static int OPINION_REQUEST_CODE = 1;
    public final static String EXTRA_NOMBRE = "pablo.suarez.petshow.MASCOTA";
    private Button mostrar_mascota;
    private TextView autores;
    private TextView texto_opinion;

    //Código de envío
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos instancia del boton mostrar_mascota
        mostrar_mascota = (Button) findViewById(R.id.mostrar_boton_mascota);
        mostrar_mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_nuevo = new Intent(MainActivity.this, Visor.class);
                intent_nuevo.putExtra(EXTRA_NOMBRE, "Soy un Teckel Arlequín");
                //Inicio de la actividad esperando un resultado
                startActivityForResult(intent_nuevo, OPINION_REQUEST_CODE);
            }
        });

        autores = (TextView) findViewById(R.id.autores);
        autores.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Uri webpage = Uri.parse("http://hermosaprogramacion.blogspot.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                // Verificar si hay aplicaciones disponibles
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(webIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Si hay, entonces ejecutamos la actividad
                if (isIntentSafe) {
                    startActivity(webIntent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        texto_opinion = (TextView)findViewById(R.id.opinion);

        if (requestCode == OPINION_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("opinion");
                texto_opinion.setText("Tu opinion fué " + result);
            }
        }
    }
}