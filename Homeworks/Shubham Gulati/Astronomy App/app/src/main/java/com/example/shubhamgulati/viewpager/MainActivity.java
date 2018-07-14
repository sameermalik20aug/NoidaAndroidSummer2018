package com.example.shubhamgulati.viewpager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        vp.setAdapter(new Mypager(getSupportFragmentManager()));
        //TabLayout tb = findViewById(R.id.tb);
        //tb.setupWithViewPager(vp);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(vp);
    }

    private class Mypager extends FragmentPagerAdapter {

        public Mypager(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    FragmentA fragmentA = new FragmentA();
                    return fragmentA;
                case 1:
                    FragmentB fragmentB = new FragmentB();
                    return fragmentB;
                case 2:
                    FragmentC fragmentC = new FragmentC();
                    return fragmentC;

            }
            return null;

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Planets";
                case 1:
                    return "Stars";
                case 2:
                    return "Galaxy";
            }
            return "";
        }

        @Override
        public int getCount() {
            return 3;
        }


    }
}
