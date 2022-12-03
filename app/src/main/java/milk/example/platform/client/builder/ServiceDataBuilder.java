package milk.example.platform.client.builder;

import android.widget.Toast;

import lombok.*;

public class ServiceDataBuilder {
    private String name;
    private String lore;

    @Getter
    public class ServiceData {
        private String name;
        private String lore;

        public ServiceData(String name, String lore) {
            this.name = name;
            this.lore = lore;
        }
    }

    @Getter
    public class Out {
        private ServiceData data;
        private int result;

        public Out(ServiceData data, int result) {
            this.data = data;
            this.result = result;
        }

    }

    public int validate(String name, String lore) {

        if( (name.length() < 2) ) {
            return 1;
        }
        else if ((lore.length() < 2))
            return 1;

        return 0;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public Out build() {

        int result = validate(name,lore);

        if(result == 0)
            return new Out(new ServiceData(name,lore), result);
        return new Out(null, result);
    }



}
