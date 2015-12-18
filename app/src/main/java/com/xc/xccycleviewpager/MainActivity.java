package com.xc.xccycleviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private XCCycleViewPager mCycleViewPager;
    private int[] mResIDs = new int[] {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c
    };
    private List<View> mViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewList = new ArrayList<>();
        for(int i = 0; i < mResIDs.length; i ++){
            View viewItem = LayoutInflater.from(this).inflate(R.layout.layout_viewpager_item,null);
            ((ImageView)((ViewGroup) viewItem).getChildAt(0)).setImageResource(mResIDs[i]);
            mViewList.add(viewItem);
        }
        mCycleViewPager = (XCCycleViewPager) findViewById(R.id.cvp_demo);
        mCycleViewPager.setAdapter(mCycylePagerAdapter);
    }
    private PagerAdapter mCycylePagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return mResIDs.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    } ;
}
