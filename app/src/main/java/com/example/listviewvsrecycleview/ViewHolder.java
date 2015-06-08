package com.example.listviewvsrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Eric Tsang on 07/06/2015.
 */
public abstract class ViewHolder extends RecyclerView.ViewHolder
{
    public ViewHolder(View itemView)
    {
        super(itemView);
    }

    public abstract View getView();
}
