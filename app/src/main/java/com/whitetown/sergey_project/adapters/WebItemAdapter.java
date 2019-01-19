package com.whitetown.sergey_project.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whitetown.sergey_project.R;
import com.whitetown.sergey_project.model.WebItem;

public class WebItemAdapter extends RecyclerView.Adapter<WebItemAdapter.MyViewHolder>
{
    private final OnItemClickListener listener;
    private WebItem[] mDataset;


    // Provide a suitable constructor (depends on the kind of dataset)
    public WebItemAdapter(WebItem[] myDataset, OnItemClickListener listener)
    {
        mDataset = myDataset;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WebItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType)
    {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position].getTitle());
        holder.mTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(holder.mTextView.getContext().getDrawable(mDataset[position].getIconId()), null, null, null);
        holder.mTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listener.onItemClick(mDataset[position]);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount()
    {
        return mDataset.length;
    }

    public interface OnItemClickListener
    {
        void onItemClick(WebItem item);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        // each data item is just a string in this case
        public TextView mTextView;

        public MyViewHolder(TextView v)
        {
            super(v);
            mTextView = v;
        }
    }
}