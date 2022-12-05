package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import milk.example.platform.client.packet.requestBody.ServiceListRequestBody;
import milk.example.platform.client.packet.requestBody.UserServiceListRequestBody;
import milk.example.platform.client.packet.responseBody.ServiceListResponseBody;
import milk.example.platform.client.packet.responseBody.UserServiceListReponseBody;
import milk.example.platform.client.service.Service;
import retrofit2.Call;
import retrofit2.Response;

public class ServiceListConductor extends Conductor {

    public interface Callback {
        void execute(List<Service> serviceList);
    }

    private Activity activity;

    public ServiceListConductor(Context context, Activity activity) {
        super(context);
        this.activity = activity;
    }

    public void serviceList(String tag, Callback callback){
        retrofit.serviceList(new ServiceListRequestBody(tag)).enqueue(new retrofit2.Callback<>(){
            @Override
            public void onResponse(Call<ServiceListResponseBody> call, Response<ServiceListResponseBody> response) {

                int result = response.body().getResult();
                List<Service> serviceList = response.body().getServiceList();
                String message = response.body().getMessage();




                if (result != 0){//이거 반대로 바꾸기
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    callback.execute(serviceList);

                }
            }

            @Override
            public void onFailure(Call<ServiceListResponseBody> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void provserviceList(String provId, Callback callback){
        retrofit.provserviceList(new UserServiceListRequestBody(provId)).enqueue(new retrofit2.Callback<>(){

            @Override
            public void onResponse(Call<UserServiceListReponseBody> call, Response<UserServiceListReponseBody> response) {
                Log.i("밀크", response.code() + "");

                int result = response.body().getResult();
                List<Service> provserviceList = response.body().getServiceList();
                String message = response.body().getMessage();


                if(result!=0){
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    callback.execute(provserviceList);
                }
            }

            @Override
            public void onFailure(Call<UserServiceListReponseBody> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
