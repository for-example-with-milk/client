package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import milk.example.platform.client.activity.P_ServiceListActivity;
import milk.example.platform.client.builder.ServiceDataBuilder;
import milk.example.platform.client.packet.responseBody.BServiceDataResponseBody;

public class ServiceBuilderConductor extends Conductor{
    //private Activity activity;

    private ServiceDataBuilder builder = new ServiceDataBuilder();

    public ServiceBuilderConductor(Context context){
        super(context);
    }

    public void setName(String name) { builder.setName(name);}

    public void setLore(String lore) {builder.setLore(lore);}


    public void submit(String name, String lore) {
        ServiceDataBuilder.Out out = builder.build();
        if(out.getResult() == 0) {
            Toast.makeText(context, "성공", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "실패", Toast.LENGTH_SHORT).show();
        }


    }




}
