package com.example.test.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class StatisticiRecyclerViewAdapter extends RecyclerView.Adapter<StatisticiRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "StatisticiRecyclerViewA";

    private ArrayList<String> mJucator1 = new ArrayList<>();
    private ArrayList<String> mJucator2 = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private Context mContext;

    public StatisticiRecyclerViewAdapter(ArrayList<String> jucator1, ArrayList<String> image, ArrayList<String> jucator2, Context context) {
        this.mJucator1 = jucator1;
        this.mJucator2 = jucator2;
        this.mImage = image;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_scorstatistici, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

//        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.drawable.image_failed);

        Glide.with(mContext)
                .load(mImage.get(position))
//                .apply(requestOptions)
                .into(holder.image);
        holder.jucator2.setText(mJucator1.get(position));
        holder.jucator1.setText(mJucator2.get(position));


    }

    @Override
    public int getItemCount() {
        return mImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView jucator1;
        ImageView image;
        TextView jucator2;


        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.gol);
            jucator1 = itemView.findViewById(R.id.gol_echipa1);
            jucator2 = itemView.findViewById(R.id.gol_echipa2);
        }
    }
}
