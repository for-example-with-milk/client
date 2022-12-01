package milk.example.platform;

import lombok.Getter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IRestController {
    @GET("/test")
    Call<ResponseBody> getStr();
}