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
public class SimpleFragment extends Fragment {
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
        mFlowLayout.setOnClickListener(v -> Toast.makeText(getActivity(), "FlowLayout Clicked", Toast.LENGTH_SHORT).show());
        mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv, mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
    }
}
