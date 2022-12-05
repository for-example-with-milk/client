package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import milk.example.platform.client.packet.requestBody.SubServiceRequestBody;
import milk.example.platform.client.packet.responseBody.SubServiceResponseBody;
import milk.example.platform.client.service.subservice.Subservice;
import retrofit2.Call;
import retrofit2.Response;

public class SubServiceListConductor extends Conductor{
    private Activity activity;
    private SubServiceListConductor subServiceListConductor;

    public SubServiceListConductor(Context context, Activity activity) {
        super(context);
        this.activity = activity;
    }
    public interface Callback {
        void execute(List<Subservice> subserviceList);
    }

    public void subserviceList(Long id, Callback callback){
        retrofit.subserviceList(new SubServiceRequestBody(id)).enqueue(new retrofit2.Callback<>(){

            @Override
            public void onResponse(Call<SubServiceResponseBody> call, Response<SubServiceResponseBody> response) {
                int result = response.body().getResult();
                String message = response.body().getMessage();
                List<Subservice> subserviceList  = response.body().getSubServiceList();

                if (result != 0){
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    callback.execute(subserviceList);
                }
            }

            @Override
            public void onFailure(Call<SubServiceResponseBody> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





}
