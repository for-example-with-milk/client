package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;

import milk.example.platform.client.LoginAccount;
import milk.example.platform.client.builder.ApplicationProductWriter;
import milk.example.platform.client.builder.SubserviceProductDataBuilder;
import milk.example.platform.client.packet.requestBody.ApplimentProductRequestBody;
import milk.example.platform.client.packet.responseBody.ApplimentResponseBody;
import milk.example.platform.client.service.subservice.Form;
import milk.example.platform.client.service.subservice.FormElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationProductWriterConductor extends Conductor {
    private long subServiceId;
    private String subServiceName;
    private Activity activity;
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

    void setAppliment(String time) {
        writer.setAppliment(new ApplicationProductWriter.Data.Appliment(subServiceName, time));
    }

    public Form getForm() {
        return form;
    }

    public void summit() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setAppliment(LocalDateTime.now().toString());
        }
        writer.setSubServiceId(subServiceId);
        ApplicationProductWriter.Out out = writer.build();


        if (out.getResult() == 0) {
            ApplicationProductWriter.Data data = out.getData();
            ApplimentProductRequestBody request = new ApplimentProductRequestBody(LoginAccount.getInstance().getId(), data.getSubServiceId(), data.getAppliment(), data.getAppliedElementList());

            Log.i("밀크", new Gson().toJson(request));

            retrofit.apply(request).enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<ApplimentResponseBody> call, Response<ApplimentResponseBody> response) {
                    Log.i("밀크", response.code() + "");

                    int result = response.body().getResult();
                    String message = response.body().getMessage();

                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    if (result == 0) {
                        activity.finish();
                    }
                }

                @Override
                public void onFailure(Call<ApplimentResponseBody> call, Throwable t) {
                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
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
