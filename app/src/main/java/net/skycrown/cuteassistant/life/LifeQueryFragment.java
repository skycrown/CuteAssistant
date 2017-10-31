package net.skycrown.cuteassistant.life;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.skycrown.cuteassistant.R;
import net.skycrown.cuteassistant.base.BaseFragment;

/**
 * @author skycrown
 */

public class LifeQueryFragment extends BaseFragment {
    public static LifeQueryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LifeQueryFragment fragment = new LifeQueryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_life_query, container, false);
        return view;
    }
}
