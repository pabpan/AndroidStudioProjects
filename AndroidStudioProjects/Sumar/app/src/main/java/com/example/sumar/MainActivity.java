package com.example.sumar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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

        final EditText campo1 = (EditText)findViewById(R.id.numero1);
        final EditText campo2 = (EditText)findViewById(R.id.numero2);
        final Button boton = (Button)findViewById(R.id.boton_resultado);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana2 = new Intent (MainActivity.this, pantalla2.class);
                Bundle miBundle = new Bundle();
                int a = Integer.parseInt(String.valueOf(campo1.getText()));
                int b = Integer.parseInt(String.valueOf(campo2.getText()));
                int suma = a + b;
                String res = Integer.toString(suma);
                miBundle.putString("Resultado", res);
                ventana2.putExtras(miBundle);
                startActivity(ventana2);
            }
        });
    }
}