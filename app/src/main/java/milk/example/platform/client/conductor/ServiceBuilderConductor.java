package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import milk.example.platform.client.LoginAccount;
import milk.example.platform.client.builder.ServiceDataBuilder;
import milk.example.platform.client.packet.requestBody.CreateServiceRequestBody;
import milk.example.platform.client.packet.responseBody.CreateServiceResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceBuilderConductor extends Conductor {
    private ServiceDataBuilder builder = new ServiceDataBuilder();
    private Activity activity = null;

    public ServiceBuilderConductor(Context context) {
        super(context);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setName(String name) {
        builder.setName(name);
    }

    public void setLore(String lore) {
        builder.setLore(lore);
    }

    public void setBaccount(String baccount) { builder.setBaccount(baccount);}

    public void setCity(String city) { builder.setCity(city);}

    public void setCategoryList(String categoryList) { builder.setCategoryList(categoryList);}

    public void summit() {
        ServiceDataBuilder.Out out = builder.build();
        if (out.getResult() == 0) {
            retrofit.createService(new CreateServiceRequestBody(out.getData(), LoginAccount.getInstance().getId())).enqueue(new Callback<CreateServiceResponseBody>() {
                @Override
                public void onResponse(Call<CreateServiceResponseBody> call, Response<CreateServiceResponseBody> response) {
                    int result = response.body().getResult();
                    String message = response.body().getMessage();
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

                    if (result == 0) {
                        activity.finish();
                    }
                }

                @Override
                public void onFailure(Call<CreateServiceResponseBody> call, Throwable t) {
                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            switch (out.getResult()) {
                case 1:
                    Toast.makeText(context, "이름은 필수항목, 최소2자 - 최대20자", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(context,"설명은 필수항목, 최대 1024자", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(context,"계좌는 필수항목",Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(context,"지역선택은 필수항목",Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(context,"카테고리 선택은 필수항목",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
