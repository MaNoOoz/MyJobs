//package com.manooz.myjobs.Adapters;
//
//import android.content.ClipData;
//import android.content.ClipboardManager;
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.manooz.jobs_search_engine_material.R;
//import com.manooz.myjobs.Modles.Link_Object;
//import com.manooz.myjobs.Modles.Website;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class WebsiteAdapter extends RecyclerView.Adapter<WebsiteAdapter.ViewHolder> {
//
//    // TODO: 12/9/2018  Use FireStore Not Firebase !!
//
//    public Context context;
//    private FirebaseAuth mAuth;
//
//    private List<Website> websiteList;
//    private WebsiteAdapter.websiteCallback websiteCallback;
//
//
//    public WebsiteAdapter() {
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return websiteList.size();
//    }
//
//
//    @Override
//    public WebsiteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View fragmentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_web, parent, false);
//        return new ViewHolder(fragmentView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//    }
//
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView titleTextView;
//        private TextView nameTextView;
//        // My Test
//        private ImageButton sendBtn, shareBtn, editBtn, deletBtn;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            titleTextView = (TextView) itemView.findViewById(R.id.title_text);
//            nameTextView = (TextView) itemView.findViewById(R.id.name_text);
//            sendBtn = (ImageButton) itemView.findViewById(R.id.sendBtn);
//            shareBtn = (ImageButton) itemView.findViewById(R.id.share_btn);
//            editBtn = (ImageButton) itemView.findViewById(R.id.editBtn);
//            deletBtn = (ImageButton) itemView.findViewById(R.id.delete_btn);
//
//
//        }
//
//    }// End Of This Class
//
//    public interface websiteCallback {
//        public void onEdit(Website website);
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////    public WebsiteAdapter(websiteCallback callback, Context context) {
////        this.context = context;
////        websiteCallback = callback;
////        websiteList = new ArrayList<>();
////        // This Code For Save Links For EveryUser
////        mAuth = FirebaseAuth.getInstance();
////        if (mAuth.getCurrentUser() != null) {
////
//////            databaseReference = FirebaseDatabase.getInstance().getReference().child("Web_Icons").child(mAuth.getCurrentUser().getUid());
//////        databaseReference = FirebaseDatabase.getInstance().getReference().child("User_Links");
//////            databaseReference.addChildEventListener(new WebChildEventListener());
////
////        }
////    }
//
//
////    public void firebasePush(Website website) {
////
////        databaseReference.push().setValue(website);
////
//////        //TODO: Remove the next line(s) and use Firebase instead
//////        linkList.firebasePush(0, movieQuote);
//////        notifyDataSetChanged();
////
////    }
////
////    public void firebaseRemove(Website website) {
////
////        databaseReference.child(website.getKey()).removeValue();
//////
//////        //TODO: Remove the next line(s) and use Firebase instead
//////        linkList.firebaseRemove(movieQuote);
//////        notifyDataSetChanged();
////    }
////
////    public void firebaseUpdate(Website website, String title, String name) {
////
////
//////        //TODO: Remove the next line(s) and use Firebase instead
////        website.setWebsiteName(title);
////        website.setWebsiteDisc(name);
////        databaseReference.child(website.getKey()).setValue(website);
////
////        notifyDataSetChanged();
////    }
////
//
////
////class WebChildEventListener implements ChildEventListener {
////
////    @Override
////    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
////
////        Website website = dataSnapshot.getValue(Website.class);
////        website.setKey(dataSnapshot.getKey());
////        websiteList.add(0, website);
////        notifyDataSetChanged();
////    }
////
////    @Override
////    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
////        String key = dataSnapshot.getKey();
////        Website update_web = dataSnapshot.getValue(Website.class);
////        for (Website mq : websiteList) {
////            if (mq.getKey().equals(key)) {
////                mq.setValues(update_web);
////                notifyDataSetChanged();
////            }
////        }
////    }
////
////    @Override
////    public void onChildRemoved(DataSnapshot dataSnapshot) {
////
////        String key = dataSnapshot.getKey();
////
////        for (Website mq : websiteList) {
////            if (mq.getKey().equals(key)) {
////                websiteList.remove(mq);
////                notifyDataSetChanged();
////                return;
////            }
////        }
////    }
////
////    @Override
////    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
////
////    }
////
////    @Override
////    public void onCancelled(DatabaseError databaseError) {
////
////        Log.e("DATABASE ERROR", "onCancelled Method");
////    }
////} // End Of This Class
//
//
////@Override
////public void onBindViewHolder(final WebsiteAdapter.ViewHolder holder, final int position) {
////    final Website website = websiteList.get(position);
////    holder.titleTextView.setText(website.getWebsiteName());
////    holder.nameTextView.setText(website.getWebsiteDisc());
////
////    //https://developer.android.com/training/sharing/send.html
////    holder.sendBtn.setOnClickListener(new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
////            ClipData clip = ClipData.newPlainText("Your Link is Copied", holder.titleTextView.getText().toString());
////            clipboard.setPrimaryClip(clip);
////            String s = clip.toString();
////            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
//////            Toast.makeText(getActivity(), "Link_Object Copied To Clipboard", Toast.LENGTH_SHORT).show();
////            Log.d("on Click", "Clicked!!");
////        }
////    });
////    holder.shareBtn.setOnClickListener(new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            Intent sendIntent = new Intent();
////            sendIntent.setAction(Intent.ACTION_SEND);
////            sendIntent.putExtra(Intent.EXTRA_TEXT, holder.nameTextView.getText().toString());
////            sendIntent.setType("text/plain");
//////                context.startActivity(sendIntent);
////            context.startActivity(Intent.createChooser(sendIntent, "Share via "));
////
////
////        }
////    });
////    holder.editBtn.setOnClickListener(new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            websiteCallback.onEdit(website);
////        }
////    });
////    holder.deletBtn.setOnClickListener(new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            firebaseRemove(websiteList.get(position));
////        }
////    });
////
////
//////        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//////            @Override
//////            public boolean onLongClick(View v) {
//////                firebaseRemove(linkList.get(position));
////////                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
//////                return true;
//////            }
//////        });
////
////
////}