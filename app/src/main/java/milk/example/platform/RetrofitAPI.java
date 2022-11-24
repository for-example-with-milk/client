package milk.example.platform;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("/test")
    Call<ResponseBody> getStr();
}
