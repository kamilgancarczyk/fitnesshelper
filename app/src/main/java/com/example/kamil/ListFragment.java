package com.example.kamil;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamil.fitnesshelper.R;

public class ListFragment extends Fragment {

    public View view (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        Context context = getContext();

        ListAdapter listAdapter = new ListAdapter(context);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}

