package administrator.example.com.myscrollview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by yuer on 2016/6/1.
 */
public class VerticalAdapter extends  VerticalPagerAdapter {
    int num[] = new int[]{R.drawable.a1};
    Activity activity;
    VerticalAdapter(Activity activity){
    this.activity = activity;
    }

    @Override
    public int getCount() {
        return num.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
       View view =  activity.getLayoutInflater().inflate(R.layout.item_test_hair_viewpage,null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv_page);
//        iv.setBackgroundResource(num[position]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"点击"+position,Toast.LENGTH_LONG).show();


            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
