package milk.example.platform.client.packet.responseBody;
import java.util.ArrayList;

import lombok.*;
import milk.example.platform.client.service.Service;
import milk.example.platform.client.service.subservice.Subservice;

@Getter
@Setter
public class ServiceDetailResponseBody {
    private Service service;
    private int result;
    private String message;
    private ArrayList<Subservice> subServiceList;
}
