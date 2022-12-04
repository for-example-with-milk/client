package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import milk.example.platform.client.builder.SubserviceProductDataBuilder;
import milk.example.platform.client.packet.requestBody.CreateSubServiceProductRequestBody;
import milk.example.platform.client.packet.responseBody.CreateSubServiceProductResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubserviceBuilderProductConductor extends Conductor {
    private SubserviceProductDataBuilder builder = new SubserviceProductDataBuilder();
    private Activity activity;

    public SubserviceBuilderProductConductor(Context context) {
        super(context);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setSubservice(SubserviceProductDataBuilder.Data.SubService subService) {
        builder.setSubService(subService);
    }

    public void setForm(SubserviceProductDataBuilder.Data.Form form) {
        builder.setForm(form);
    }

    public void setFormElements(ArrayList<SubserviceProductDataBuilder.Data.FormElement> formElements) {
        builder.setFormElements(formElements);
    }

    public void summit() {
        SubserviceProductDataBuilder.Out out = builder.build();
        if (out.getResult() == 0) { // ID 넣어야 함

            String gson = new Gson().toJson(new CreateSubServiceProductRequestBody(out.getData(), 1));
            Log.i("밀크", gson);

            retrofit.createSubserviceProduct(new CreateSubServiceProductRequestBody(out.getData(), 1)).enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<CreateSubServiceProductResponseBody> call, Response<CreateSubServiceProductResponseBody> response) {
                    Log.i("밀크", response.body().toString());
                    int result = response.body().getResult();
                    String message = response.body().getMessage();

                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    if (result == 0) {
                        activity.finish();
                    }
                }

                @Override
                public void onFailure(Call<CreateSubServiceProductResponseBody> call, Throwable t) {
                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            switch (out.getResult()) {
                case 1:
                    Toast.makeText(context, "목록이 하나도 없음", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
