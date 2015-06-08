package com.example.listviewvsrecycleview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ListItemViewHolder.Listener
{
    // View references

    /**
     * dialog displayed when a list item in either the ListView, or RecyclerView
     * is clicked.
     */
    private AlertDialog alertDialog;

    /**
     * used to display the tabs used by the viewPager.
     */
    private TabLayout tabLayout;

    /**
     * this is where all the fragments in this activity goes. the viewPager lets
     * one swipe left and right between the fragments provided by its adapter.
     */
    private ViewPager viewPager;

    // AppCompatActivity

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        configureViews();
    }

    // ListItemViewHolder.Listener

    @Override
    public void onItemSelected(String model)
    {
        alertDialog.setMessage(model);
        alertDialog.show();
    }

    // private interface

    private void initializeViews()
    {
        alertDialog = new AlertDialog.Builder(this).create();
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void configureViews()
    {
        // put the devices, conversations, and contacts fragments into the view
        // pager for sexy swiping UI
        viewPager.setAdapter(new MyFragmentPagerAdapter(this));

        // configure the tab layout to display the tabs of the viewPager
        tabLayout.setupWithViewPager(viewPager);
    }

    // MyFragmentPagerAdapter

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter
    {
        private List<TitledFragment> fragments;

        @Override
        public CharSequence getPageTitle(int position)
        {
            return getResources().getString(fragments.get(position).getTitleResId());
        }

        public MyFragmentPagerAdapter(AppCompatActivity c)
        {
            super(c.getSupportFragmentManager());

            // initialize instance data
            fragments = new ArrayList<>();

            // add fragments to the fragments list
            fragments.add(new ListViewFragment());
            fragments.add(new RecyclerViewFragment());
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragments.get(position);
        }

        @Override
        public int getCount()
        {
            return fragments.size();
        }
    }
}
