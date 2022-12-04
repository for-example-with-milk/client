package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

import milk.example.platform.client.packet.requestBody.ServiceListRequestBody;
import milk.example.platform.client.packet.requestBody.UserServiceListRequestBody;
import milk.example.platform.client.packet.responseBody.UserServiceListReponseBody;
import milk.example.platform.client.service.Service;
import retrofit2.Call;
import retrofit2.Response;

public class UserServiceListConductor extends Conductor{
    public interface Callback {
        void execute(List<Service> serviceList);
    }
    private Activity activity;

    public UserServiceListConductor(Context context, Activity activity) {
        super(context);
        this.activity = activity;
    }


    public void userServiceList(String userId, Callback callback){
        retrofit.userServiceList(new UserServiceListRequestBody(userId)).enqueue(new retrofit2.Callback<>(){

            @Override
            public void onResponse(Call<UserServiceListReponseBody> call, Response<UserServiceListReponseBody> response) {
                int result = response.body().getResult();
                List<Service> userserviceList = response.body().getServiceList();
                String message = response.body().getMessage();


                if(result!=0){
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    callback.execute(userserviceList);
                }
            }

            @Override
            public void onFailure(Call<UserServiceListReponseBody> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }






}
