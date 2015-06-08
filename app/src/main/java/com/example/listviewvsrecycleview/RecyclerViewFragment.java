package com.example.listviewvsrecycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Eric Tsang on 07/06/2015.
 */
public class RecyclerViewFragment extends TitledFragment
{
    // view references

    private RecyclerView recyclerView;

    // instance data

    /**
     * reference to the class's observer.
     */
    private ListItemViewHolder.Listener listener;

    // TitledFragment

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        listener = (ListItemViewHolder.Listener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        initializeViews(root);
        configureViews();

        return root;
    }

    @Override
    public int getTitleResId()
    {
        return R.string.recycleviewfragment_title;
    }

    // private interface

    private void initializeViews(View root)
    {
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
    }

    private void configureViews()
    {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(listener));
    }
}
