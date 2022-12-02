package milk.example.platform.client.packet.requestBody;

import lombok.*;
import milk.example.platform.client.builder.SampleDataBuilder;

@Getter
@Setter
public class SampleRequestBody {
    private SampleDataBuilder.Data data;
    private String data3;

    public SampleRequestBody(SampleDataBuilder.Data data, String data3) {
        this.data = data;
        this.data3 = data3;
    }
}