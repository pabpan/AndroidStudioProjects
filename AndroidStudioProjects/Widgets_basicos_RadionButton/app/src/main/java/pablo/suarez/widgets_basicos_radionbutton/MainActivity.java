package pablo.suarez.widgets_basicos_radionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView Label_Mensaje = (TextView)findViewById(R.id.Label_Selection);
        final RadioGroup Radio_Group = (RadioGroup)findViewById(R.id.Group_Radiobuttons);

        Radio_Group.clearCheck();
        Radio_Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String textoOpcion = "";
                if (group.getCheckedRadioButtonId() == R.id.Button_1)
                    textoOpcion += "OPCION 1 con ID:" + checkedId;
                if (group.getCheckedRadioButtonId() == R.id.Button_2)
                    textoOpcion += "OPCION 2 con ID:" + checkedId;
                Label_Mensaje.setText(textoOpcion);
            }
        });
    }
}