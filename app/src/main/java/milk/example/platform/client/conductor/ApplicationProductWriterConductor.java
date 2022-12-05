package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Date;
import java.util.ArrayList;

import milk.example.platform.client.builder.ApplicationProductWriter;
import milk.example.platform.client.builder.SubserviceProductDataBuilder;
import milk.example.platform.client.service.subservice.Form;
import milk.example.platform.client.service.subservice.FormElement;

public class ApplicationProductWriterConductor extends Conductor {
    private long subServiceId;
    private String subServiceName;
    private Activity activity;
    private ArrayList<ApplicationProductWriter.Data.AppliedElement> appliedElementList;
    private Form form;

    private ApplicationProductWriter writer = new ApplicationProductWriter();

    public ApplicationProductWriterConductor(Context context, long subServiceId, String subServiceName, Form form) {
        super(context);
        this.subServiceId = subServiceId;
        this.subServiceName = subServiceName;
        this.form = form;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setAppliedElementList(ArrayList<ApplicationProductWriter.Data.AppliedElement> appliedElementList) {
        writer.setAppliedElementList(appliedElementList);
    }

    public void setAppliment(Date time) {
        writer.setAppliment(new ApplicationProductWriter.Data.Appliment(subServiceName, time));
    }

    public Form getForm() {
        return form;
    }

    public void summit() {
        setAppliment(new Date());
        writer.setSubServiceId(subServiceId);
        writer.setAppliedElementList(appliedElementList);
        ApplicationProductWriter.Out out = writer.build();

        if (out.getResult() == 0) {
            Log.i("밀크", new Gson().toJson(out.getData()));
        }
        else {
            switch (out.getResult()) {
                case 1:
                    Toast.makeText(context, "선택한 물품이 없습니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
