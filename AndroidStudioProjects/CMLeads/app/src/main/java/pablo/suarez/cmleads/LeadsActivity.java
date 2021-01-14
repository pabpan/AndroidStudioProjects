package pablo.suarez.cmleads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Screen para el manejo de los leads en la app CRM
 */

public class LeadsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads);

        //Agregar fragmento
        LeadsFragment leadsFragment = (LeadsFragment)
                getSupportFragmentManager().findFragmentById(R.id.leads_container);

        if (leadsFragment == null) {
            leadsFragment = LeadsFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.leads_container, leadsFragment)
                    .commit();
        }
    }
}