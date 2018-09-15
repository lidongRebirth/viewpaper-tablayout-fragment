package com.example.administrator.viewpapertab;


import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private ViewPager viewPager;
    private   TabLayout tableLayout;

    ViewPaperAdapter viewPaperAdapter;
    List<Fragment> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpaper);
        tableLayout = findViewById(R.id.tablayout);
        tableLayout.addTab(tableLayout.newTab());
        tableLayout.addTab(tableLayout.newTab());
        tableLayout.setupWithViewPager(viewPager);//和viewpaper
        tableLayout.addOnTabSelectedListener(this);

        list.add(new Fragment1());
        list.add(new Fragment2());
        viewPaperAdapter = new ViewPaperAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(viewPaperAdapter);
        viewPager.setCurrentItem(0);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        updateTabTextView(tab, true);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        updateTabTextView(tab, false);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    private void updateTabTextView(TabLayout.Tab tab, boolean isSelect) {       //选中时文字加粗用的
        if (isSelect) {
            try {
                java.lang.reflect.Field fieldView = tab.getClass().getDeclaredField("mView");
                fieldView.setAccessible(true);
                View view = (View) fieldView.get(tab);
                java.lang.reflect.Field fieldTxt = view.getClass().getDeclaredField("mTextView");
                fieldTxt.setAccessible(true);
                TextView tabSelect = (TextView) fieldTxt.get(view);
                tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                tabSelect.setText(tab.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                java.lang.reflect.Field fieldView = tab.getClass().getDeclaredField("mView");
                fieldView.setAccessible(true);
                View view = (View) fieldView.get(tab);
                java.lang.reflect.Field fieldTxt = view.getClass().getDeclaredField("mTextView");
                fieldTxt.setAccessible(true);
                TextView tabSelect = (TextView) fieldTxt.get(view);
                tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tabSelect.setText(tab.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
