package milk.example.platform.client.service.subservice;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormElement {
    private Long id;
    private ElementType elementType;
    private String prodName;
    private String prodDescription;
    private String infoText;
    private int prodPrice;
    private InputType inputType;
    private short isRequireResponse;
    private short isMultipleChoice;
    private List<Checkbox> checkboxList;
}