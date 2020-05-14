package com.lyf.scrollflagsdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.lyf.scrollflagsdemo.android.AndroidFragment;
import com.lyf.scrollflagsdemo.flutter.FlutterFragment;
import com.lyf.scrollflagsdemo.kotlin.KotlinFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(myPagerAdapter);
        viewPager.setOffscreenPageLimit(fragments.size());

//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragment() {
        fragments.add(AndroidFragment.newInstance("Android", ""));
        fragments.add(KotlinFragment.newInstance("Kotlin", ""));
        fragments.add(FlutterFragment.newInstance("Flutter", ""));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Android";
                case 1:
                    return "Kotlin";
                case 2:
                    return "Flutter";

            }
            return super.getPageTitle(position);
        }
    }
}
