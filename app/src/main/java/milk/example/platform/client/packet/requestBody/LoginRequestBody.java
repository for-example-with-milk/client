package milk.example.platform.client.packet.requestBody;

import lombok.*;

@Getter
@Setter
public class LoginRequestBody {
    private String id;
    private String pw;

    public LoginRequestBody(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
