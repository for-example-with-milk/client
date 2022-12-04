package milk.example.platform.client.packet.requestBody;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import milk.example.platform.client.builder.SubserviceProductDataBuilder;

@Getter
@Setter
public class CreateSubServiceProductRequestBody {
    private int serviceId;
    private SubserviceProductDataBuilder.Data.SubService subService;
    private SubserviceProductDataBuilder.Data.Form form;
    private ArrayList<SubserviceProductDataBuilder.Data.FormElement> formElementList;

    public CreateSubServiceProductRequestBody(SubserviceProductDataBuilder.Data data, int serviceId) {
        this.serviceId = serviceId;
        this.subService = data.getSubService();
        this.form = data.getForm();
        this.formElementList = data.getFormElements();
    }
}
