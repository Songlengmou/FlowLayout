package com.anningtex.flowlayout.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anningtex.flowlayout.R;
import com.anningtex.weight.FlowLayout;
import com.anningtex.weight.TagAdapter;
import com.anningtex.weight.TagFlowLayout;

import java.util.ArrayList;

/**
 * @author Administrator
 */
public class SecondActivity extends AppCompatActivity {
    private TagFlowLayout flowLayout;
    private ArrayList<String> city = new ArrayList<>();
    private TagAdapter<String> mAdapterFive;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        flowLayout = findViewById(R.id.flowLayout);
        city.add("1");
        city.add("2");
        city.add("3");
        city.add("哥谭市");
        city.add("纽约");
        city.add("一叶知秋");
        city.add("该换行了");

        mAdapterFive = new TagAdapter<String>(city) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                tv = new TextView(SecondActivity.this);
                tv.setTextSize(13);
                tv.setPadding(34, 18, 34, 18);
                tv.setBackgroundResource(R.drawable.tag);
                tv.setText(s);
                return tv;
            }
        };
        flowLayout.setAdapter(mAdapterFive);
        flowLayout.setOnTagClickListener((view, position, parent) -> {
            Toast.makeText(SecondActivity.this, city.get(position), Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}