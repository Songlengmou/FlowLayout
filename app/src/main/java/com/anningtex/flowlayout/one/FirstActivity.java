package com.anningtex.flowlayout.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.anningtex.flowlayout.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class FirstActivity extends AppCompatActivity {
    private TagFlowLayout tagFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {
        tagFl = findViewById(R.id.tagFl);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            data.add("8023");
        }
        TagAdapter<String> adapter = new TagAdapter<String>(data) {
            @Override
            public View getView(FlowLayout parent, int position, String str) {
                TextView itemTag = (TextView) LayoutInflater.from(FirstActivity.this).inflate(R.layout.item_tag, parent, false);
                itemTag.setText(str);
                return itemTag;
            }
        };
        tagFl.setAdapter(adapter);

        tagFl.setOnTagClickListener((view, position, parent) -> {
            Log.e("666", "点击了tag:" + position);
            return false;
        });

        tagFl.setOnSelectListener(selectPosSet -> Log.e("666", "选中了tag:" + selectPosSet));
        //默认选中第一个
        adapter.setSelectedList(0);
    }
}