package milk.example.platform.client.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;

//(제공자)생성 서비스 목록
public class P_ServiceListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_service_list);
    }

}