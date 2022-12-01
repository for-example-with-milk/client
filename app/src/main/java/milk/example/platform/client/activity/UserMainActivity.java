package milk.example.platform.client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import milk.example.platform.client.R;
import milk.example.platform.client.conductor.Conductor;
import milk.example.platform.client.conductor.EmptyConductor;

public class UserMainActivity extends AppCompatActivity {
    private EmptyConductor conductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_main);

        conductor = (EmptyConductor) Conductor.load();
        conductor.setActivity(this);
    }
}