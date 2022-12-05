package milk.example.platform.client.builder;

import lombok.Getter;
import milk.example.platform.client.LoginAccount;

public class ServiceDataBuilder {
    private String name;
    private String icoUrl;
    private String lore;
    private String city;
    private String categoryList;
    private String baccount;
    private String account;

    @Getter
    public class Data {
        private String name;
        private String icoUrl;
        private String lore;
        private String city;
        private String categoryList;
        private String baccount;  // 계좌
        private String account;  // 로그인계정

        public Data(String name, String icoUrl, String lore, String city, String categoryList, String baccount, String account) {
            this.name = name;
            this.icoUrl = icoUrl;
            this.lore = lore;
            this.city = city;
            this.categoryList = categoryList;
            this.baccount = baccount;
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
        //이름
        if ((name.length() < 2) || (name.length() > 20))
            return 1;
        //설명
        else if(categoryList.length() < 1)
            return 2;
        //계좌
        else if(baccount.length() < 1)
            return 3;
        //지역
        else if(city.length() < 1)
            return 4;
        //카테고리
        else if((lore.length() < 1) || (lore.length() > 1024))
            return 5;

        return 0;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcoUrl(String icoUrl){
        this.icoUrl = icoUrl;
    }

    public void setBaccount(String baccount){
        this.baccount = baccount;
    }

    public void setCategoryList(String categoryList){
        this.categoryList = categoryList;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ServiceDataBuilder.Out build() {
        int result = validate();

        if (result == 0)
            return new ServiceDataBuilder.Out(new ServiceDataBuilder.Data(name, icoUrl, lore, city, categoryList, baccount, LoginAccount.getInstance().getId()), result);
        return new ServiceDataBuilder.Out(null, result);
    }
}
