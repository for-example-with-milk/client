package milk.example.platform.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import milk.example.platform.client.service.Service;
import milk.example.platform.client.service.subservice.Subservice;

public class ServiceDetailListAdapter extends BaseAdapter {
    private static final int SERVICE = 0;
    private static final int SUB = 1;
    private static final int OP_SIZE = 2;

    List<ListViewAll> listViewItemList;

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;

    @Override
    public int getViewTypeCount(){
        return OP_SIZE;
    }

    @Override
    public int getItemViewType(int i){
        return listViewItemList.get(i).getType();
    }





    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public ListViewAll getItem(int i) {
        return listViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        int viewType = getItemViewType(i);

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            ListViewAll listviewItem = listViewItemList.get(i);

            switch(viewType){
                case SERVICE:
                    view = inflater.inflate(R.layout.service_detail,viewGroup,false);
                    ImageView icon = (ImageView)view.findViewById(R.id.imageView3);
                    TextView tag = (TextView)view.findViewById(R.id.category);
                    TextView name = (TextView)view.findViewById(R.id.service_name);
                    TextView lore = (TextView)view.findViewById(R.id.service_explain);
                    TextView city = (TextView)view.findViewById(R.id.service_area);
                    TextView account = (TextView)view.findViewById(R.id.service_account);

                    //icon.setImageResource(listViewItemList.get(i).getIcoUrl());
                    tag.setText(listViewItemList.get(i).getCategoryList());
                    name.setText(listViewItemList.get(i).getName());
                    lore.setText(listViewItemList.get(i).getLore());
                    city.setText(listViewItemList.get(i).getCity());
                    account.setText(listViewItemList.get(i).getAccount());

                    break;

                case SUB:
                    view = inflater.inflate(R.layout.u_subservice_item,viewGroup,false);
                    TextView s_name = (TextView)view.findViewById(R.id.name);
                    TextView price = (TextView)view.findViewById(R.id.price);
                    TextView pay_period = (TextView)view.findViewById(R.id.pay_period);
                    TextView explain = (TextView)view.findViewById(R.id.explain);
                    TextView serv_type = (TextView)view.findViewById(R.id.serv_type);

                    s_name.setText(listViewItemList.get(i).getS_name());
                    price.setText(listViewItemList.get(i).getName());
                    pay_period.setText(listViewItemList.get(i).getLore());
                    explain.setText(listViewItemList.get(i).getCity());
                    serv_type.setText(listViewItemList.get(i).getAccount());

                    break;

            }




        }

        return view;
    }



}
