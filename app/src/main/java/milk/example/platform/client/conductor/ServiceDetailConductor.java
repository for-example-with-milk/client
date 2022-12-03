package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import milk.example.platform.client.packet.requestBody.ServiceDetailRequestBody;
import milk.example.platform.client.packet.responseBody.ServiceDetailResponseBody;
import milk.example.platform.client.service.subservice.Subservice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceDetailConductor extends Conductor{
    private Activity activity;

    public ServiceDetailConductor(Context context, Activity activity) {
        super(context);
        this.activity = activity;
    }


    public void serviceDetail(Long id){
        retrofit.serviceDetail(new ServiceDetailRequestBody(id)).enqueue(new Callback<>(){

            @Override
            public void onResponse(Call<ServiceDetailResponseBody> call, Response<ServiceDetailResponseBody> response) {
                Long id = response.body().getId();
                String name= response.body().getName();
                String icoUrl= response.body().getIcoUrl();
                String lore= response.body().getLore();
                String city= response.body().getCity();
                String categoryList= response.body().getCategoryList();
                String account= response.body().getAccount();
                ArrayList<Subservice> subServiceList= response.body().getSubServiceList();
                String message = response.body().getMessage();
            }

            @Override
            public void onFailure(Call<ServiceDetailResponseBody> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
