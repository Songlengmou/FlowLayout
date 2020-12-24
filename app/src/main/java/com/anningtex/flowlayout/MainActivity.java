package com.anningtex.flowlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.flowlayout.one.FirstActivity;
import com.anningtex.flowlayout.three.ThirdActivity;
import com.anningtex.flowlayout.two.SecondActivity;

/**
 * @author Administrator
 * desc: 流式布局：TagFlowLayout
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnOne, mBtnTwo, mBtnThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnOne = findViewById(R.id.btn_one);
        mBtnTwo = findViewById(R.id.btn_two);
        mBtnThree = findViewById(R.id.btn_three);
        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
        mBtnThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                break;
            default:
                break;
        }
    }
}