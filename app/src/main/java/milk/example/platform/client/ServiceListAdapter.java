package milk.example.platform.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import milk.example.platform.client.service.Service;

public class ServiceListAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    List<Service> service;
    
    public ServiceListAdapter(Context context,List<Service> data){
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
        View view = mLayoutInflater.inflate(R.layout.service_list_item,null);

        ImageView icon = (ImageView)view.findViewById(R.id.imageView2);
        TextView tag = (TextView)view.findViewById(R.id.categories);
        TextView name = (TextView)view.findViewById(R.id.serve_name);

        //icon.setImageResource(service.get(i).getIcoUrl());
        tag.setText(service.get(i).getCategoryList());
        name.setText(service.get(i).getName());

        return view;
    }
}
