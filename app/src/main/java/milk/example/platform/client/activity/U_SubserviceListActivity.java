package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;

public class U_SubserviceListActivity extends AppCompatActivity {
    private ImageView back;
    private ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_subservice_list);

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
    }
}
