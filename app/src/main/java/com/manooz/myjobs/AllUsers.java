//package com.manooz.myjobs;
//
//import android.os.Bundle;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;
//import com.manooz.jobs_search_engine_material.R;
//import com.manooz.myjobs.Modles.Users;
//
//public class AllUsers extends AppCompatActivity {
//
//    //    https://stackoverflow.com/questions/48254655/firebaserecycleradapter-getitemcount-0
//    // // TODO: 1/17/2018
//    private DatabaseReference databaseReference;
//    private RecyclerView recyclerView;
//    private FirebaseRecyclerAdapter<Users, UserViewHolder> adapter;
//
//    //    UserViewHolder holder;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_all_users);
//        recyclerView = (RecyclerView) findViewById(R.id.User_List);
//
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//        Query query = FirebaseDatabase.getInstance().getReference().child("users");
//        FirebaseRecyclerOptions<Users> options =
//                new FirebaseRecyclerOptions.Builder<Users>()
//                        .setQuery(query, Users.class)
//                        .build();
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                Users users = dataSnapshot.getValue(Users.class);
//                String name = dataSnapshot.child("Users").getValue() + "";
//
//
//                Toast.makeText(AllUsers.this, users.getName() + " ", Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//        adapter = new FirebaseRecyclerAdapter<Users, UserViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull UserViewHolder holder, int position, @NonNull Users model) {
//
//                holder.userTitle.setText(model.getName());
//
//
//            }
//
//            @Override
//            public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.user_row, parent, false);
//
//                return new UserViewHolder(view);
//
//            }
//
//        };
//
//
//        recyclerView.setAdapter(adapter);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.startListening();
//    }
//
//
//}
//
//class UserViewHolder extends RecyclerView.ViewHolder {
//
//    View mview;
//    TextView userTitle;
//
//    public UserViewHolder(View itemView) {
//        super(itemView);
//        mview = itemView;
//        userTitle = mview.findViewById(R.id.user_name_row);
//    }
//}
//
//
