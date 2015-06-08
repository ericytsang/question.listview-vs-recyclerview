package com.example.listviewvsrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Eric Tsang on 07/06/2015.
 */
public class ListViewAdapter extends ArrayAdapter<String>
{
    // constructors

    public ListViewAdapter(Context context)
    {
        super(context,R.layout.listitem_example);

        // add example data
        add("Item 00");add("Item 01");
        add("Item 02");add("Item 03");
        add("Item 04");add("Item 05");
        add("Item 06");add("Item 07");
        add("Item 08");add("Item 09");
        add("Item 10");add("Item 11");
        add("Item 12");add("Item 13");
        add("Item 14");add("Item 15");
        add("Item 16");add("Item 17");
        add("Item 18");add("Item 19");
        add("Item 20");add("Item 21");
        add("Item 22");add("Item 23");
        add("Item 24");add("Item 25");
        add("Item 26");add("Item 27");
        add("Item 28");add("Item 29");
    }

    // ArrayAdapter<String>

    @Override
    public View getView(int position,View convertView,ViewGroup parent)
    {
        // retrieve the view holder & creating one if needed
        ListItemViewHolder holder;
        if(convertView == null)
        {
            View listItem = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.listitem_example,parent,false);

            holder = new ListItemViewHolder(listItem,null);
            listItem.setTag(holder);
        }
        else
        {
            holder = (ListItemViewHolder) convertView.getTag();
        }

        // set the view holder's model
        holder.setModel(getItem(position));

        return holder.getView();
    }
}
