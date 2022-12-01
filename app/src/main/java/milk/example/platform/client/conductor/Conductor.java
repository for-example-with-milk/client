package milk.example.platform.client.conductor;

import android.content.Context;

import milk.example.platform.client.IRestController;
import milk.example.platform.client.RestController;

public class Conductor {
    protected IRestController retrofit;
    protected Context context;
    private static Conductor saved = null;

    public static void save(Conductor conductor) {
        saved = conductor;
    }

    public static Conductor load() {
        Conductor tmp = saved;
        saved = null;
        return tmp;
    }

    public Conductor(Context context) {
        retrofit = RestController.retrofitService;
        this.context = context;
    }
}
