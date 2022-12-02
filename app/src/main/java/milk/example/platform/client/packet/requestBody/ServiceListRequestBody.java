package milk.example.platform.client.packet.requestBody;
import lombok.*;

@Getter
@Setter
public class ServiceListRequestBody {
    private String city;
    private String sort;

    public ServiceListRequestBody(String city,String sort){
        this.city = city;
        this.sort = sort;
    }
}
