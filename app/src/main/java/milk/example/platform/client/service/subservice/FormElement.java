package milk.example.platform.client.service.subservice;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormElement implements Comparable<FormElement> {
    private Long id;
    private int idx;
    private ElementType elementType;
    private String prodName;
    private String prodDescription;
    private String infoText;
    private int prodPrice;
    private InputType inputType;
    private short isRequireResponse;
    private short isMultipleChoice;
    private List<Checkbox> checkboxList;

    @Override
    public int compareTo(FormElement fe) {
        if (fe.getIdx() < idx) {
            return 1;
        } else if (fe.getIdx() > idx) {
            return -1;
        }
        return 0;
    }
}