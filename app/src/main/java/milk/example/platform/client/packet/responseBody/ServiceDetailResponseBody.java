package milk.example.platform.client.packet.responseBody;
import java.util.ArrayList;

import lombok.*;
import milk.example.platform.client.service.subservice.Subservice;

@Getter
@Setter
public class ServiceDetailResponseBody {
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
