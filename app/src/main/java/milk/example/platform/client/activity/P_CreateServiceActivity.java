package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;
import milk.example.platform.client.builder.ServiceDataBuilder;
import milk.example.platform.client.conductor.ServiceBuilderConductor;

//(제공자)서비스 생성
public class P_CreateServiceActivity extends AppCompatActivity {
    private ServiceDataBuilder builder;
    private ImageView back;
    private ImageView home;
    private Button submit;
    private EditText name;
    private EditText lore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_create_new_service);

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        submit = findViewById(R.id.submit);
        name = findViewById(R.id.serve_name);
        lore = findViewById(R.id.serv_lore);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(P_CreateServiceActivity.this, ProviderMainActivity.class);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(serviceIntent);
                finish();
            }
        });

        submit.setOnClickListener(view -> builder.validate(name.getText().toString(),lore.getText().toString()));
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent serviceIntent = new Intent(P_CreateServiceActivity.this, ProviderMainActivity.class);
//                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                startActivity(serviceIntent);
//                finish();
//            }
//        });

    }
}