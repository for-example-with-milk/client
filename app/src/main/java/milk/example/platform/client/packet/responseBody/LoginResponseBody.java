package milk.example.platform.client.packet.responseBody;

import lombok.*;

@Getter
@Setter
public class LoginResponseBody {
    private int result;
    private String message;
    private String id;
}
