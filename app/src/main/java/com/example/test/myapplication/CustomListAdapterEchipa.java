package com.example.test.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
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


public class CustomListAdapterEchipa extends ArrayAdapter<CardEchipa> {

    private static final String TAG = "CustomListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView numar;
        TextView nume;
        ImageView imgJucator;
        TextView tara;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapterEchipa(Context context, int resource, ArrayList<CardEchipa> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

        //sets up the image loader library
        setupImageLoader();

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the persons information
        String numar = getItem(position).getNumar();
        String nume = getItem(position).getNume();
        String imgJucator = getItem(position).getImgJucator();
        String tara = getItem(position).getTara();


        try{


            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.numar = (TextView) convertView.findViewById(R.id.numar);
                holder.nume = (TextView) convertView.findViewById(R.id.nume_jucator);
                holder.imgJucator = (ImageView) convertView.findViewById(R.id.img_jucator);
                holder.tara = (TextView) convertView.findViewById(R.id.tara);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }


            lastPosition = position;

            holder.numar.setText(numar);
            holder.nume.setText(nume);
            holder.tara.setText(tara);

            //create the imageloader object
            ImageLoader imageLoader = ImageLoader.getInstance();

            holder.imgJucator.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view){

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    JucatorFragment myFragment = new JucatorFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, myFragment).addToBackStack(null).commit();


                }
            });

            int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed",null,mContext.getPackageName());

            //create display options
            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();

            //download and display image from url
            imageLoader.displayImage(imgJucator, holder.imgJucator, options,new ImageLoadingListener() {
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