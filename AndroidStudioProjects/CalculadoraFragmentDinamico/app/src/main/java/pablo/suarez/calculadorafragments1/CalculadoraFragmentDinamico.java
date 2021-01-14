package pablo.suarez.calculadorafragments1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CalculadoraFragmentDinamico extends Fragment {

    int contador = 0, opcion;
    float num1, num2, resultado;
    Operaciones resultados = new Operaciones();

    public CalculadoraFragmentDinamico() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculadora_dinamico, container, false);

        //Nuevos parametros para el view del fragmento
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        //Nueva Regla: EL fragmento estara debajo del boton add_fragment
        params.addRule(RelativeLayout.BELOW, R.id.mostrar_fragmento_dinamico);

        //Margenes: top:41dp
        params.setMargins(0,41,0,0);

        //Setear los parametros al view
        view.setLayoutParams(params);

        Button boton_cero = (Button) view.findViewById(R.id.cero);
        Button boton_uno = (Button) view.findViewById(R.id.uno);
        Button boton_dos = (Button) view.findViewById(R.id.dos);
        Button boton_tres = (Button) view.findViewById(R.id.tres);
        Button boton_cuatro = (Button) view.findViewById(R.id.cuatro);
        Button boton_cinco = (Button) view.findViewById(R.id.cinco);
        Button boton_seis = (Button) view.findViewById(R.id.seis);
        Button boton_siete = (Button) view.findViewById(R.id.siete);
        Button boton_ocho = (Button) view.findViewById(R.id.ocho);
        Button boton_nueve = (Button) view.findViewById(R.id.nueve);
        Button boton_sumar = (Button) view.findViewById(R.id.sumar);
        Button boton_restar = (Button) view.findViewById(R.id.restar);
        Button boton_multiplicar = (Button) view.findViewById(R.id.multiplicar);
        Button boton_dividir = (Button) view.findViewById(R.id.dividir);
        Button boton_limpiar_pantalla = (Button) view.findViewById(R.id.limpiar_pantalla);
        Button boton_coma = (Button) view.findViewById(R.id.coma);
        Button boton_igual = (Button) view.findViewById(R.id.igual);
        Button boton_borrar_ultimo = (Button) view.findViewById(R.id.borrar_ultimo);

        TextView Resultado = (TextView) view.findViewById(R.id.resultado);

        boton_borrar_ultimo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String aux = Resultado.getText().toString();
                aux = aux.substring(0, aux.length() - 1);
                Resultado.setText(aux);
            }
        });

        boton_limpiar_pantalla.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Resultado.setText("");
                contador = 0;
            }
        });

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
        return view;
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
