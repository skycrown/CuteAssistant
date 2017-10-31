package net.skycrown.cuteassistant.photo;

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

public class PhotoFragment extends BaseFragment {
    public static PhotoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_photo, container, false);
        return view;
    }
}
