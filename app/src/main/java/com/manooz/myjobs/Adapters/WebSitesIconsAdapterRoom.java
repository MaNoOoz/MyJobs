//package com.manooz.myjobs.Adapters;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.manooz.jobs_search_engine_material.R;
//import com.manooz.myjobs.data.WebsiteModelRoom;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//public class WebSitesIconsAdapterRoom extends RecyclerView.Adapter<WebSitesIconsAdapterRoom.WebsiteHolder> {
//
//    private List<WebsiteModelRoom> websiteModelRoomList = new ArrayList<>();
//
//
//    class WebsiteHolder extends RecyclerView.ViewHolder {
//
//        private TextView titleTextView;
//        private TextView nameTextView;
//
//        public WebsiteHolder(@NonNull View itemView) {
//            super(itemView);
//            titleTextView = (TextView) itemView.findViewById(R.id.title_text);
//            nameTextView = (TextView) itemView.findViewById(R.id.name_text);
//
//        }
//    }
//
//    @NonNull
//    @Override
//    public WebsiteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.row_links, parent, false);
//
//        return new WebsiteHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull WebsiteHolder holder, int position) {
//        WebsiteModelRoom websiteModelRoom = websiteModelRoomList.get(position);
//        holder.nameTextView.setText(websiteModelRoom.getTitle());
//        holder.titleTextView.setText(websiteModelRoom.getDescription());
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return websiteModelRoomList.size();
//    }
//
//    public void setWebsites(List<WebsiteModelRoom> websiteModelRooms) {
//        this.websiteModelRoomList = websiteModelRooms;
//        notifyDataSetChanged();
//    }
//
//}
