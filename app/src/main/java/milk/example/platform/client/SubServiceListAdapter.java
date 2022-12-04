package milk.example.platform.client;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import milk.example.platform.client.service.subservice.Subservice;

public class SubServiceListAdapter extends BaseAdapter {
    private static final int SURVICE = 0;
    private static final int SUB = 1;
    private static final int OP_SIZE = 2;

    List<Subservice> subserviceList;
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;

    public SubServiceListAdapter() {

    }

    public SubServiceListAdapter(Context context, List<Subservice> data){
        mContext = context;
        subserviceList = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getViewTypeCount(){
        return OP_SIZE;
    }
    @Override
    public int getItemViewType(int i){
        return subserviceList.get(i).getType();
    }

    @Override
    public int getCount() {
        return subserviceList.size();
    }

    @Override
    public Subservice getItem(int i) {
        return subserviceList.get(i);
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
            Subservice listviewItem = subserviceList.get(i);
            
            
            switch(viewType){
                case SURVICE:
                    view = inflater.inflate(R.layout.service_detail,viewGroup,false);
                    //서비스 정보를 하위서비스 클래스에 대애애충 담아와서 보여주기만 할랬는데 어트리뷰트 모자람...
                    ImageView icon = (ImageView)view.findViewById(R.id.imageView3);
                    TextView tag = (TextView)view.findViewById(R.id.category);
                    TextView s_name = (TextView)view.findViewById(R.id.service_name);
                    TextView s_explain = (TextView)view.findViewById(R.id.service_explain);
                    TextView area = (TextView)view.findViewById(R.id.service_area);
                    TextView acount = (TextView)view.findViewById(R.id.service_account);


                    tag.setText(listviewItem.getForm().getIsPurchase());
                    s_name.setText(listviewItem.getName());
                    area.setText(listviewItem.getForm().getServicePrice());
                    acount.setText(listviewItem.getIsRegularPayment());
                    s_explain.setText(listviewItem.getLore());

                    break;


                case SUB:
                    view = inflater.inflate(R.layout.u_subservice_item,viewGroup,false);

                    TextView name = (TextView)view.findViewById(R.id.name);
                    TextView price = (TextView)view.findViewById(R.id.price);
                    TextView pay_period = (TextView)view.findViewById(R.id.pay_period);
                    TextView explain = (TextView)view.findViewById(R.id.explain);
                    TextView type = (TextView)view.findViewById(R.id.serv_type);

                    type.setText(listviewItem.getForm().getIsPurchase());
                    name.setText(listviewItem.getName());
                    price.setText(listviewItem.getForm().getServicePrice());
                    pay_period.setText(listviewItem.getIsRegularPayment());
                    explain.setText(listviewItem.getLore());
                    
                    break;

            }
            
        }
        return view;
    }

    //서비스 상세
    public void addItem(String icon,String tag, String name, String explain,String area,String account){
        Subservice item = new Subservice();
        item.setType(SURVICE);


        subserviceList.add(item);
    }
    public void addItem(String type, String name,String price, String pay_period,String explain){
        Subservice item = new Subservice();


        //콜백함수가 해주니까 이부분은 통째로 삭제해도 댈듯//
    }

}
