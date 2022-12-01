package milk.example.platform.client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import milk.example.platform.client.R;
import milk.example.platform.client.conductor.Conductor;
import milk.example.platform.client.conductor.EmptyConductor;

public class UserMainActivity extends AppCompatActivity {
    private EmptyConductor conductor;
    private Button ViewServiceList;
    private Button MyServiceList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_main);

        ViewServiceList = findViewById(R.id.button1);
        MyServiceList = findViewById(R.id.button2);

        ViewServiceList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(UserMainActivity.this,U_View_ServiceListActivity.class);
                startActivity(serviceIntent);
                //finish();
            }
        });

        MyServiceList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(UserMainActivity.this,U_My_ServiceListActivity.class);
                startActivity(serviceIntent);
                //finish();
            }
        });


        conductor = (EmptyConductor) Conductor.load();
        conductor.setActivity(this);
    }
}