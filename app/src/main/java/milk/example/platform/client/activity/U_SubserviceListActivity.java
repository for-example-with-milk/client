package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;
import milk.example.platform.client.SubServiceListAdapter;
import milk.example.platform.client.conductor.SubServiceListConductor;
import milk.example.platform.client.conductor.ServiceDetailConductor;

public class U_SubserviceListActivity extends AppCompatActivity {
    private SubServiceListConductor conductor;
    private ServiceDetailConductor detail_conductor;
    private ImageView back;
    private ImageView home;
    private Long given_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_subservice_list);

        ListView listview = (ListView)findViewById(R.id.subService_list);

        Intent intent = getIntent();
        given_id=Long.parseLong(intent.getStringExtra("service_info"));

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(U_SubserviceListActivity.this, UserMainActivity.class);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(serviceIntent);
                finish();
            }
        });


        detail_conductor = new ServiceDetailConductor(getApplicationContext(),this);
        detail_conductor.serviceDetail(given_id);


        conductor = new SubServiceListConductor(getApplicationContext(), this);
        conductor.subserviceList(given_id, subserviceList->{
            SubServiceListAdapter adapter = new SubServiceListAdapter(getApplicationContext(),subserviceList);
            listview.setAdapter(adapter);




        });


    }
}
