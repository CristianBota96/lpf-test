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

public class DetaliiScorRecyclerViewAdapter extends RecyclerView.Adapter<DetaliiScorRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "DetaliiScorRecyclerView";

    private ArrayList<String> mTitle1 = new ArrayList<>();
    private ArrayList<String> mTitle2 = new ArrayList<>();
    private ArrayList<String> mScor1 = new ArrayList<>();
    private ArrayList<String> mScor2 = new ArrayList<>();
    private ArrayList<String> mImgScor1 = new ArrayList<>();
    private ArrayList<String> mImgScor2 = new ArrayList<>();
    private Context mContext;

    public DetaliiScorRecyclerViewAdapter(ArrayList<String> imgscor1, ArrayList<String> imgscor2, ArrayList<String> title1, ArrayList<String> title2, ArrayList<String> scor1, ArrayList<String> scor2, Context context) {
        this.mTitle1 = title1;
        this.mTitle2 = title2;
        this.mScor1 = scor1;
        this.mScor2 = scor2;
        this.mImgScor2 = imgscor2;
        this.mImgScor1 = imgscor1;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalii_scor, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
//        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.drawable.image_failed);

        Glide.with(mContext)
                .load(mImgScor1.get(position))
//                .apply(requestOptions)
                .into(holder.imgscor1);
        Glide.with(mContext)
                .load(mImgScor2.get(position))
//                .apply(requestOptions)
                .into(holder.imgscor2);

//        holder.imgscor1.setImageResource(Integer.parseInt(mImgScor1.get(position)));
//        holder.imgscor2.setImageResource(Integer.parseInt(mImgScor2.get(position)));

        holder.title1.setText(mTitle1.get(position));
        holder.title2.setText(mTitle2.get(position));
        holder.scor1.setText(mScor1.get(position));
        holder.scor2.setText(mScor2.get(position));

    }

    @Override
    public int getItemCount() {
        return mImgScor1.size();
    }

//    public int getItemCount2() {
//        return mImgScor2.size();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgscor1;
        ImageView imgscor2;
        TextView scor1;
        TextView scor2;
        TextView title1;
        TextView title2;


        public ViewHolder(View itemView) {
            super(itemView);
            this.imgscor1 = itemView.findViewById(R.id.scor_echipa1);
            this.imgscor2 = itemView.findViewById(R.id.scor_echipa2);
            this.title1 = itemView.findViewById(R.id.scor_title_echipa1);
            this.title2 = itemView.findViewById(R.id.scor_title_echipa2);
            this.scor1 = itemView.findViewById(R.id.scor_scor1);
            this.scor2 = itemView.findViewById(R.id.scor_scor2);
        }
    }
}
