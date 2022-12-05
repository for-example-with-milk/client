package milk.example.platform.client.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import milk.example.platform.client.R;
import milk.example.platform.client.activity.P_SubServiceCreateProductActivity;
import milk.example.platform.client.activity.U_My_ServiceListActivity;
import milk.example.platform.client.activity.UserMainActivity;
import milk.example.platform.client.conductor.Conductor;
import milk.example.platform.client.conductor.SubserviceBuilderProductConductor;
import milk.example.platform.client.service.Service;

public class ProvServiceListAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    List<Service> service;

    public ProvServiceListAdapter(Context context, List<Service> data){
        mContext = context;
        service = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return service.size();
    }

    @Override
    public Service getItem(int i) {
        return service.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View mView, ViewGroup viewGroup) {
        View view = mLayoutInflater.inflate(R.layout.service_list_item2,null);

        //ImageView icon = (ImageView)view.findViewById(R.id.imageView2);
        TextView tag = (TextView)view.findViewById(R.id.categories);
        TextView name = (TextView)view.findViewById(R.id.serve_name);
        ImageView add = view.findViewById(R.id.add_sub_button);

        //icon.setImageResource(service.get(i).getIcoUrl());
        tag.setText(service.get(i).getCategoryList());
        name.setText(service.get(i).getName());

        add.setOnClickListener(v -> {
            SubserviceBuilderProductConductor conductor = new SubserviceBuilderProductConductor(mContext, service.get(i).getId().intValue());
            Conductor.save(conductor);

            Intent serviceIntent = new Intent(mContext, P_SubServiceCreateProductActivity.class);
            serviceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(serviceIntent);
        });

        return view;
    }
}
