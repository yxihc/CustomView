package io.github.hexiangyuan.sharedelementtransitionsdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import io.github.hexiangyuan.sharedelementtransitionsdemo.R;

/**
 * Creator:HeXiangYuan
 * Date  : 17-2-28
 */

public class FragmentC extends DialogFragment {
    public static final String TAG = FragmentC.class.getSimpleName();
    private View mInflate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflate = inflater.inflate(R.layout.fragment_c, container, false);
        return mInflate;
    }

    public static FragmentC newInstance() {
        return new FragmentC();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Fragment fragment = getChildFragmentManager().findFragmentByTag(FragmentA.class.getName());
        if (fragment == null) {
            fragment = FragmentA.newInstance();
            getChildFragmentManager().beginTransaction().add(R.id.activity_main,
                    fragment,
                    FragmentA.class.getName())
                    .commit();
        }

    }
}
