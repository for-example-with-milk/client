package milk.example.platform.client.service.subservice;

import milk.example.platform.client.service.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subservice {
    private Long id;
    private Service service;
    private String name;
    private String lore;
    private short isRegularPayment;
    //private Form form;


}
