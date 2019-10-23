package com.example.test.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;


public class CustomListAdapterClasament extends ArrayAdapter<CardClasament> {
    private static final String TAG = "CustomListAdapterClasam";
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView loc;
        ImageView img_club;
        TextView nume_club;
        TextView mj_echipa;
        TextView pct_echipa;
        TextView gm_echipa;
        TextView gp_echipa;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapterClasament(Context context, int resource, ArrayList<CardClasament> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

        //sets up the image loader library
        setupImageLoader();
    }

    @SuppressLint("LongLogTag")
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the persons information
        String loc = getItem(position).getLoc();
        String img_club = getItem(position).getImg_club();
        String nume_club = getItem(position).getNume_club();
        String mj_echipa = getItem(position).getMj_echipa();
        String pct_echipa = getItem(position).getPct_echipa();
        String gm_echipa = getItem(position).getGm_echipa();
        String gp_echipa = getItem(position).getGp_echipa();


        try{


            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.loc = (TextView) convertView.findViewById(R.id.loc);
                holder.img_club= (ImageView) convertView.findViewById(R.id.img_club);
                holder.nume_club = (TextView) convertView.findViewById(R.id.nume_club);
                holder.mj_echipa = (TextView) convertView.findViewById(R.id.mj_echipa);
                holder.pct_echipa = (TextView) convertView.findViewById(R.id.pct_echipa);
                holder.gm_echipa = (TextView) convertView.findViewById(R.id.gm_echipa);
                holder.gp_echipa = (TextView) convertView.findViewById(R.id.gp_echipa);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

            lastPosition = position;

            holder.loc.setText(loc);
            holder.nume_club.setText(nume_club);
            holder.mj_echipa.setText(mj_echipa);
            holder.pct_echipa.setText(pct_echipa);
            holder.gm_echipa.setText(gm_echipa);
            holder.gp_echipa.setText(gp_echipa);




            //create the imageloader object
            ImageLoader imageLoader = ImageLoader.getInstance();

//            holder.buttonCumparaBilet.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view){
//
//                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                    BileteFragment myFragment = new BileteFragment();
//                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, myFragment).addToBackStack(null).commit();
//
//
//                }
//            });

            int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed",null,mContext.getPackageName());

            //create display options
            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();

            //download and display image from url
            imageLoader.displayImage(img_club, holder.img_club, options,new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                }
                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                }
                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }}

            );

            return convertView;
        }catch (IllegalArgumentException e){
            Log.e(TAG, "getView: IllegalArgumentException: " + e.getMessage() );
            return convertView;
        }

    }

    /**
     * Required for setting up the Universal Image loader Library
     */
    private void setupImageLoader(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}