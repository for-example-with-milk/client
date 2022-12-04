package milk.example.platform.client.service.user_service;

import java.util.List;

import milk.example.platform.client.service.subservice.Checkbox;

public class AppliedElement {
    private Long Id;
    private Appliment appliment;
    private enum elementType {PRODUCT,TEXT,IMG_VIDEO,FILE,CHECKBOX}
    private String prodName;



    private List<Checkedbox> checkedBoxList;

}
