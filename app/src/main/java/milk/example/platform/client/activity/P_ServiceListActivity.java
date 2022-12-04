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
import milk.example.platform.client.ServiceListAdapter;
import milk.example.platform.client.conductor.ServiceListConductor;
import milk.example.platform.client.conductor.UserServiceListConductor;
import milk.example.platform.client.service.Service;

//(제공자)생성 서비스 목록
public class P_ServiceListActivity extends AppCompatActivity {
    private ServiceListConductor conductor;
    private ImageView back;
    private ImageView home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_service_list);

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);

        ListView listview = (ListView)findViewById(R.id.service_list);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(P_ServiceListActivity.this, ProviderMainActivity.class);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(serviceIntent);
                finish();
            }
        });


        conductor = new ServiceListConductor(getApplicationContext(), this);
        conductor.provserviceList(LoginAccount.getInstance().getId(), provserviceList -> {
            for (Service service : provserviceList) {
                Log.i("밀크", service.toString());
            }
            ServiceListAdapter adapter = new ServiceListAdapter(getApplicationContext(),provserviceList);

            listview.setAdapter(adapter);
        });
    }
}