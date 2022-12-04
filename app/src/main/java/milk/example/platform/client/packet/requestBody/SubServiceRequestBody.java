package milk.example.platform.client.packet.requestBody;
import lombok.*;

@Getter
@Setter
public class SubServiceRequestBody {
    private Long id;

    public SubServiceRequestBody(Long id) {
        this.id = id;
    }

}
