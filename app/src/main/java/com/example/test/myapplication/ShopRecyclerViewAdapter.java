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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static com.example.test.myapplication.R.layout.card_layout_shop;

public class ShopRecyclerViewAdapter extends RecyclerView.Adapter<ShopRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "ShopRecyclerViewAdapter";

    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<String> mButton = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private Context mContext;

    public ShopRecyclerViewAdapter(ArrayList<String> image,ArrayList<String> title, ArrayList<String> description, ArrayList<String> price, ArrayList<String> button, Context context) {
        this.mTitle = title;
        this.mDescription = description;
        this.mPrice = price;
        this.mButton = button;
        this.mImage = image;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_shop, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.image_failed);

        Glide.with(mContext)
                .load(mImage.get(position))
                .apply(requestOptions)
                .into(holder.image);
        holder.title.setText(mTitle.get(position));
        holder.description.setText(mDescription.get(position));
        holder.price.setText(mPrice.get(position));
        holder.button.setText(mButton.get(position));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                ProdusFragment myFragment = new ProdusFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, myFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        TextView description;
        TextView price;
        Button button;


        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.cardImage_Shop);
            this.title = itemView.findViewById(R.id.cardTitle_Shop);
            this.description = itemView.findViewById(R.id.cardDescription_Shop);
            this.price = itemView.findViewById(R.id.cardPriceShop);
            this.button = itemView.findViewById(R.id.jucatori_disponibili);
        }
    }
}
