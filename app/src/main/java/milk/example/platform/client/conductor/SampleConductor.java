package milk.example.platform.client.conductor;

import android.content.Context;

import milk.example.platform.client.builder.SampleDataBuilder;
import milk.example.platform.client.packet.requestBody.SampleRequestBody;

public class SampleConductor extends Conductor {
    private SampleDataBuilder builder = new SampleDataBuilder();

    public SampleConductor(Context context) {
        super(context);
    }

    public void setData1(int data1) {
        builder.setData1(data1);
    }

    public void setData2(String data2) {
        builder.setData2(data2);
    }

    public void summit() {
        SampleDataBuilder.Out out = builder.build();
        if (out.getResult() == 0) {
            // 유효성 검사 성공, 빌드된 데이터를 보냄
            SampleRequestBody body = new SampleRequestBody(out.getData(), "asdf");
            // ...
        }
        else {
            // 유효성 검사 실패했음을 사용자에게 알림
        }
    }
}
