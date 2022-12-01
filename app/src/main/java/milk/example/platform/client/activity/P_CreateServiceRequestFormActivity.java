package milk.example.platform.client.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import milk.example.platform.client.R;

//(제공자)하위서비스 신청양식 생성_서비스
public class P_CreateServiceRequestFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_create_service_request_form);
    }

}