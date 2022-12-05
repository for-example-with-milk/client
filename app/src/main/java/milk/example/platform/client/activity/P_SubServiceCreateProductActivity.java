package milk.example.platform.client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import milk.example.platform.client.R;
import milk.example.platform.client.builder.SubserviceProductDataBuilder;
import milk.example.platform.client.conductor.Conductor;
import milk.example.platform.client.conductor.SubserviceBuilderProductConductor;

public class P_SubServiceCreateProductActivity extends AppCompatActivity {

    private SubserviceBuilderProductConductor conductor;

    private ArrayList<Data> datas = new ArrayList<>();
    private ImageView back;
    private ImageView home;
    private ListView prods;
    private Button add;
    private Button confirm;

    private EditText name;
    private EditText lore;
    private CheckBox regular;

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_create_new_product);

        conductor = (SubserviceBuilderProductConductor) Conductor.load();
        conductor.setActivity(this);

        name = findViewById(R.id.sub_name);
        lore = findViewById(R.id.sub_lore);
        regular = findViewById(R.id.is_regular);

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        prods = findViewById(R.id.prod_list);
        add = findViewById(R.id.prod_add);
        confirm = findViewById(R.id.prod_confirm);

        adapter = new Adapter(getApplicationContext(), datas);
        prods.setAdapter(adapter);

        back.setOnClickListener(view -> finish());
        home.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(P_SubServiceCreateProductActivity.this, ProviderMainActivity.class);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(serviceIntent);
            finish();
        });

        add.setOnClickListener(view -> {
            datas.add(new Data("새 물품", "", 100));
            adapter.notifyDataSetChanged();
        });

        confirm.setOnClickListener(view -> {
            ArrayList<SubserviceProductDataBuilder.Data.FormElement> elements = new ArrayList<>();
            for (int i = 0; i < datas.size(); i++) {
                elements.add(new SubserviceProductDataBuilder.Data.FormElement(i, datas.get(i).getName(), datas.get(i).getLore(), datas.get(i).getPrice()));
            }

            conductor.setSubservice(new SubserviceProductDataBuilder.Data.SubService(
                name.getText().toString(), lore.getText().toString(), regular.isChecked() ? 1 : 0
            ));
            conductor.setForm(new SubserviceProductDataBuilder.Data.Form(1, 0));
            conductor.setFormElements(elements);
            conductor.summit();
        });
    }
}

class Adapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<Data> sample;

    public Adapter(Context context, ArrayList<Data> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Data getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.new_product_element, null);

        EditText name = view.findViewById(R.id.prod_name);
        EditText lore = view.findViewById(R.id.prod_lore);
        EditText price = view.findViewById(R.id.prod_price);

        name.setText(sample.get(position).getName());
        lore.setText(sample.get(position).getLore());
        price.setText(sample.get(position).getPrice() + "");

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sample.get(position).setName(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        lore.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sample.get(position).setLore(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    sample.get(position).setPrice(Integer.valueOf(charSequence.toString()));
                }
                catch (Exception e) {
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        return view;
    }
}

@Getter
@Setter
class Data {
    private String name;
    private String lore;
    private int price;

    public Data(String name, String lore, int price) {
        this.name = name;
        this.lore = lore;
        this.price = price;
    }
}