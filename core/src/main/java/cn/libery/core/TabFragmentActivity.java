package cn.libery.core;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.lzh.compiler.parceler.annotation.Arg;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Libery on 2016/12/22.
 * Email:libery.szq@qq.com
 */

public class TabFragmentActivity extends BaseActivity {

    @BindView(R2.id.tab_layout)
    TabLayout mTabs;
    @BindView(R2.id.view_pager)
    ViewPager mViewpager;
    private static final String PLACE_HOLDER = ",";
    private static final String PARAM_HOLDER = ":";
    @Arg
    ArrayList<String> tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.core_tab_fragment_activity);
        setupViewPager(mViewpager);
        mTabs.setupWithViewPager(mViewpager);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        if (tabs == null) return;
        for (int i = 0; i < tabs.size(); i++) {
            createFragment(tabs.get(i), adapter);
        }
        viewPager.setAdapter(adapter);
    }

    private void createFragment(final String params, Adapter adapter) {
        try {
            if (params.contains(PLACE_HOLDER)) {
                String[] contents = params.split(PLACE_HOLDER);
                Bundle args = new Bundle();
                Fragment fragment = (Fragment) Class.forName(contents[0]).newInstance();
                int length = contents.length;
                if (length > 2) {
                    for (int i = 1; i < length; i++) {
                        String s = contents[i];
                        if (s.contains(PARAM_HOLDER)) {
                            String[] x = s.split(PARAM_HOLDER);
                            Log.e("param", x[0] + "&&" + x[1]);
                            args.putString(x[0], x[1]);
                        }
                    }
                }
                fragment.setArguments(args);
                adapter.addFragment(fragment, contents[1]);

            } else {
                Fragment fragment = (Fragment) Class.forName(params).newInstance();
                adapter.addFragment(fragment, params);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        Adapter(FragmentManager fm) {
            super(fm);
        }

        void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}
