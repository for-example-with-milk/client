package milk.example.platform.client.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import milk.example.platform.client.service.subservice.Form;
import milk.example.platform.client.service.subservice.Subservice;


@Getter
@Setter
public class TotalService {
    private int op;

    private Long id;
    private String name;
    private String icoUrl;
    private String lore;
    private String city;
    private String categoryList;
    private String account;
    private List<Subservice> subServiceList;


    private Long s_id;
    private String s_name;
    private String s_lore;
    private short isRegularPayment;
    private Form form;
}
