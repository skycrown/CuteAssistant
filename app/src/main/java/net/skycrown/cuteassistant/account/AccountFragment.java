package net.skycrown.cuteassistant.account;

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

public class AccountFragment extends BaseFragment {
    public static AccountFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_account, container, false);
        return view;
    }
}
