package milk.example.platform.client.packet.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceListRequestBody {
    private String userId;

    public UserServiceListRequestBody(String userId) {
        this.userId = userId;
    }

}
