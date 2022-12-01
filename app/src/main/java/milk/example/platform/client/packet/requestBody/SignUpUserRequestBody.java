package milk.example.platform.client.packet.requestBody;

import com.google.gson.annotations.Expose;

import lombok.*;

@Getter
@Setter
public class SignUpUserRequestBody {
    private String name;
    private String id;
    private String pw;
    private String pw2;
    private String phone_number;
    private String address;
    private String tagList;
    private String gender;
    private short age;
}