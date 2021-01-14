package pablo.suarez.dialogmessages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentAlerta.OnSimpleDialogListener {

    Button mostrar_fragment;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrar_fragment = (Button)findViewById(R.id.mostrar_fragment);
        resultado = (TextView)findViewById(R.id.resultado);

        mostrar_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragmento = new FragmentAlerta();
                fragmento.show(getSupportFragmentManager(), "PRUEBA");;
            }
        });
    }

    @Override
    public void onPossitiveButtonClick() {
        resultado.setText("Has pulsado aceptar");
    }

    @Override
    public void onNegativeButtonClick() {
        resultado.setText("Has pulsado cancelar");

    }
}