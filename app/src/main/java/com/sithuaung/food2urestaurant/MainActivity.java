package com.sithuaung.food2urestaurant;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class MainActivity extends ActionBarActivity implements MaterialTabListener {

    MaterialTabHost tabHost;
    ViewPager pager;
    ViewPagerAdapter adapter;
    public static MaterialBadgeTextView badge_new,badge_pending,badge_history;
    String [] tab_name= { "New "," Pending ", " History " };
    public static final String ROOT_URL = "https://baccivorous-servos.000webhostapp.com/";

    //Strings to bind with intent will be used to send data to other activity
    public static final String KEY_ORDER_ITEM = "key_order_item";
    public static final String KEY_AMOUNT = "key_amount";
    public static final String KEY_PRICE = "key_price";
    public static final String KEY_PICKUP_TIME = "key_pickup_time";
    public static final String KEY_PICKUP_BY = "key_pickup_by";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_back);

        Toolbar toolbar = (android.support.v7.widget.Toolbar) this.findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);
        pager = (ViewPager) this.findViewById(R.id.pager);

        badge_new=(MaterialBadgeTextView)this.findViewById(R.id.badge_notification_1);
        badge_pending=(MaterialBadgeTextView)this.findViewById(R.id.badge_notification_2);
        badge_history=(MaterialBadgeTextView)this.findViewById(R.id.badge_notification_3);


        // init view pager
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);


            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                changeColor(position);
            }
        });



        // insert all tabs from pagerAdapter data
        for (int i = 0; i < adapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setText(tab_name[i])
                            .setTabListener(this)
            );

        }

//        changeBadgeNumber();

    }


    @Override
    public void onTabSelected(MaterialTab tab) {
        pager.setCurrentItem(tab.getPosition());
        int pos= tab.getPosition();
        changeColor(pos);
    }

    private void changeColor(int pos) {
        switch (pos){
            case 0: {
                badge_new.setBackgroundColor(Color.parseColor("#f5e722"));
                badge_pending.setBackgroundColor(Color.parseColor("#fffde7"));
                badge_history.setBackgroundColor(Color.parseColor("#fffde7"));
//                badge_new.setText(String.valueOf(Fragment_New.getCount()));
//                badge_pending.setText(String.valueOf(Fragment_Pending.getCount()));
               // badge_history.setText(String.valueOf(Fragment_History.getCount()));

            } break;
            case 1: {
                badge_pending.setBackgroundColor(Color.parseColor("#f5e722"));
                badge_new.setBackgroundColor(Color.parseColor("#fffde7"));
                badge_history.setBackgroundColor(Color.parseColor("#fffde7"));

            } break;
            case 2: {
                badge_history.setBackgroundColor(Color.parseColor("#f5e722"));
                badge_pending.setBackgroundColor(Color.parseColor("#fffde7"));
                badge_new.setBackgroundColor(Color.parseColor("#fffde7"));

            } break;

        }
    }

    public void changeBadgeNumber() {

        int count1=Fragment_New.recycler_adapter.getItemCount();
        badge_new.setText(String.valueOf(count1));
        int count2=Fragment_Pending.recycler_adapter.getItemCount();
        badge_pending.setText(String.valueOf(count2));
        int count3=Fragment_History.recycler_adapter.getItemCount();
        badge_history.setText(String.valueOf(count3));

    }


    @Override
    public void onTabReselected(MaterialTab tab) {


    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        public Fragment getItem(int num) {
            if(num==0) return new Fragment_New();
            else if(num==1) return new Fragment_Pending();
            else return new Fragment_History();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Sec " + position;
        }

    }


}












//        mngr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        String device_ID= mngr.getDeviceId();

