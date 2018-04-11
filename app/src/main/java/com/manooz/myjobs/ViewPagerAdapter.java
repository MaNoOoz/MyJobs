package com.manooz.myjobs;

import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by MaNoOoz on 11/26/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    public ViewPagerAdapter(android.support.v4.app.FragmentManager fm ) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WebView_Fragment();
            case 1:
                return new My_Links_Fragment();
            case 2:
                return new My_Map_Fragment();
            default:
                return null;
        }
    }

//
//        switch (position) {
//            case 1:
//            return new WebView_Fragment();
//            case 2:
//                return new My_Links_Fragment();
//        }
//
//        return null;
//    }
//        } else return new Message_Fragment();

}

