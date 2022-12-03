package milk.example.platform.client.conductor;

import android.app.Activity;

import java.util.List;

import milk.example.platform.client.service.Service;
import milk.example.platform.client.service.subservice.Subservice;

public class SubServiceListConductor {
    public interface Callback {
        void execute(List<Subservice> subServiceList);
    }
    private Activity activity;


}
