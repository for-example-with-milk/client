package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;
import milk.example.platform.client.adapter.ServiceListAdapter;
import milk.example.platform.client.conductor.ServiceListConductor;
import milk.example.platform.client.service.Service;

public class U_View_ServiceListActivity extends AppCompatActivity {
    private ServiceListConductor conductor;
    private ImageView back;
    private ImageView home;
    private Spinner category;
    private String[] tagItem = {"건강","안전","수리","정비","동물","식물","모임","요리","의류","음악","운동","게임","책","여행","공부","식픔"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_view_service_list);

        ListView listview = (ListView)findViewById(R.id.service_list);

        category = (Spinner)findViewById(R.id.spinner2);






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




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,tagItem
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        category.setAdapter(adapter);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                conductor.serviceList(tagItem[i], serviceList -> {
                    for (Service service : serviceList) {
                        Log.i("밀크", service.toString());
                    }
                    ServiceListAdapter Sadapter = new ServiceListAdapter(getApplicationContext(),serviceList);

                    listview.setAdapter(Sadapter);
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(U_View_ServiceListActivity.this, U_SubserviceListActivity.class);
                            Service id = serviceList.get(i);
                            Log.i("서비스 아이디",id.getId().toString());
                            intent.putExtra("service_info",id.getId());
                            startActivity(intent);
                        }
                    });
                });




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}