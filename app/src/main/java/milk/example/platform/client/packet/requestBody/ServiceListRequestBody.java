package milk.example.platform.client.packet.requestBody;
import lombok.*;

@Getter
@Setter
public class ServiceListRequestBody {
    private String tag;

    public ServiceListRequestBody(String tag){
        this.tag = tag;
    }
}
