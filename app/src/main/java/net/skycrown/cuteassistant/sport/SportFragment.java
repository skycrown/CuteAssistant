package net.skycrown.cuteassistant.sport;

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

public class SportFragment extends BaseFragment {
    public static SportFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SportFragment fragment = new SportFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_sport, container, false);
        return view;
    }
}
