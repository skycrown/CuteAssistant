package net.skycrown.cuteassistant;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import net.skycrown.cuteassistant.account.AccountFragment;
import net.skycrown.cuteassistant.base.BaseActivity;
import net.skycrown.cuteassistant.base.BaseFragment;
import net.skycrown.cuteassistant.life.LifeQueryFragment;
import net.skycrown.cuteassistant.music.MusicFragment;
import net.skycrown.cuteassistant.photo.PhotoFragment;
import net.skycrown.cuteassistant.sport.SportFragment;

// 应用主界面

public class MainActivity extends BaseActivity {
    private static final int INDEX_MUSIC_PAGER = 0;
    private static final int INDEX_PHOTO_PAGER = 1;
    private static final int INDEX_SPORT_PAGER = 2;
    private static final int INDEX_LIFE_QUERY_PAGER = 3;
    private static final int INDEX_ACCOUNT_PAGER = 4;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    private int[] mTitleId = new int[]{R.string.music, R.string.photo, R.string.sport, R.string.life_query, R.string.account};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mViewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);


    }

    private void initEvent() {
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == mTabLayout.getTabAt(INDEX_MUSIC_PAGER)) {
                    // TODO: 2017/7/22  seticon change
                    mViewPager.setCurrentItem(INDEX_MUSIC_PAGER);
                } else if (tab == mTabLayout.getTabAt(INDEX_PHOTO_PAGER)) {
                    mViewPager.setCurrentItem(INDEX_PHOTO_PAGER);
                } else if (tab == mTabLayout.getTabAt(INDEX_SPORT_PAGER)) {
                    mViewPager.setCurrentItem(INDEX_SPORT_PAGER);
                } else if (tab == mTabLayout.getTabAt(INDEX_LIFE_QUERY_PAGER)) {
                    mViewPager.setCurrentItem(INDEX_LIFE_QUERY_PAGER);
                } else if (tab == mTabLayout.getTabAt(INDEX_ACCOUNT_PAGER)) {
                    mViewPager.setCurrentItem(INDEX_ACCOUNT_PAGER);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private class MainFragmentPagerAdapter extends FragmentPagerAdapter {
        public MainFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = null;
            switch (position) {
                case INDEX_MUSIC_PAGER:
                    fragment = MusicFragment.newInstance();
                    break;
                case INDEX_PHOTO_PAGER:
                    fragment = PhotoFragment.newInstance();
                    break;
                case INDEX_SPORT_PAGER:
                    fragment = SportFragment.newInstance();
                    break;
                case INDEX_LIFE_QUERY_PAGER:
                    fragment = LifeQueryFragment.newInstance();
                    break;
                case INDEX_ACCOUNT_PAGER:
                    fragment = AccountFragment.newInstance();
                    break;
                default:
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return mTitleId.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getText(mTitleId[position]);
        }
    }

}
