package pablo.suarez.widgets_basicos_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox CheckBox_Cycling;
    CheckBox CheckBox_Teaching;
    CheckBox CheckBox_Blogging;
    Button Button_Hobby;
    TextView Operation_Hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();
    }

    public void initialUISetup(){

        CheckBox_Cycling = (CheckBox)findViewById(R.id.CheckBox_Cycling);
        CheckBox_Teaching = (CheckBox)findViewById(R.id.CheckBox_Teaching);
        CheckBox_Blogging = (CheckBox)findViewById(R.id.CheckBox_Blogging);
        Button_Hobby = (Button)findViewById(R.id.Button_Hobby);
        Operation_Hobby = (TextView)findViewById(R.id.Textview_Hobby);

        Button_Hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHobbyclick(v);
            }
        });
    }

    public void getHobbyclick(View v){
        String Textview_Message = "";
        if (CheckBox_Cycling.isChecked()) {
            Textview_Message += " Cycling";
        }
        if (CheckBox_Teaching.isChecked()) {
            Textview_Message += " Teaching";
        }
        if (CheckBox_Blogging.isChecked()) {
            Textview_Message += " Blogging";
        }
        showTextNotification(Textview_Message);
    }

    public void showTextNotification (String Message_to_display){
        Operation_Hobby.setText(Message_to_display);
    }
}