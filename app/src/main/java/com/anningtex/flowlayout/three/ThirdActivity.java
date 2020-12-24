package com.anningtex.flowlayout.three;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.anningtex.flowlayout.R;
import com.anningtex.flowlayout.three.fragment.EventTestFragment;
import com.anningtex.flowlayout.three.fragment.GravityFragment;
import com.anningtex.flowlayout.three.fragment.LimitSelectedFragment;
import com.anningtex.flowlayout.three.fragment.ListViewTestFragment;
import com.anningtex.flowlayout.three.fragment.ScrollViewTestFragment;
import com.anningtex.flowlayout.three.fragment.SimpleFragment;
import com.anningtex.flowlayout.three.fragment.SingleChooseFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * @author Administrator
 */
public class ThirdActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    private String[] mTabTitles = new String[]
            {"MuLi Selected", "Limit 3", "Event Test", "ScrollView Test", "Single Choose", "Gravity", "ListView Sample"};
    private TabLayout mIdTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.id_viewpager);
        mIdTabLayout = findViewById(R.id.id_tabLayout);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i) {
                    case 0:
                        return new SimpleFragment();
                    case 1:
                        return new LimitSelectedFragment();
                    case 2:
                        return new EventTestFragment();
                    case 3:
                        return new ScrollViewTestFragment();
                    case 4:
                        return new SingleChooseFragment();
                    case 5:
                        return new GravityFragment();
                    case 6:
                        return new ListViewTestFragment();
                    default:
                        return new EventTestFragment();
                }
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTabTitles[position];
            }

            @Override
            public int getCount() {
                return mTabTitles.length;
            }
        });
        mIdTabLayout.setupWithViewPager(mViewPager);
    }
}