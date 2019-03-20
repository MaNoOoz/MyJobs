package com.manooz.myjobs.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.manooz.jobs_search_engine_material.R;


/**
 * Created by MaNoOoz on 11/30/2017.
 */

public class ProfileFragment extends Fragment {


    public ProfileFragment() {
//        setArguments(new Bundle());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //inflate View
        final View view = inflater.inflate(R.layout.activity_about, container, false);
        setHasOptionsMenu(true);


        return view;

    }//onCreateView End

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.start, menu);

    }

    //http://tutorialsbuzz.com/2015/11/android-filter-recyclerview-using-searchview-in-toolbar.html
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_search) {
            Toast.makeText(getActivity(), "Soon", Toast.LENGTH_SHORT).show();

        }

        return true;


    }
}
