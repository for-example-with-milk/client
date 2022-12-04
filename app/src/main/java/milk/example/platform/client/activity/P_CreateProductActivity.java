package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;
import milk.example.platform.client.conductor.SubserviceBuilderConductor;

//(제공자)하위서비스생성_물품
public class P_CreateProductActivity extends AppCompatActivity {
    private ImageView back;
    private ImageView home;
    private EditText name;
    private EditText price;
    private TextView iconUrl;
    private EditText explain;
    private Spinner year;
    private Spinner month;
    private Spinner week;
    private Button addBtn;
    private SubserviceBuilderConductor conductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_create_new_product);

        conductor = new SubserviceBuilderConductor(getApplicationContext());

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        iconUrl = findViewById(R.id.iconUrl);
        explain = findViewById(R.id.explain);
        year = findViewById(R.id.year);
        month = findViewById(R.id.month);
        week = findViewById(R.id.week);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(view ->{
            conductor.SetName(name.getText().toString());
            conductor.SetPrice(Integer.parseInt(price.getText().toString()));
            conductor.SetIconUrl(iconUrl.getText().toString());
            conductor.SetExplain(explain.getText().toString());
            conductor.SetYear(year.toString());
            conductor.SetMonth(month.toString());
            conductor.SetWeek(week.toString());

            //conductor


        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(P_CreateProductActivity.this, UserMainActivity.class);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(serviceIntent);
                finish();
            }
        });



    }
}
