package milk.example.platform.client.service.subservice;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Form {
    private Long id;
    private List<FormElement> formElementList;
    private short isPurchase;
    private int servicePrice;
}