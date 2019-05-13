package com.gyf.immersionbar.simple.fragment.three;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.simple.R;

import butterknife.BindView;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class MineThreeFragment extends BaseThreeFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), toolbar);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_one_mine;
    }

}
