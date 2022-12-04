package milk.example.platform.client.builder;

import lombok.Getter;
import milk.example.platform.client.LoginAccount;

public class ServiceDataBuilder {
    private String name;
    private String lore;

    @Getter
    public class Data {
        private String name;
        private String icoUrl;
        private String lore;
        private String city;
        private String categoryList;
        private String account;

        public Data(String name, String icoUrl, String lore, String city, String categoryList, String account) {
            this.name = name;
            this.icoUrl = icoUrl;
            this.lore = lore;
            this.city = city;
            this.categoryList = categoryList;
            this.account = account;
        }
    }

    @Getter
    public class Out {
        private ServiceDataBuilder.Data data;
        private int result;

        public Out(ServiceDataBuilder.Data data, int result) {
            this.data = data;
            this.result = result;
        }
    }

    private int validate() {
        if (name.length() == 0)
            return 1; // 너무 짧은 서비스 이름

        return 0;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceDataBuilder.Out build() {
        int result = validate();

        if (result == 0)
            return new ServiceDataBuilder.Out(new ServiceDataBuilder.Data(name, "url", lore, "대구", "운동", LoginAccount.getInstance().getId()), result);
        return new ServiceDataBuilder.Out(null, result);
    }
}
