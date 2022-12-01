package milk.example.platform.client.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import milk.example.platform.client.R;
import milk.example.platform.client.conductor.AccountConductor;

public class LoginActivity extends AppCompatActivity {
    private AccountConductor conductor;
    private Button login;
    private EditText id;
    private String pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        id = (EditText)findViewById(R.id.id);

        conductor = new AccountConductor(getApplicationContext(), this);

        login = findViewById(R.id.login_btn);
        login.setOnClickListener(view -> conductor.login("id0", "456"));
    }
}