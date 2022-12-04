package milk.example.platform.client.packet.responseBody;

import java.util.List;

import lombok.*;
import milk.example.platform.client.service.Service;
import milk.example.platform.client.service.subservice.Subservice;

@Getter
@Setter
public class SubServiceResponseBody {
    private int result;
    private List<Subservice> subserviceList;
    private String message;
}
