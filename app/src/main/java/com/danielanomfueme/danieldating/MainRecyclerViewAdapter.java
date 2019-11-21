package com.danielanomfueme.danieldating;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import com.danielanomfueme.danieldating.models.User;


public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MainRecyclerViewAd";

    //vars
    private ArrayList<User> mUsers = new ArrayList<>();
    private Context mContext;


    public MainRecyclerViewAdapter(Context context, ArrayList<User> users) {
        mContext = context;
        mUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main_feed, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override  //Adds Data to List Item Widget
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);


        //Glide Library to set the image to the ImageView widget
        Glide.with(mContext)
                .load(mUsers.get(position).getProfile_image())
                .apply(requestOptions)
                .into(holder.image);

        holder.name.setText(mUsers.get(position).getName());
        holder.interested_in.setText(mUsers.get(position).getInterested_in());
        holder.status.setText(mUsers.get(position).getStatus());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mUsers.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }




        //View Holder Class that saves the individual list items in memory and feeds it to the view
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView interested_in;
        TextView status;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            interested_in = itemView.findViewById(R.id.interested_in);
            status = itemView.findViewById(R.id.status);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}






