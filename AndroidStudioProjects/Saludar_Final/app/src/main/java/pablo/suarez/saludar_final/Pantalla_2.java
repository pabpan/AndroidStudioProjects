package pablo.suarez.saludar_final;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla_2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_2);

        final TextView recoger_saludo_pantalla_1 = (TextView) findViewById(R.id.recoger_de_pantalla_1);
        final Button boton_pantalla_2 = (Button) findViewById(R.id.volver_a_mainactivity);


        Bundle bundle_recoger_pantalla_1 = getIntent().getExtras();
        recoger_saludo_pantalla_1.setText(bundle_recoger_pantalla_1.getString("Saludo_pantalla_1"));

        final String completando_saludo = bundle_recoger_pantalla_1.getString(
                "Saludo_pantalla_1");

        boton_pantalla_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_ir_pantalla_1 = new Intent();
                Bundle bundle_de_vuelta = new Bundle();
                String mensaje_de_vuelta = "Devuelvo a Principal " + completando_saludo;
                bundle_de_vuelta.putString("DEVUELTO", mensaje_de_vuelta);
                intent_ir_pantalla_1.putExtras(bundle_de_vuelta);
                setResult(RESULT_OK, intent_ir_pantalla_1);
                finish();
            }
        });

    }

//    /* Proceso para entender el ciclo de vida */
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "onStart-Pantalla2", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this, "onResume-Pantalla2", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        Toast.makeText(this, "onPause-Pantalla2", Toast.LENGTH_SHORT).show();
//        super.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this, "onStop-Pantalla2", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(this, "onRestart-Pantalla2", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
//        super.onDestroy();
//    }
}