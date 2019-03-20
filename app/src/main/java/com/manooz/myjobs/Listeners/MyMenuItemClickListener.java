package com.manooz.myjobs.Listeners;

import android.content.Context;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.manooz.jobs_search_engine_material.R;

/**
 * Created by MaNoOoz on 1/24/2018.
 */

class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

    private Context mContext;

    public MyMenuItemClickListener() {
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_search:
                Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                return true;
//            case R.id.:
//                Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
        }
        return false;
    }

}
