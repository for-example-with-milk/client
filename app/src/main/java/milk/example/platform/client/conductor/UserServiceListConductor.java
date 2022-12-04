package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;

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


    public void userServiceList(Long userId,Long serviceId, Callback callback){
        retrofit.userServiceList(new UserServiceListRequestBody(userId,serviceId)).enqueue(new retrofit2.Callback<>(){

            @Override
            public void onResponse(Call<UserServiceListReponseBody> call, Response<UserServiceListReponseBody> response) {

            }

            @Override
            public void onFailure(Call<UserServiceListReponseBody> call, Throwable t) {

            }
        });

    }






}
