package administrator.example.com.myscrollview;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    VerticalViewPager verticalViewPager;
    VerticalAdapter verticalAdapter;
    ArrayList<View> arrayList = new ArrayList<>();  //存储要显示的页面，就是page的每一个adapter
    private View fristView;
    private View secondView;
    private View threeView;
    private Button button;
    private Button button2;
    int num[] = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fristView = getLayoutInflater().inflate(R.layout.item_test_hair_viewpage, null);
        secondView = getLayoutInflater().inflate(R.layout.item_test_hair_viewpage,null);
        threeView = getLayoutInflater().inflate(R.layout.item_test_hair_viewpage,null);
        arrayList.add(fristView);

//        arrayList.add(fristView);
//        arrayList.add(fristView);
        verticalViewPager = (VerticalViewPager) findViewById(R.id.vertyPager1);
        verticalViewPager.setAdapter(verticalAdapter = new VerticalAdapter(this, arrayList));
        button = (Button) fristView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSecondView();
            }
        });
        button2 = (Button) secondView.findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addThridView();
            }
        });
    }
    private void addThridView(){
        arrayList.add(threeView);
        verticalAdapter.addViewToAdapter(arrayList);
        verticalAdapter.notifyDataSetChanged();
        verticalViewPager.setCurrentItem(arrayList.size());
    }
    private void addSecondView() {
        arrayList.add(secondView);
        verticalAdapter.addViewToAdapter(arrayList);
        verticalAdapter.notifyDataSetChanged();     //这个方法在自己实现的adapter里进行了从写，因为默认的notifyDataSetChanged是不能刷新的adapter的
        verticalViewPager.setCurrentItem(arrayList.size());
    }

}
