package milk.example.platform.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import milk.example.platform.client.R;
import milk.example.platform.client.service.TotalService;

public class TotalServiceListAdapter extends BaseAdapter {
    private static final int SURVICE = 0;
    private static final int SUB = 1;
    private static final int OP_SIZE = 2;

    List<TotalService> totalServiceList;
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;

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
                    //서비스 정보를 하위서비스 클래스에 대애애충 담아와서 보여주기만 할랬는데 어트리뷰트 모자람...
                    ImageView icon = (ImageView)view.findViewById(R.id.imageView3);
                    TextView tag = (TextView)view.findViewById(R.id.category);
                    TextView name = (TextView)view.findViewById(R.id.service_name);
                    TextView explain = (TextView)view.findViewById(R.id.service_explain);
                    TextView area = (TextView)view.findViewById(R.id.service_area);
                    TextView account = (TextView)view.findViewById(R.id.service_account);


                    tag.setText(listviewItem.getCategoryList());
                    name.setText(listviewItem.getName());
                    explain.setText(listviewItem.getLore());
                    area.setText(listviewItem.getCity());
                    account.setText(listviewItem.getAccount());
                    break;


                case SUB:
                    view = inflater.inflate(R.layout.u_subservice_item,viewGroup,false);

                    TextView s_name = (TextView)view.findViewById(R.id.name);
                    TextView price = (TextView)view.findViewById(R.id.price);
                    TextView pay_period = (TextView)view.findViewById(R.id.pay_period);
                    TextView s_explain = (TextView)view.findViewById(R.id.explain);
                    TextView type = (TextView)view.findViewById(R.id.serv_type);
                    Button apply_btn = (Button)view.findViewById(R.id.button8);
                    apply_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(mContext, "신청버튼 클릭",Toast.LENGTH_SHORT).show();

                        }
                    });


                    s_name.setText(listviewItem.getS_name());
                    price.setText(listviewItem.getForm().getServicePrice());
                    pay_period.setText(listviewItem.getIsRegularPayment());
                    s_explain.setText(listviewItem.getS_lore());
                    type.setText(listviewItem.getForm().getIsPurchase());
                    
                    break;

            }
            
        }
        return view;
    }

    //서비스 상세
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

        //콜백함수가 해주니까 이부분은 통째로 삭제해도 댈듯//
    }

}
