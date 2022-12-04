package milk.example.platform.client.packet.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceListRequestBody {
    private String token;

    public UserServiceListRequestBody(String token) {
        this.token = token;
    }

}
