package com.example.administrator.viewpapertab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class ViewPaperAdapter extends FragmentStatePagerAdapter {

    List<Fragment> list=new ArrayList<>();
    Fragment1 fragment1 =new Fragment1();
    Fragment2 fragment2 = new Fragment2();
    private FragmentManager fragmetnmanager;  //创建FragmentManager
    private List<String>mTitles=new ArrayList<>();

    public ViewPaperAdapter(FragmentManager fm, List<Fragment>list) {
        super(fm);
        this.fragmetnmanager = fm;
        this.list = list;
        mTitles.add("标题一");
        mTitles.add("标题二");

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {        //用来设置TabLayout标题的
        return mTitles.get(position);
    }
}
