package com.dql.g150t.fyhs.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 发现
 */
public class DiscoveryFragment extends BaseFragment {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();


    @Override
    public void init() {
        titles.add("热门活动");
        titles.add("平台公告");

        fragments.add(new NewDeatilFragment());
        fragments.add(new PlatformAnnouncementFragment());
        viewPager.setOffscreenPageLimit(fragments.size());
        viewPager.setAdapter(new DiscoveryFragmentAdapter(getFragmentManager()));
        tabs.setupWithViewPager(viewPager);

        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {

            }

            @Override
            public void rightClick() {

            }
        });
    }

    private class DiscoveryFragmentAdapter extends FragmentPagerAdapter{

        public DiscoveryFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    @Override
    public int getFragmentId() {
        return R.layout.fragment_discovery;
    }

    @Override
    public Object bindFragment() {
        return this;
    }

}
