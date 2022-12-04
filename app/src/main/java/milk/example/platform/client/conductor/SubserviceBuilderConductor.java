package milk.example.platform.client.conductor;

import android.content.Context;

import milk.example.platform.client.builder.ServiceDataBuilder;
import milk.example.platform.client.builder.SubserviceDataBuilder;

public class SubserviceBuilderConductor extends Conductor{

    private SubserviceDataBuilder builder = new SubserviceDataBuilder();
    public SubserviceBuilderConductor(Context context) {
        super(context);
    }

    public void SetName(String name){
        builder.setName(name);
    }
    public void SetPrice(int price){
        builder.setPrice(price);
    }
    public void SetIconUrl(String iconUrl){
        builder.setIconUrl(iconUrl);
    }
    public void SetExplain(String explain){
        builder.setExplain(explain);
    }
    public void SetYear(String year){
        builder.setYear(year);
    }
    public void SetMonth(String month){
        builder.setMonth(month);
    }
    public void SetWeek(String week){
        builder.setWeek(week);
    }
}
