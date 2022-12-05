package milk.example.platform.client.packet.requestBody;

import java.util.ArrayList;

import lombok.Getter;
import milk.example.platform.client.builder.ApplicationProductWriter;

@Getter
public class ApplimentProductRequestBody {
    private String token;
    private long subServiceId;
    private ApplicationProductWriter.Data.Appliment appliment;
    private ArrayList<ApplicationProductWriter.Data.AppliedElement> appliedElementList;

    public ApplimentProductRequestBody(String token, long subServiceId, ApplicationProductWriter.Data.Appliment appliment, ArrayList<ApplicationProductWriter.Data.AppliedElement> appliedElementList) {
        this.token = token;
        this.subServiceId = subServiceId;
        this.appliment = appliment;
        this.appliedElementList = appliedElementList;
    }
}
