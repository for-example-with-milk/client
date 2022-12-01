package milk.example.platform.client.conductor;

import android.app.Activity;

import milk.example.platform.client.IRestController;
import milk.example.platform.client.RestController;

public class Conductor {
    protected IRestController retrofit;
    protected Activity activity;

    public Conductor(Activity activity) {
        retrofit = RestController.retrofitService;
        this.activity = activity;
    }
}
