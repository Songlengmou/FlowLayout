package com.anningtex.flowlayout.three.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anningtex.flowlayout.R;
import com.anningtex.weight.FlowLayout;
import com.anningtex.weight.TagAdapter;
import com.anningtex.weight.TagFlowLayout;


/**
 * @author Administrator
 */
public class EventTestFragment extends Fragment {
    private TagFlowLayout mFlowLayout;
    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final LayoutInflater mInflater = LayoutInflater.from(getActivity());
        mFlowLayout = view.findViewById(R.id.id_flowLayout);
        //mFlowLayout.setMaxSelectCount(3);
        mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv, mFlowLayout, false);
                tv.setText(s);
                return tv;
            }

            @Override
            public boolean setSelected(int position, String s) {
                return s.equals("Android");
            }
        });

        mFlowLayout.setOnTagClickListener((view1, position, parent) -> {
            Toast.makeText(getActivity(), mVals[position], Toast.LENGTH_SHORT).show();
            //view.setVisibility(View.GONE);
            return true;
        });

        mFlowLayout.setOnSelectListener(selectPosSet -> getActivity().setTitle("choose:" + selectPosSet.toString()));
    }
}
