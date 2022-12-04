package milk.example.platform.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;

public class ProviderMainActivity extends AppCompatActivity {
    private Button ServiceList;
    private Button Create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_main);

        ServiceList = findViewById(R.id.button5);
        Create = findViewById(R.id.button6);

        ServiceList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
//                Intent serviceIntent = new Intent(ProviderMainActivity.this,P_ServiceListActivity.class);
//                startActivity(serviceIntent);
                //finish();

                Intent serviceIntent = new Intent(ProviderMainActivity.this,P_SubServiceCreateProductActivity.class);
                startActivity(serviceIntent);
            }
        });

        Create.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(ProviderMainActivity.this,P_CreateServiceActivity.class);
                startActivity(serviceIntent);
                //finish();
            }
        });
    }

}
