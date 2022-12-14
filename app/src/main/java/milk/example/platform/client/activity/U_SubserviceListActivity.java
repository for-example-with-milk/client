package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import milk.example.platform.client.R;
import milk.example.platform.client.service.TotalService;
import milk.example.platform.client.adapter.TotalServiceListAdapter;
import milk.example.platform.client.conductor.SubServiceListConductor;
import milk.example.platform.client.conductor.ServiceDetailConductor;
import milk.example.platform.client.service.Service;
import milk.example.platform.client.service.subservice.Subservice;

public class U_SubserviceListActivity extends AppCompatActivity {
    private SubServiceListConductor conductor;
    private ServiceDetailConductor detail_conductor;
    private ImageView back;
    private ImageView home;
    private Long given_id;
    private List<TotalService> totals = new ArrayList<>();
    private TotalServiceListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_subservice_list);

        ListView listview = (ListView)findViewById(R.id.subService_list);

        Intent intent = getIntent();
        given_id = intent.getLongExtra("service_info",0);
        Log.i("받아온 id",given_id.toString());

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

        adapter = new TotalServiceListAdapter(getApplicationContext(), totals);
        listview.setAdapter(adapter);

        detail_conductor = new ServiceDetailConductor(getApplicationContext(),this);
        conductor = new SubServiceListConductor(getApplicationContext(), this);

        detail_conductor.serviceDetail(given_id, serviceDetail -> {
            for (Service s :serviceDetail){
                TotalService ts = new TotalService();
                ts.setName(s.getName());
                ts.setIcoUrl((s.getIcoUrl()));
                ts.setOp(0);
                ts.setCategoryList(s.getCategoryList());
                ts.setLore(s.getLore());
                ts.setCity(s.getCity());
                ts.setAccount(s.getAccount());
                ts.setId(s.getId());
                totals.add(ts);
            }
            adapter.notifyDataSetChanged();

            conductor.subserviceList(given_id, subserviceList -> {
                for (Subservice s : subserviceList){
                    Collections.sort(s.getForm().getFormElementList());

                    TotalService ts = new TotalService();
                    ts.setName(s.getName());
                    ts.setOp(1);
                    ts.setForm(s.getForm());
                    ts.setS_name(s.getName());
                    ts.setIsRegularPayment(s.getIsRegularPayment());
                    ts.setS_lore(s.getLore());
                    ts.setS_id(s.getId());
                    totals.add(ts);
                }
                adapter.notifyDataSetChanged();
            });
        });
    }
}
