package milk.example.platform.client.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import milk.example.platform.client.R;
import milk.example.platform.client.activity.U_ApplicationPurchaseActivity;
import milk.example.platform.client.activity.U_My_ServiceListActivity;
import milk.example.platform.client.activity.UserMainActivity;
import milk.example.platform.client.conductor.ApplicationProductWriterConductor;
import milk.example.platform.client.conductor.Conductor;
import milk.example.platform.client.service.TotalService;

public class TotalServiceListAdapter extends BaseAdapter {
    private static final int SURVICE = 0;
    private static final int SUB = 1;
    private static final int OP_SIZE = 2;

    private List<TotalService> totalServiceList;
    private Context mContext = null;
    private LayoutInflater mLayoutInflater = null;
    private String subname;

    public TotalServiceListAdapter(Context context, List<TotalService> data){
        mContext = context;
        totalServiceList = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getViewTypeCount(){
        return OP_SIZE;
    }
    @Override
    public int getItemViewType(int i){
        return totalServiceList.get(i).getOp();
    }

    @Override
    public int getCount() {
        return totalServiceList.size();
    }

    @Override
    public TotalService getItem(int i) {
        return totalServiceList.get(i);
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
            TotalService listviewItem = totalServiceList.get(i);
            
            
            switch(viewType){
                case SURVICE:
                    view = inflater.inflate(R.layout.service_detail,viewGroup,false);

                    ImageView icon = (ImageView)view.findViewById(R.id.imageView3);
                    TextView tag = (TextView)view.findViewById(R.id.category);
                    TextView name = (TextView)view.findViewById(R.id.service_name);
                    TextView explain = (TextView)view.findViewById(R.id.service_explain);
                    TextView area = (TextView)view.findViewById(R.id.service_area);

                    tag.setText(listviewItem.getCategoryList());
                    name.setText(listviewItem.getName());
                    explain.setText(listviewItem.getLore());
                    area.setText(listviewItem.getCity());

                    subname = listviewItem.getName();

                    break;
                case SUB:
                    view = inflater.inflate(R.layout.u_subservice_item,viewGroup,false);

                    TextView sname = view.findViewById(R.id.name);
                    TextView slore = view.findViewById(R.id.explain);
                    TextView speriod = view.findViewById(R.id.pay_period);

                    sname.setText(listviewItem.getS_name());
                    slore.setText(listviewItem.getS_lore());
                    if (listviewItem.getIsRegularPayment() == 1)
                        speriod.setText("??????");
                    else
                        speriod.setText("??????");

                    Button button = view.findViewById(R.id.button8);
                    button.setOnClickListener(v -> {
                        ApplicationProductWriterConductor conductor = new ApplicationProductWriterConductor(mContext, listviewItem.getS_id(), subname, listviewItem.getForm());
                        Conductor.save(conductor);

                        Intent intent = new Intent(mContext, U_ApplicationPurchaseActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    });

                    break;
            }
            
        }
        return view;
    }

    //????????? ??????
    public void addItem(String icon,String tag, String name, String explain,String area,String account){
        TotalService item = new TotalService();
        item.setOp(SURVICE);
        item.setCategoryList(tag);
        item.setName(name);
        item.setLore(explain);
        item.setCity(area);
        item.setAccount(account);

        totalServiceList.add(item);
    }

    public void addItem(short type, String name,int price, short pay_period,String explain){
        TotalService item = new TotalService();
        item.setOp(SUB);
        item.getForm().setIsPurchase(type);
        item.setS_name(name);
        item.getForm().setServicePrice(price);
        item.setIsRegularPayment(pay_period);
        item.setS_lore(explain);

        totalServiceList.add(item);

        //??????????????? ???????????? ???????????? ????????? ???????????? ??????//
    }

}
