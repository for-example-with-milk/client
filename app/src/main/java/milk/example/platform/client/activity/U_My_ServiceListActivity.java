package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.LoginAccount;
import milk.example.platform.client.R;
import milk.example.platform.client.adapter.ServiceListAdapter;
import milk.example.platform.client.conductor.UserServiceListConductor;
import milk.example.platform.client.service.Service;

public class U_My_ServiceListActivity extends AppCompatActivity {
    private UserServiceListConductor conductor;
    private ImageView back;
    private ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_my_service_list);

        ListView listview = (ListView)findViewById(R.id.service_list);


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
                Intent serviceIntent = new Intent(U_My_ServiceListActivity.this, UserMainActivity.class);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(serviceIntent);
                finish();
            }
        });


        conductor = new UserServiceListConductor(getApplicationContext(), this);
        conductor.userServiceList(LoginAccount.getInstance().getId(),userserviceList -> {
            for (Service service : userserviceList) {
                Log.i("밀크", service.toString());
            }
            ServiceListAdapter adapter = new ServiceListAdapter(getApplicationContext(),userserviceList);

            listview.setAdapter(adapter);
        });


    }
}
