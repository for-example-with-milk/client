package milk.example.platform.client.packet.requestBody;

import lombok.*;
import milk.example.platform.client.builder.ServiceDataBuilder;

@Getter
@Setter
public class BServiceDataRequestBody {
    private ServiceDataBuilder.ServiceData data;

    public BServiceDataRequestBody(ServiceDataBuilder.ServiceData data) {
        this.data = data;
    }
}
