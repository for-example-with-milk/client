package milk.example.platform.client.packet.responseBody;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import milk.example.platform.client.service.Service;

@Getter
@Setter
public class UserServiceListReponseBody {
    private int result;
    private List<Service> serviceList;
    private String message;
}
