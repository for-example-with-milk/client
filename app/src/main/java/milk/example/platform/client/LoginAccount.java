package milk.example.platform.client;

import lombok.Getter;
import lombok.Setter;

public class LoginAccount {
    private String id;
    private String name;
    private boolean isUser;

    private static final LoginAccount INSTANCE;

    static  {
        INSTANCE = new LoginAccount();
    }

    public static LoginAccount getInstance() {
        return INSTANCE;
    }

    public void setInfos(String id, String name, boolean isUser) {
        this.id = id;
        this.name = name;
        this.isUser = isUser;
    }
}
