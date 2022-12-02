package milk.example.platform.client.builder;

import lombok.Getter;

public class SampleDataBuilder {
    private int data1;
    private String data2;

    @Getter
    public class Data {
        private int data1;
        private String data2;

        public Data(int data1, String data2) {
            this.data1 = data1;
            this.data2 = data2;
        }
    }

    @Getter
    public class Out {
        private Data data;
        private int result;

        public Out(Data data, int result) {
            this.data = data;
            this.result = result;
        }
    }

    private int validate() {
        // 가지고 있는 값에 대한 유효성 검사
        // 리턴은 에러코드, 0이면 성공

        return 0;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public Out build() {
        int result = validate();

        if (result == 0)
            return new Out(new Data(data1, data2), result);
        return new Out(null, result);
    }
}
