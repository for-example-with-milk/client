package milk.example.platform.client.service;

import java.util.ArrayList;

import milk.example.platform.client.LoginAccount;
import milk.example.platform.client.service.subservice.Subservice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
    private static final Service INSTANCE;

    static  {
        INSTANCE = new Service();
    }

    public static Service getInstance() {
        return INSTANCE;
    }


    private Long id;
    private String name;
    private String icoUrl;
    private String lore;
    private String city;
    private String categoryList;
    private String account;
    private ArrayList<Subservice> subServiceList;

}
