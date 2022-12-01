package milk.example.platform.client.conductor;

import android.app.Activity;
import android.content.Context;

public class EmptyConductor extends Conductor {
    private Activity activity;

    public EmptyConductor(Context context) {
        super(context);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}