package pablo.suarez.saludar_final;

import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nombre_en_app_1 = (EditText) findViewById(R.id.Nombre);
        final Button boton_en_app_1 = (Button) findViewById(R.id.boton_pantalla_1);

        //PARA BORRAR EL TEXTO DEL EDITEXT CUANDO HAGA FOCO...
        nombre_en_app_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == true) {
                    nombre_en_app_1.setText("");
                }
            }
        });

        boton_en_app_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_ir_pantalla_2 = new Intent(MainActivity.this, Pantalla_2.class);
                Bundle bundle = new Bundle();
                String mensaje_de_ida = "Bienvenido " + nombre_en_app_1.getText();
                bundle.putString("Saludo_pantalla_1", mensaje_de_ida);
                intent_ir_pantalla_2.putExtras(bundle);
                startActivityForResult(intent_ir_pantalla_2, COD_RESPUESTA);
            }

        });

    }

    //IMPORTANTE!! HAY QUE RECOGER EL RESULTADO

    public void onActivityResult(int cod_resp, int cod_result, Intent intent) {
        super.onActivityResult(cod_resp, cod_result, intent);
        if (cod_result == RESULT_OK) {
            Bundle bundle_1 = intent.getExtras();
            TextView saludo_de_vuelta = (TextView)findViewById(R.id.recoger_de_pantalla_2);
            saludo_de_vuelta.setText(bundle_1.getString("DEVUELTO"));
        }
    }

//    /* Proceso para entender el ciclo de vida */
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "onStart-ClasePrincipal", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this, "onResume-ClasePrincipal", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        Toast.makeText(this, "onPause-ClasePrincipal", Toast.LENGTH_SHORT).show();
//        super.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this, "onStop-ClasePrincipal", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(this, "onRestart-ClasePrincipal", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        Toast.makeText(this, "onDestroy-ClasePrincipaly", Toast.LENGTH_SHORT).show();
//        super.onDestroy();
//    }
}