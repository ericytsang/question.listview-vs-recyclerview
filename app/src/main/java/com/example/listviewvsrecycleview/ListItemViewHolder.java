package com.example.listviewvsrecycleview;

import android.view.View;
import android.widget.TextView;

/**
 * ViewHolder for a RecyclerView, or ListView.
 *
 * Created by Eric Tsang on 07/06/2015.
 */
public class ListItemViewHolder extends ViewHolder implements View.OnClickListener
{
    // view references
    private final View rootView;
    private final TextView textView;
    private final Listener listener;

    // instance data
    private String model;

    // constructors

    public ListItemViewHolder(View itemView,Listener listener)
    {
        super(itemView);

        // initialize instance data
        this.rootView = itemView;
        this.listener = listener;

        // get handles to View objects
        this.textView = (TextView) itemView.findViewById(R.id.textview);

        // set listeners on views
        if(listener != null)
        {
            itemView.setOnClickListener(this);
        }
    }

    // public interface

    /**
     * sets the view holder's model, and updates the view holder's view to
     * present the new model.
     *
     * @param model reference to the new model to present.
     */
    public void setModel(String model)
    {
        this.model = model;

        // put the data in the views
        textView.setText(model);
    }

    /**
     * observers of this object must implement this interface in ordered to be
     * registered and notified.
     */
    public interface Listener
    {
        void onItemSelected(String model);
    }

    // ViewHolder

    @Override
    public View getView()
    {
        return rootView;
    }

    // View.OnClickListener

    @Override
    public void onClick(View view)
    {
        listener.onItemSelected(model);
    }
}
