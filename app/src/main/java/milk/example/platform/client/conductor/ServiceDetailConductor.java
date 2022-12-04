package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import milk.example.platform.client.SubServiceListAdapter;
import milk.example.platform.client.packet.requestBody.ServiceDetailRequestBody;
import milk.example.platform.client.packet.responseBody.ServiceDetailResponseBody;
import milk.example.platform.client.service.Service;
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
        retrofit.serviceDetail(new ServiceDetailRequestBody(id)).enqueue(new Callback<ServiceDetailResponseBody>() {
            @Override
            public void onResponse(Call<ServiceDetailResponseBody> call, Response<ServiceDetailResponseBody> response) {

                int result = response.body().getResult();
                Service service = response.body().getService();
                String message = response.body().getMessage();

                Long id = service.getId();
                String name= service.getName();
                String icoUrl= service.getIcoUrl();
                String lore= service.getLore();
                String city= service.getCity();
                String categoryList= service.getCategoryList();
                String account= service.getAccount();


                if(result!=0){
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
                else{
                    SubServiceListAdapter adapter = new SubServiceListAdapter();
                    adapter.addItem(icoUrl,categoryList,name,lore,city,account);

                }





            }

            @Override
            public void onFailure(Call<ServiceDetailResponseBody> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }




}
