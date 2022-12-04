package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;
import milk.example.platform.client.builder.ServiceDataBuilder;
import milk.example.platform.client.conductor.ServiceConductor;

//(제공자)서비스 생성
public class P_CreateServiceActivity extends AppCompatActivity {
    private ServiceConductor conductor;

    private ImageView back;
    private ImageView home;
    private EditText name;
    private EditText lore;
    private Button confirm;
    private Button select_btn;
    private TextView tagList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_create_new_service);

        conductor = new ServiceConductor(getApplicationContext());

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        name = findViewById(R.id.new_serv_name);
        lore = findViewById(R.id.new_serv_lore);
        confirm = findViewById(R.id.create_service);
        select_btn = findViewById(R.id.tag_button);
        tagList = findViewById(R.id.tagList);






        back.setOnClickListener(view -> finish());
        home.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(P_CreateServiceActivity.this, UserMainActivity.class);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(serviceIntent);
            finish();
        });
        confirm.setOnClickListener(view -> {
            conductor.setName(name.getText().toString());
            conductor.setLore(lore.getText().toString());
            conductor.summit();
        });
    }
}