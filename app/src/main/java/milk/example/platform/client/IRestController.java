package milk.example.platform.client;

import milk.example.platform.client.packet.requestBody.LoginRequestBody;
import milk.example.platform.client.packet.requestBody.SignUpUserRequestBody;
import milk.example.platform.client.packet.responseBody.LoginResponseBody;
import milk.example.platform.client.packet.responseBody.SignUpResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IRestController {
    @POST("/user/signup/user")
    Call<SignUpResponseBody> signUpUser(@Body SignUpUserRequestBody request);

    @POST("/user/login")
    Call<LoginResponseBody> login(@Body LoginRequestBody request);


}