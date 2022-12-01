package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import milk.example.platform.client.LoginAccount;
import milk.example.platform.client.activity.ProviderMainActivity;
import milk.example.platform.client.activity.UserMainActivity;
import milk.example.platform.client.packet.requestBody.LoginRequestBody;
import milk.example.platform.client.packet.responseBody.LoginResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountConductor extends Conductor {
    private Activity activity;

    public AccountConductor(Context context, Activity activity) {
        super(context);
        this.activity = activity;
    }

    public void login(String id, String pw) {
        retrofit.login(new LoginRequestBody(id, pw)).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {
                int result = response.body().getResult();
                String message = response.body().getMessage();
                String id = response.body().getId();
                String name = response.body().getName();
                boolean isUser = response.body().getUser();

                if (result != 0) {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
                else {
                    LoginAccount.getInstance().setInfos(id, name, isUser);
                    //Toast.makeText(context,String.valueOf(isUser),Toast.LENGTH_SHORT).show();

                    if (isUser) {
                        //이용자 메인
                        Conductor.save(new EmptyConductor(context));
                        Intent intent = new Intent(activity, UserMainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  //몰라뽀비
                        context.startActivity(intent);
                        activity.finish();
                    }
                    else {
                        // 제공자 화면 전환
                        Conductor.save(new EmptyConductor(context));
                        Intent intent = new Intent(activity, ProviderMainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        activity.finish();

                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponseBody> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}