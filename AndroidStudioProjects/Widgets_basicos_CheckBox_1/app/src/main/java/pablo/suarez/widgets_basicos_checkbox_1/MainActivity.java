package pablo.suarez.widgets_basicos_checkbox_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox CheckBox_Cycling;
    CheckBox CheckBox_Teaching;
    CheckBox CheckBox_Blogging;
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
/*
        Operation_Hobby = (TextView)findViewById(R.id.Textview_Hobby);
*/

        CheckBox_Cycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        CheckBox_Teaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        CheckBox_Blogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());

    }

    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if(isChecked) {
                if (buttonView==CheckBox_Cycling){
                showTextNotification("Cycling");
                }
                if (buttonView==CheckBox_Teaching){
                    showTextNotification("Teaching");
                }
                if (buttonView==CheckBox_Blogging){
                    showTextNotification("Blogging");
                }
            }
        }
    }
    public void showTextNotification(String msgToDisplay)
    { Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
}