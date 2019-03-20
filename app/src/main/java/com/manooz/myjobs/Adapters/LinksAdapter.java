//package com.manooz.myjobs.Adapters;
//
//import android.content.ClipData;
//import android.content.ClipboardManager;
//import android.content.Context;
//import android.content.Intent;
//import androidx.recyclerview.widget.RecyclerView;
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
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by MaNoOoz on 1/1/2018.
// */
//
//public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.ViewHolder> {
//
//    public Context context;
//    private FirebaseAuth mAuth;
//    private DatabaseReference databaseReference;
//    private List<Link_Object> linkList;
//    private Callback mCallback;
//
//    public LinksAdapter(Callback callback, Context context) {
//        this.context = context;
//        mCallback = callback;
//        linkList = new ArrayList<>();
//        // This Code For Save Links For EveryUser
//        mAuth = FirebaseAuth.getInstance();
//        if (mAuth.getCurrentUser() != null) {
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("User_Links").child(mAuth.getCurrentUser().getUid());
////        databaseReference = FirebaseDatabase.getInstance().getReference().child("User_Links");
//            databaseReference.addChildEventListener(new LinkChildEventListener());
//        }
//    }
//
////    public LinksAdapter(View view) {
////
////    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View fragmentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_links, parent, false);
//        return new ViewHolder(fragmentView);
//    }
//
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        final Link_Object linkObject = linkList.get(position);
//        holder.titleTextView.setText(linkObject.getlName());
//        holder.nameTextView.setText(linkObject.getlTitle());
//
////https://developer.android.com/training/sharing/send.html
//        holder.sendBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
//                ClipData clip = ClipData.newPlainText("Your Link is Copied", holder.titleTextView.getText().toString());
//                clipboard.setPrimaryClip(clip);
//                String s = clip.toString();
//                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
////            Toast.makeText(getActivity(), "Link_Object Copied To Clipboard", Toast.LENGTH_SHORT).show();
//                Log.d("on Click", "Clicked!!");
//            }
//        });
//        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT, holder.nameTextView.getText().toString());
//                sendIntent.setType("text/plain");
////                context.startActivity(sendIntent);
//                context.startActivity(Intent.createChooser(sendIntent, "Share via "));
//
//
//            }
//        });
//
//        holder.editBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCallback.onEdit(linkObject);
//            }
//        });
//        holder.deletBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                firebaseRemove(linkList.get(position));
//            }
//        });
//
////        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
////            @Override
////            public boolean onLongClick(View v) {
////                firebaseRemove(linkList.get(position));
//////                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
////                return true;
////            }
////        });
//
//
//    }
//
//    /**
//     * Click listener for popup menu items
//     */
//
//    public void firebaseRemove(Link_Object movieQuote) {
//
//        databaseReference.child(movieQuote.getKey()).removeValue();
////
////        //TODO: Remove the next line(s) and use Firebase instead
////        linkList.firebaseRemove(movieQuote);
////        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getItemCount() {
//        return linkList.size();
//    }
//
//    public void firebasePush(Link_Object movieQuote) {
//
//        databaseReference.push().setValue(movieQuote);
//
////        //TODO: Remove the next line(s) and use Firebase instead
////        linkList.firebasePush(0, movieQuote);
////        notifyDataSetChanged();
//
//    }
//
//    public void firebaseUpdate(Link_Object link, String title, String name) {
//
//
////        //TODO: Remove the next line(s) and use Firebase instead
//        link.setlName(title);
//        link.setlTitle(name);
//        databaseReference.child(link.getKey()).setValue(link);
//
//        notifyDataSetChanged();
//    }
//
//    public interface Callback {
//        public void onEdit(Link_Object link_object);
//    }
//
//    class LinkChildEventListener implements ChildEventListener {
//
//        @Override
//        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
//            Link_Object myLink = dataSnapshot.getValue(Link_Object.class);
//            myLink.setKey(dataSnapshot.getKey());
//            linkList.add(0, myLink);
//            notifyDataSetChanged();
//        }
//
//        @Override
//        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//            String key = dataSnapshot.getKey();
//            Link_Object update_link_object = dataSnapshot.getValue(Link_Object.class);
//            for (Link_Object mq : linkList) {
//                if (mq.getKey().equals(key)) {
//                    mq.setValues(update_link_object);
//                    notifyDataSetChanged();
//                }
//            }
//        }
//
//        @Override
//        public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            String key = dataSnapshot.getKey();
//
//            for (Link_Object mq : linkList) {
//                if (mq.getKey().equals(key)) {
//                    linkList.remove(mq);
//                    notifyDataSetChanged();
//                    return;
//                }
//            }
//        }
//
//        @Override
//        public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//        }
//
//        @Override
//        public void onCancelled(DatabaseError databaseError) {
//
//            Log.e("DATABASE ERROR", "onCancelled Method");
//        }
//    } // End Of This Class
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
////
////    private void showPopupMenu(View v) {
////        // inflate menu
////        PopupMenu popup = new PopupMenu(context, v);
////        MenuInflater inflater = popup.getMenuInflater();
////        inflater.inflate(R.menu.start, popup.getMenu());
////        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
////        popup.show();
////    }
////
////    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
////        public MyMenuItemClickListener() {
////        }
////
////        @Override
////        public boolean onMenuItemClick(MenuItem menuItem) {
////            switch (menuItem.getItemId()) {
////                case R.id.action_search:
////                    Toast.makeText(context, "Add to favourite", Toast.LENGTH_SHORT).show();
////                    return true;
////
//////                case R.id.action_play_next:
//////                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
//////                    return true;
//////                default:
////            }
////            return false;
////        }
////    }
////
//}
