package administrator.example.com.myscrollview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuer on 2016/6/1.
 */
public class VerticalAdapter extends  VerticalPagerAdapter{
    ArrayList<View> arrayList = new ArrayList<>();
    Activity activity;
    private int mChildCount;
    VerticalAdapter(Activity activity,ArrayList<View> arrayList){
    this.activity = activity;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        if(arrayList == null){
                return  0;
        }else{
            return arrayList.size();
        }
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
   public void addViewToAdapter(ArrayList<View> viewList){
            arrayList = viewList;
   }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ViewGroup parent = (ViewGroup)arrayList.get(position).getParent();
        if (parent != null) {
            parent.removeAllViews();
        }
        container.addView(arrayList.get(position));
        return arrayList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = arrayList.get(position);
        container.removeView(view);
    }

    @Override

    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {  //重写这方法，强制adapter从新刷新数据,默认的不会强制去刷新数据的，默认值： POSITION_UNCHANGED
        if ( mChildCount > 0) {
            mChildCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }
}
