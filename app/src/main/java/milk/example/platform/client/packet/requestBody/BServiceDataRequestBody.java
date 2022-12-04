package milk.example.platform.client.packet.requestBody;

import lombok.*;
import milk.example.platform.client.builder.ServiceDataBuilder;

@Getter
@Setter
public class BServiceDataRequestBody {
    private ServiceDataBuilder.Data data;

    public BServiceDataRequestBody(ServiceDataBuilder.Data data) {
        this.data = data;
    }
}
