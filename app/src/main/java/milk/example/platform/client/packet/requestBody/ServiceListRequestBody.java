package milk.example.platform.client.packet.requestBody;
import lombok.*;

@Getter
@Setter
public class ServiceListRequestBody {
    private String city;
    private String tag;

    public ServiceListRequestBody(String tag,String city){
        this.city = city;
        this.tag = tag;
    }
}
