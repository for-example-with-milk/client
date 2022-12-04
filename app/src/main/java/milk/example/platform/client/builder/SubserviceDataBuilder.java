package milk.example.platform.client.builder;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import lombok.Getter;
import lombok.Setter;

public class SubserviceDataBuilder {
    private String name;
    private int price;
    private String iconUrl;
    private String explain;
    private String year;
    private String month;
    private String week;

    @Getter
    public class Data{
        private String name;
        private int price;
        private String iconUrl;
        private String explain;
        private String year;
        private String month;
        private String week;

        public Data(String name, int price, String iconUrl,String explain, String year, String month,String week){
            this.name = name;
            this.price = price;
            this.iconUrl = iconUrl;
            this.explain = explain;
            this.year = year;
            this.month = month;
            this.week = week;
        }

    }


    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price){this.price = price;}
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
    public void setExplain(String explain) {
        this.explain = explain;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public void setWeek(String week) {
        this.week = week;
    }


}
