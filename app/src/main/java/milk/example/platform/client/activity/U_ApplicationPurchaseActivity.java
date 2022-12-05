package milk.example.platform.client.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import milk.example.platform.client.R;
import milk.example.platform.client.conductor.ApplicationProductWriterConductor;
import milk.example.platform.client.conductor.Conductor;
import milk.example.platform.client.service.subservice.FormElement;

public class U_ApplicationPurchaseActivity extends AppCompatActivity {
    private ImageView back;
    private ImageView home;
    private TextView total_price;
    private ListView list_view;

    private PAdapter adapter;
    private ArrayList<PData> datas = new ArrayList<>();

    private ApplicationProductWriterConductor conductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_application_purchase);

        conductor = (ApplicationProductWriterConductor) Conductor.load();

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        total_price = findViewById(R.id.total_price);
        list_view = findViewById(R.id.item_list);

        adapter = new PAdapter(getApplicationContext(), datas);
        list_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //for (FormElement e : conductor.getForm().getFormElementList()) {

        //}

        back.setOnClickListener(view -> finish());
        home.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(U_ApplicationPurchaseActivity.this, UserMainActivity.class);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(serviceIntent);
            finish();
        });
    }
}

class PAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<PData> sample;

    public PAdapter(Context context, ArrayList<PData> data) {
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
    public PData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.new_product_element, null);

        TextView name = view.findViewById(R.id.item_name);
        TextView lore = view.findViewById(R.id.item_lore);
        TextView price = view.findViewById(R.id.item_price);
        TextView amount = view.findViewById(R.id.amount);
        ImageButton minus = view.findViewById(R.id.item_minus);
        ImageButton plus = view.findViewById(R.id.item_plus);

        name.setText(sample.get(position).getName());
        lore.setText(sample.get(position).getLore());
        price.setText(sample.get(position).getPrice() + "원");

        minus.setOnClickListener(v -> {
            int a = sample.get(position).getAmount();
            if (a != 0)
                a -= 1;
            sample.get(position).setAmount(a);
            amount.setText(a + "");
        });

        plus.setOnClickListener(v -> {
            int a = sample.get(position).getAmount();
            a += 1;
            sample.get(position).setAmount(a);
            amount.setText(a + "");
        });

        return view;
    }
}

@Getter
@Setter
class PData {
    private String name;
    private String lore;
    private int price;
    private int amount = 0;

    public PData(String name, String lore, int price) {
        this.name = name;
        this.lore = lore;
        this.price = price;
    }
}