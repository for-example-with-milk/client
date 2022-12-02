package milk.example.platform.client.packet.responseBody;

import java.util.ArrayList;


import milk.example.platform.client.service.subservice.Subservice;
import lombok.*;

@Getter
@Setter
public class ServiceListResponseBody { //리스트 형태로 바꿔야함
    private Long id;
    private String name;
    private String icoUrl;
    private String lore;
    private String city;
    private String categoryList;
    private String account;
    private ArrayList<Subservice> subServiceList;
    private String message;
}
