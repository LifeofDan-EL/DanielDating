package com.danielanomfueme.danieldating;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielanomfueme.danieldating.Util.Users;
import com.danielanomfueme.danieldating.models.User;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    //Constants
    private static final int NUM_COLUMNS =2;

    //Widgets
    private RecyclerView mRecyclerView;

    //Vars
    private ArrayList<User> mMatches = new ArrayList<>();
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private MainRecyclerViewAdapter mMainRecyclerViewAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container , false);
        Log.d(TAG, "OnCreateView: started");
        mRecyclerView = view.findViewById(R.id.recycler_view);

        findMatches();

        return view;
    }
            //Retrives a list of users by referencing the user class
    private void findMatches() {
        Users users = new Users();
        if (mMatches != null){
            mMatches.clear();
        }
        for (User user : users.USERS){
            mMatches.add(user);
        }
        if (mMainRecyclerViewAdapter == null) {
            initRecyclerView();
        }
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        mMainRecyclerViewAdapter = new MainRecyclerViewAdapter(getActivity(), mMatches);
        mRecyclerView.setAdapter(mMainRecyclerViewAdapter);

    }

}

