package com.immran.materialone;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.immran.fragments.FirstFragment;
import com.immran.fragments.SecondFragment;
import com.immran.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
//    FloatingActionButton fabButton;
    TabLayout mTabLayout;
    CharSequence Titles[]={"Home","Events","Home","Events","Home","Events"};
    int Numboftabs =6;
    ViewPager viewPager;
    SlidingTabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);
        viewPager.setAdapter(adapter);
//        setTablayout();

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(android.R.color.white);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(viewPager);

    }
//    private void setTablayout() {
//        mTabLayout=(TabLayout)findViewById(R.id.tablayout);
//        mTabLayout.setHorizontalScrollBarEnabled(true);
//        mTabLayout.setupWithViewPager(viewPager);
//        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }


    private void setToolbar() {
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.abc_ic_voice_search_api_mtrl_alpha);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
//        if(v.getId()==R.id.fab_button){
//
//            Snackbar.make(v,"Hurray",Snackbar.LENGTH_SHORT).setAction("Action",this).show();
//        }
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter
    {
        CharSequence Titles[];
        int numoftabs;

        public ViewPagerAdapter(FragmentManager manager, CharSequence cs[],int tabs) {
            super(manager);
            this.Titles=cs;
            this.numoftabs=tabs;
        }

        @Override
        public Fragment getItem(int position) {
            if(position ==0){
                FirstFragment ff= new FirstFragment();
                return ff;
            }else if (position == 1) {
                    SecondFragment secondFragment = new SecondFragment();
                    return secondFragment;
                }
            else {
                return new FirstFragment();
            }
        }

        @Override
        public int getCount() {
            return numoftabs;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return Titles[position];
        }
    }


}
