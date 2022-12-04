package milk.example.platform.client.packet.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceListRequestBody {
    private Long userId;
    private Long serviceId;

    public UserServiceListRequestBody(Long userId,Long serviceId) {
        this.userId = userId;
        this.serviceId = serviceId;
    }

}
