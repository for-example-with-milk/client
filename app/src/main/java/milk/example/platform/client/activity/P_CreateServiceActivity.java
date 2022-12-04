package milk.example.platform.client.activity;

import static android.R.layout.simple_spinner_dropdown_item;
import static android.R.layout.simple_spinner_item;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;
import milk.example.platform.client.conductor.ServiceBuilderConductor;

//(제공자)서비스 생성
public class P_CreateServiceActivity extends AppCompatActivity {
    private ServiceBuilderConductor conductor;
    private ImageView back;
    private ImageView home;
    private Button confirm;
    private EditText name;
    private EditText lore;
    ArrayAdapter<CharSequence> adspin1,adspin2;
    String ch_city1 = "";
    String ch_city2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_create_new_service);

        conductor = new ServiceBuilderConductor(getApplicationContext());

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        name = findViewById(R.id.new_serv_name);
        lore = findViewById(R.id.new_serv_lore);
        confirm = findViewById(R.id.create_service);
//        textView1 = findViewById(R.id.city1_txt);
//        textView2 = findViewById(R.id.city2_txt);
//        Spinner spinner1 = findViewById(R.id.city1);
//        Spinner spinner2 = findViewById(R.id.city2);


        //nav_bar back&home
        back.setOnClickListener(view -> finish());
        home.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(P_CreateServiceActivity.this, UserMainActivity.class);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(serviceIntent);
            finish();
        });

        //서비스 생성 버튼
        confirm.setOnClickListener(view -> {
            conductor.setName(name.getText().toString());
            conductor.setLore(lore.getText().toString());
            //conductor.setCity(city.getText().toString());
            //conductor.setCity(categoryList.getText().toString());
            //conductor.setCity(account.getText().toString());
            conductor.summit();
        });

        //spinner
        final Spinner spinner1 = (Spinner)findViewById(R.id.city1);
        final Spinner spinner2 = (Spinner)findViewById(R.id.city2);

        adspin1 = ArrayAdapter.createFromResource(P_CreateServiceActivity.this, R.array.city1, simple_spinner_dropdown_item);
        spinner1.setAdapter(adspin1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adspin1.getItem(i).equals("서울특별시")) {
                    ch_city1 = "서울특별시";
                    adspin2 = ArrayAdapter.createFromResource(P_CreateServiceActivity.this, R.array.city1_0, simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(simple_spinner_dropdown_item);
                    spinner2.setAdapter(adspin2);
                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            ch_city2 = adspin2.getItem(i).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if (adspin1.getItem(i).equals("대구광역시")) {
                    ch_city1 = "대구광역시";
                    adspin2 = ArrayAdapter.createFromResource(P_CreateServiceActivity.this, R.array.city1_1, simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(simple_spinner_dropdown_item);
                    spinner2.setAdapter(adspin2);
                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            ch_city2 = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}