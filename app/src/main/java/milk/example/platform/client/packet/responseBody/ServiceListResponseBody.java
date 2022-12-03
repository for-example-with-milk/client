package milk.example.platform.client.packet.responseBody;

import java.util.ArrayList;
import java.util.List;


import milk.example.platform.client.service.Service;
import milk.example.platform.client.service.subservice.Subservice;
import lombok.*;

@Getter
@Setter
public class ServiceListResponseBody { //리스트 형태로 바꿔야함
    private int result;
    private List<Service> serviceList;
    private String message;
}
