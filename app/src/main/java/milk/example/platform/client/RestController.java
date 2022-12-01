package milk.example.platform.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RestController {
    public static IRestController retrofitService;
    public static final RestController INSTANCE;

    static {
        Gson gson = new GsonBuilder().setLenient().create();

        INSTANCE = new RestController();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient logger = new OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(20L, TimeUnit.SECONDS).writeTimeout(20L, TimeUnit.SECONDS).build();
        Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl("http://34.64.220.6:8080/").addConverterFactory(GsonConverterFactory.create(gson)).client(logger).build();
        // Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl("http://10.0.2.2:8080/").addConverterFactory(GsonConverterFactory.create(gson)).client(logger).build();
        retrofitService = retrofit.create(IRestController.class);
    }
}