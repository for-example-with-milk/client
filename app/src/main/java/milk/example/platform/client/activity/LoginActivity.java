package milk.example.platform.client.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import milk.example.platform.client.R;
import milk.example.platform.client.conductor.AccountConductor;
import milk.example.platform.client.packet.requestBody.LoginRequestBody;
import milk.example.platform.client.packet.responseBody.LoginResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private AccountConductor conductor = new AccountConductor(this);

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login_btn);
        login.setOnClickListener(view -> conductor.login("id", "id"));
    }
}