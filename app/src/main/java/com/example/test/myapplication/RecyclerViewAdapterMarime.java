package com.example.test.myapplication;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class RecyclerViewAdapterMarime extends RecyclerView.Adapter<RecyclerViewAdapterMarime.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapterMari";

//    vars
    private ArrayList<String> mNames = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapterMarime(ArrayList<String> mNames, Context mContext) {
        this.mNames = mNames;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem_produs, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        holder.name.setText(mNames.get(position));

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on an name: " + mNames.get(position));
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
       TextView name;

       public ViewHolder(View itemView) {
           super(itemView);
           name = itemView.findViewById(R.id.text_recycle_marime);
       }
   }
}