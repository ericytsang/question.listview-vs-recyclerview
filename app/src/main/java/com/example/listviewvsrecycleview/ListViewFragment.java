package com.example.listviewvsrecycleview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Eric Tsang on 07/06/2015.
 */
public class ListViewFragment extends TitledFragment implements AdapterView.OnItemClickListener
{
    // view references

    private ListView listView;

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
        View root = inflater.inflate(R.layout.fragment_listview,container,false);

        initializeViews(root);
        configureViews();

        return root;
    }

    @Override
    public int getTitleResId()
    {
        return R.string.listviewfragment_title;
    }

    // private interface

    private void initializeViews(View root)
    {
        listView = (ListView) root.findViewById(R.id.listview);
    }

    private void configureViews()
    {
        listView.setAdapter(new ListViewAdapter(getActivity()));
        listView.setOnItemClickListener(this);
    }

    // AdapterView.OnItemClickListener

    @Override
    public void onItemClick(AdapterView<?> adapterView,View view,int i,long l)
    {
        String item = (String) adapterView.getItemAtPosition(i);
        listener.onItemSelected(item);
    }
}
