package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import milk.example.platform.client.R;
import milk.example.platform.client.conductor.AccountConductor;
import milk.example.platform.client.conductor.ServiceListConductor;
import milk.example.platform.client.service.subservice.Subservice;

public class U_View_ServiceListActivity extends AppCompatActivity {
    private ServiceListConductor conductor;
    private ImageView back;
    private ImageView home;
    private Spinner sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_view_service_list);

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(U_View_ServiceListActivity.this, UserMainActivity.class);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(serviceIntent);
                finish();
            }
        });

        conductor = new ServiceListConductor(getApplicationContext(), this);
        conductor.serviceList("daegu-01", null, subServiceList -> {
            for (Subservice subservice : subServiceList) {
                Log.i("milk", subservice.toString());
            }
        });
    }
}