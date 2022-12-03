package milk.example.platform.client;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import milk.example.platform.client.service.Service;
import milk.example.platform.client.service.subservice.Subservice;

@Getter
@Setter
public class ListViewAll {
    private int type; // 아이템 구분을 위한 변수


    private Long id;
    private String name;
    private String icoUrl;
    private String lore;
    private String city;
    private String categoryList;
    private String account;
    private ArrayList<Subservice> subServiceList;

    private Long s_id;
    private Service service;
    private String s_name;
    private String s_lore;
    private short isRegularPayment;
    //private Form form;




}
