package pablo.suarez.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int contador = 0, opcion;
    float num1, num2, resultado;
    Operaciones resultados = new Operaciones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton_cero = (Button) findViewById(R.id.cero);
        Button boton_uno = (Button) findViewById(R.id.uno);
        Button boton_dos = (Button) findViewById(R.id.dos);
        Button boton_tres = (Button) findViewById(R.id.tres);
        Button boton_cuatro = (Button) findViewById(R.id.cuatro);
        Button boton_cinco = (Button) findViewById(R.id.cinco);
        Button boton_seis = (Button) findViewById(R.id.seis);
        Button boton_siete = (Button) findViewById(R.id.siete);
        Button boton_ocho = (Button) findViewById(R.id.ocho);
        Button boton_nueve = (Button) findViewById(R.id.nueve);
        Button boton_sumar = (Button) findViewById(R.id.sumar);
        Button boton_restar = (Button) findViewById(R.id.restar);
        Button boton_multiplicar = (Button) findViewById(R.id.multiplicar);
        Button boton_dividir = (Button) findViewById(R.id.dividir);
        // Button boton_borrar = (Button) findViewById(R.id.borrar);
        Button boton_coma = (Button) findViewById(R.id.coma);
        Button boton_igual = (Button) findViewById(R.id.igual);

        TextView Resultado = (TextView) findViewById(R.id.resultado);

        boton_cero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "0");
            }
        });

        boton_uno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "1");
            }
        });

        boton_dos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "2");

            }
        });

        boton_tres.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "3");
            }
        });

        boton_cuatro.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "4");

            }
        });

        boton_cinco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "5");

            }
        });

        boton_seis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "6");
            }
        });

        boton_siete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "7");

            }
        });

        boton_ocho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "8");

            }
        });

        boton_nueve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("");
                    contador--;
                }
                String pantalla = Resultado.getText().toString();
                Resultado.setText(pantalla + "9");

            }
        });

        boton_igual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num2 = Float.valueOf(Resultado.getText().toString());

                switch (opcion) {
                    case 1:
                        resultado = resultados.suma(num1, num2);
                        Resultado.setText(Float.toString(resultado));
                        contador++;
                        break;
                    case 2:
                        resultado = resultados.resta(num1, num2);
                        Resultado.setText(Float.toString(resultado));
                        contador++;
                        break;
                    case 3:
                        resultado = resultados.multiplicacion(num1, num2);
                        Resultado.setText(Float.toString(resultado));
                        contador++;
                        break;
                    case 4:
                        resultado = resultados.division(num1, num2);
                        Resultado.setText(Float.toString(resultado));
                        contador++;
                        break;
                }

            }
        });

        boton_sumar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcion = 1;
                num1 = Float.valueOf(Resultado.getText().toString());
                Resultado.setText("");
            }
        });

        boton_restar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcion = 2;
                num1 = Float.valueOf(Resultado.getText().toString());
                Resultado.setText("");
            }
        });

        boton_multiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcion = 3;
                num1 = Float.valueOf(Resultado.getText().toString());
                Resultado.setText("");
            }
        });

        boton_dividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcion = 4;
                num1 = Float.valueOf(Resultado.getText().toString());
                Resultado.setText("");
            }
        });

        boton_coma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contador != 0) {
                    Resultado.setText("Operacion no permitida. Reiniciando...");
                    Resultado.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Resultado.setText("");
                        }
                    }, 2000);
                }
                if (Resultado.getText().toString().contains(".")) {
                    Resultado.setText("Operacion no permitida. Reiniciando...");
                    Resultado.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Resultado.setText("");
                        }
                    }, 2000);
                }
                if (contador == 0) {
                    String pantalla = Resultado.getText().toString();
                    Resultado.setText(pantalla + ".");
                }
            }
        });
    }

    public class Operaciones {

        public float suma(float num1, float num2) {
            return num1 + num2;
        }

        public float resta(float num1, float num2) {
            return num1 - num2;
        }

        public float division(float num1, float num2) {
            return num1 / num2;
        }

        public float multiplicacion(float num1, float num2) {
            return num1 * num2;
        }
    }
}