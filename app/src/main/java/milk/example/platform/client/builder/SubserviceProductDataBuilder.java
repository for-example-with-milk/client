package milk.example.platform.client.builder;

import java.util.ArrayList;

import lombok.Getter;

public class SubserviceProductDataBuilder {
    private Data.SubService subService;
    private Data.Form form;
    private ArrayList<Data.FormElement> formElements;

    @Getter
    public class Data {
        private SubService subService;
        private Form form;
        private ArrayList<FormElement> formElements;

        @Getter
        public static class SubService {
            private String name;
            private String lore;
            private int isRegularPayment;

            public SubService(String name, String lore, int isRegularPayment) {
                this.name = name;
                this.lore = lore;
                this.isRegularPayment = isRegularPayment;
            }
        }

        @Getter
        public static class Form {
            private int isPurchase;
            private int servicePrice;

            public Form(int isPurchase, int servicePrice) {
                this.isPurchase = isPurchase;
                this.servicePrice = servicePrice;
            }
        }

        @Getter
        public static class FormElement {
            private int idx;
            private String prodName;
            private String prodDescription;
            private int prodPrice;

            public FormElement(int idx, String prodName, String prodDescription, int prodPrice) {
                this.idx = idx;
                this.prodName = prodName;
                this.prodDescription = prodDescription;
                this.prodPrice = prodPrice;
            }
        }

        public Data(SubService subService, Form form, ArrayList<FormElement> formElements) {
            this.subService = subService;
            this.form = form;
            this.formElements = formElements;
        }
    }

    public void setForm(Data.Form form) {
        this.form = form;
    }

    public void setFormElements(ArrayList<Data.FormElement> formElements) {
        this.formElements = formElements;
    }

    public void setSubService(Data.SubService subService) {
        this.subService = subService;
    }

    @Getter
    public class Out {
        private SubserviceProductDataBuilder.Data data;
        private int result;

        public Out(SubserviceProductDataBuilder.Data data, int result) {
            this.data = data;
            this.result = result;
        }
    }

    private int validate() {
        if (formElements.size() == 0)
            return 1; // 물품이 하나도 없음

        return 0;
    }

    public SubserviceProductDataBuilder.Out build() {
        int result = validate();

        if (result == 0)
            return new SubserviceProductDataBuilder.Out(new SubserviceProductDataBuilder.Data(subService, form, formElements), result);
        return new SubserviceProductDataBuilder.Out(null, result);
    }
}