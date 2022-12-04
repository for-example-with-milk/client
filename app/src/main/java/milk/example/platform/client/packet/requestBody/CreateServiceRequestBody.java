package milk.example.platform.client.packet.requestBody;

import lombok.*;
import milk.example.platform.client.builder.ServiceDataBuilder;

@Getter
@Setter
public class CreateServiceRequestBody {
    private ServiceDataBuilder.Data service;
    private String token;

    public CreateServiceRequestBody(ServiceDataBuilder.Data service, String token) {
        this.service = service;
        this.token = token;
    }
}