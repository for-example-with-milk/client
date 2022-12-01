package milk.example.platform.client.packet.responseBody;

import lombok.*;

@Getter
@Setter
public class LoginResponseBody {
    private int result;
    private String message;
    private String id;
    private String name;
    private boolean user;

    public boolean getUser() {
        return user;
    }

    //몰라뽀비
    public int getResult() { return result;}

    public String getMessage() { return message;}


    public String getId() { return id;}


    public String getName() { return name;}

}
