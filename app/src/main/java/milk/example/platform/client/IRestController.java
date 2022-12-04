package milk.example.platform.client;

import milk.example.platform.client.packet.requestBody.*;
import milk.example.platform.client.packet.responseBody.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IRestController {
    @POST("/user/signup/user")
    Call<SignUpResponseBody> signUpUser(@Body SignUpUserRequestBody request);

    @POST("/user/login")
    Call<LoginResponseBody> login(@Body LoginRequestBody request);

    @POST("/serv/getlist")
    Call<ServiceListResponseBody> serviceList(@Body ServiceListRequestBody request);

    @POST("/ser/detail")
    Call<SubServiceResponseBody> totalserviceList(@Body SubServiceRequestBody request);

    @POST("serv/get")
    Call<ServiceDetailResponseBody> serviceDetail(@Body ServiceDetailRequestBody request);

    @POST("serv/getUserlist")
    Call<UserServiceListReponseBody> userServiceList (@Body UserServiceListRequestBody request);
    @POST("serv/getUserlist")
    Call<UserServiceListReponseBody> provserviceList (@Body UserServiceListRequestBody request);

    @POST("serv/create")
    Call<CreateServiceResponseBody> createService(@Body CreateServiceRequestBody request);

    @POST("subserv/create")
    Call<CreateSubServiceProductResponseBody> createSubserviceProduct(@Body CreateSubServiceProductRequestBody request);
}