package com.manooz.myjobs;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.manooz.jobs_search_engine_material.R;


/**
 * Created by MaNoOoz on 11/30/2017.
 */

public class My_Links_Fragment extends android.support.v4.app.Fragment implements LinksAdapter.Callback {
    // Views
    private TextView textView;
    private FloatingActionButton fab;
    //    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    //For Auth only
    private FirebaseAuth fAuth;
    private String oldData;
    //Adapter
    private LinksAdapter linksAdapter;
// For firebaseDatabase
//    FirebaseDatabase database;
//    DatabaseReference myRef;
//    ChildEventListener mChildEventListener;


    public My_Links_Fragment() {
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
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        if (savedInstanceState==null){
////            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        }
        //inflate View
        final View view = inflater.inflate(R.layout.my_links_frragment, container, false);
        setHasOptionsMenu(true);

        //For delete later
        //todo
        linksAdapter = new LinksAdapter(this,getActivity());

//        sendbtn = (ImageButton) getActivity().findViewById(R.id.imageButton3);

//            frameLayout = (FrameLayout)itemView.findViewById(R.id.framLayout);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(linksAdapter);


        fab = (FloatingActionButton) view.findViewById(R.id.fab);

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


        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showAddEditDialog(null);
            }
        });
//        sendbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(getActivity(), "Hi", Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }

    //onViewCreated End here
    public void showAddEditDialog(final Link_Object link) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.search);
        builder.setTitle(getString(link == null ? R.string.dialog_add_title : R.string.dialog_edit_title));
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add, null, false);
        builder.setView(dialogView);


        final EditText inputType = (EditText) dialogView.findViewById(R.id.LinkName);
        final EditText inputType2 = (EditText) dialogView.findViewById(R.id.linkDesc);

        if (link != null) {
            // pre-populate
            inputType.setText(link.getlName());
            inputType2.setText(link.getlTitle());

            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // empty
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    // empty
                }

                @Override
                public void afterTextChanged(Editable s) {
                    String titleT = inputType.getText().toString();
                    String descN = inputType2.getText().toString();

                    linksAdapter.firebaseUpdate(link, titleT, descN);


                }
            };


            inputType.addTextChangedListener(textWatcher);
            inputType2.addTextChangedListener(textWatcher);

        }

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (link == null) {
                    String lt = inputType.getText().toString();
                    String ld = inputType2.getText().toString();


//                    String ld = nameEt.getText().toString();
                    linksAdapter.firebasePush(new Link_Object(lt, ld, ld));
                }


            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.create().show();
    }

//
//    @Override
//    public void onPause() {
//        super.onPause();
//
//    }
//    @Override
//    public void onStop() {
//        super.onStop();
//    }
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//    }
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//    }

    @Override
    public void onEdit(Link_Object linkObject) {
        showAddEditDialog(linkObject);

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
