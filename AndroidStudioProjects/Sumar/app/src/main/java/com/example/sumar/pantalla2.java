package com.example.sumar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

     final TextView suma = (TextView) findViewById(R.id.sumar_numeros);
     final Button volver = (Button)findViewById(R.id.volver);

     Bundle miBundleRecoger = getIntent().getExtras();
     suma.setText(miBundleRecoger.getString("Resultado"));

     volver.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent regresar = new Intent();
             Bundle bundle_volver = new Bundle();
             String devuelto = "Volver a pantalla principal";
             bundle_volver.putString("volver", devuelto);
             regresar.putExtras(regresar);
             finish();
         }
     });
    }
}