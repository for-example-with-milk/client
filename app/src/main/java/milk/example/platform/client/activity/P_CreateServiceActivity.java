package milk.example.platform.client.activity;

import static android.R.layout.simple_spinner_dropdown_item;
import static android.R.layout.simple_spinner_item;

import android.content.DialogInterface;
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
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

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
    private EditText baccount;
    private String city;
    private int strend;
    private Button b_category;
    private TextView cat_view;
    List<String> selectedCat;
    AlertDialog.Builder builder;

    ArrayAdapter<CharSequence> adspin1,adspin2;
    String ch_city1 = "";
    String ch_city2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_create_new_service);

        conductor = new ServiceBuilderConductor(getApplicationContext());
        conductor.setActivity(this);

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        name = findViewById(R.id.new_serv_name);
        lore = findViewById(R.id.new_serv_lore);
        baccount = findViewById(R.id.new_serv_account);
        confirm = findViewById(R.id.create_service);
        b_category = findViewById(R.id.new_serv_cat);
        cat_view = findViewById(R.id.new_serv_catresult);

        //카테고리 선택 팝업창
        b_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
        public void showDialog(){
            selectedCat = new ArrayList<>();
            builder = new AlertDialog.Builder(P_CreateServiceActivity.this);
            builder.setMultiChoiceItems(R.array.check_cat, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    String[] items = getResources().getStringArray(R.array.check_cat);

                    if(b) {
                        selectedCat.add(items[i]);
                    }else if(selectedCat.contains(items[i])){
                        selectedCat.remove(items[i]);
                    }
                }
            });

            builder.setPositiveButton("선택", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String final_selection = "";

                    for (String item : selectedCat) {
                        final_selection = final_selection + "#" + item;
                    }
                    cat_view.setText(final_selection);

            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        //nav_bar back&home
        back.setOnClickListener(view -> finish());
        home.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(P_CreateServiceActivity.this, ProviderMainActivity.class);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(serviceIntent);
            finish();
        });

        //도시선택 spinner
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
                            city = ch_city1 + " " + ch_city2;
                            strend = city.length();
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
                            city = ch_city1 + " " + ch_city2;
                            strend = city.length();
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

        //category.setOnClickListener();

        //서비스 생성 버튼
        confirm.setOnClickListener(view -> {
            conductor.setName(name.getText().toString());
            conductor.setLore(lore.getText().toString());
            conductor.setCity(city);
            conductor.setCategoryList(selectedCat.toString());
            conductor.setBaccount(baccount.getText().toString());
            conductor.summit();
        });


    }
}