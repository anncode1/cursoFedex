package com.anncode.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.anncode.fragments.adapters.PagerAdapter;
import com.anncode.fragments.fragments.CustomListFragment;
import com.anncode.fragments.fragments.OtroFragment;
import com.anncode.fragments.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new OtroFragment());
        fragments.add(new CustomListFragment());
        fragments.add(new RecyclerViewFragment());

        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), fragments));

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.simple_task);
        tabLayout.getTabAt(1).setIcon(R.drawable.custom_list);
        tabLayout.getTabAt(2).setIcon(R.drawable.recyclerview_list);


    }

}
