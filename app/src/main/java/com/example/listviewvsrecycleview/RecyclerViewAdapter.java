package com.example.listviewvsrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric Tsang on 07/06/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<ListItemViewHolder>
{
    private final List<String> models;
    private final ListItemViewHolder.Listener listener;

    // constructors

    public RecyclerViewAdapter(ListItemViewHolder.Listener listener)
    {
        super();

        // initialize instance data
        this.listener = listener;
        this.models = new ArrayList<>();

        // add example data
        models.add("Item 00");models.add("Item 01");
        models.add("Item 02");models.add("Item 03");
        models.add("Item 04");models.add("Item 05");
        models.add("Item 06");models.add("Item 07");
        models.add("Item 08");models.add("Item 09");
        models.add("Item 10");models.add("Item 11");
        models.add("Item 12");models.add("Item 13");
        models.add("Item 14");models.add("Item 15");
        models.add("Item 16");models.add("Item 17");
        models.add("Item 18");models.add("Item 19");
        models.add("Item 20");models.add("Item 21");
        models.add("Item 22");models.add("Item 23");
        models.add("Item 24");models.add("Item 25");
        models.add("Item 26");models.add("Item 27");
        models.add("Item 28");models.add("Item 29");
    }

    // RecyclerView.Adapter<ContactListViewHolder>

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        // create a new view
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_example,parent,false);

        return new ListItemViewHolder(listItem,listener);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder,int position)
    {
        // get data from data set, and bind it with the view holder
        holder.setModel(models.get(position));
    }

    @Override
    public int getItemCount()
    {
        return models.size();
    }
}


































