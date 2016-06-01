package administrator.example.com.myscrollview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    VerticalViewPager verticalViewPager;
    VerticalAdapter verticalAdapter;
    int num[] = new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verticalViewPager = (VerticalViewPager) findViewById(R.id.vertyPager1);
        verticalViewPager.setAdapter(verticalAdapter = new VerticalAdapter(this));


        View view = getLayoutInflater().inflate(R.layout.item_test_hair_viewpage,null);
        for (int i = 0 ; i<num.length;i++){
            verticalViewPager.addNewItem(i,i,view);
        }
        verticalAdapter.notifyDataSetChanged();
        verticalViewPager.dataSetChanged();
    }
}
