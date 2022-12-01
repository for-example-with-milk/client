package milk.example.platform.client.conductor;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import milk.example.platform.client.packet.requestBody.LoginRequestBody;
import milk.example.platform.client.packet.responseBody.LoginResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountConductor extends Conductor {
    public AccountConductor(Activity activity) {
        super(activity);
    }

    public void login(String id, String pw) {
        retrofit.login(new LoginRequestBody(id, pw)).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {
                int result = response.body().getResult();
                String message = response.body().getMessage();
                String id = response.body().getId();

                if (result != 0)
                    Toast.makeText(activity.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginResponseBody> call, Throwable t) {
                Log.i("hello", t.getMessage());
            }
        });
    }
}