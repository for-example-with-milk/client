package milk.example.platform.client.builder;

import android.util.Log;

import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;

import lombok.Getter;

public class ApplicationProductWriter {
    @Getter
    public class Data {
        @Getter
        public static class Appliment {
            private String subServiceName;
            private String time;

            public Appliment(String subServiceName, String time) {
                this.subServiceName = subServiceName;
                this.time = time;
            }
        }

        @Getter
        public static class AppliedElement {
            private int idx;
            private String elementType = "PRODUCT";
            private String prodName;
            private int prodPrice;
            private int prodNum;

            public AppliedElement(int idx, String prodName, int prodPrice, int prodNum) {
                this.idx = idx;
                this.prodName = prodName;
                this.prodPrice = prodPrice;
                this.prodNum = prodNum;
            }
        }

        private long subServiceId;
        private Appliment appliment;
        private ArrayList<AppliedElement> appliedElementList;

        public Data(long subServiceId, Appliment appliment, ArrayList<AppliedElement> appliedElementList) {
            this.subServiceId = subServiceId;
            this.appliment = appliment;
            this.appliedElementList = appliedElementList;
        }
    }

    @Getter
    public class Out {
        private ApplicationProductWriter.Data data;
        private int result;

        public Out(ApplicationProductWriter.Data data, int result) {
            this.data = data;
            this.result = result;
        }
    }

    private int validate() {
        // 선택한 물품 없음
        int total = 0;
        for (Data.AppliedElement e : appliedElementList) {
            total += e.getProdNum();
        }
        if (total == 0)
            return 1;

        return 0;
    }

    private long subServiceId;
    private Data.Appliment appliment;
    private ArrayList<Data.AppliedElement> appliedElementList;

    public ApplicationProductWriter.Out build() {
        int result = validate();
        if (result == 0)
            return new ApplicationProductWriter.Out(new ApplicationProductWriter.Data(subServiceId, appliment, appliedElementList), result);
        return new ApplicationProductWriter.Out(null, result);
    }

    public void setSubServiceId(long subServiceId) {
        this.subServiceId = subServiceId;
    }

    public void setAppliedElementList(ArrayList<Data.AppliedElement> appliedElementList) {
        this.appliedElementList = appliedElementList;
    }

    public void setAppliment(Data.Appliment appliment) {
        this.appliment = appliment;
    }
}
