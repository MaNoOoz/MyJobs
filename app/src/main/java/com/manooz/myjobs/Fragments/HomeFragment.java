package com.manooz.myjobs.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manooz.jobs_search_engine_material.R;

/**
 * Created by MaNoOoz on 2/19/2018.
 */

public class HomeFragment extends Fragment
//          implements WebsiteAdapter.websiteCallback
{


    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
//    private WebsiteAdapter websiteAdapter;
    private Button fab;

//    ========================================================== Lifecycle ========================================================================

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.main_fragment, container, false);
        setHasOptionsMenu(true);

//        websiteAdapter = new WebsiteAdapter();
//
//        recyclerView = (RecyclerView) view.findViewById(R.id.mRv_WebIcons);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(websiteAdapter);



        return view;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    //    ========================================================== Callback ========================================================================

//    @Override
//    public void onEdit(Website website) {
//        showAddEditDialog(website);
//
//    }

    //    ========================================================== My Methods ========================================================================


//    private void showAddEditDialog(final Website website) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setIcon(R.drawable.search);
//        builder.setTitle(getString(website == null ? R.string.dialog_add_title : R.string.dialog_edit_title));
//        View dialogView = getLayoutInflater().inflate(R.layout.add_new_website_dialog, null, false);
//        builder.setView(dialogView);
//
//
//        final EditText inputType = (EditText) dialogView.findViewById(R.id.website_name);
//        final EditText inputType2 = (EditText) dialogView.findViewById(R.id.website_desc);
//        final ImageView webIcon = dialogView.findViewById(R.id.add_icon);
//
//        if (website != null) {
//            // pre-populate
//            inputType.setText(website.getWebsiteName());
//            inputType2.setText(website.getWebsiteDisc());
//            webIcon.setImageDrawable(getResources().getDrawable(R.drawable.like));
//            TextWatcher textWatcher = new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                    // empty
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//                    // empty
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String titleT = inputType.getText().toString();
//                    String descN = inputType2.getText().toString();
////                    websiteAdapter.firebaseUpdate(website, titleT, descN);
//
//
//                }
//            };
//
//
//            inputType.addTextChangedListener(textWatcher);
//            inputType2.addTextChangedListener(textWatcher);
//
//        }
//
//        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (website == null) {
//                    String lt = inputType.getText().toString();
//                    String ld = inputType2.getText().toString();
//
//
////                    String ld = nameEt.getText().toString();
//                    // TODO: 12/9/2018
////                    websiteAdapter.firebasePush(new Website(lt, ld, ld,R.drawable.ic_add));
//                }
//
//
//            }
//        });
//        builder.setNegativeButton(android.R.string.cancel, null);
//        builder.create().show();
//    }
}
