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


public class CustomListAdapterDetaliiScor extends ArrayAdapter<CardDetaliiScor> {

    private static final String TAG = "CustomListAdapterDetali";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView title, subtitle, scor1, scor2, titlu_echipa1, titlu_echipa2;
        TextView jucatorechipa1, jucatorechipa2;
        ImageView imgScor1, imgScor2, imgbackground;
        ImageView imgmijloc;

    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapterDetaliiScor(Context context, int resource, ArrayList<CardDetaliiScor> objects) {
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
//        String scor1 = getItem(position).getScor1();
//        String scor2 = getItem(position).getScor2();
//        String titlu_echipa1 = getItem(position).getTitlu_echipa1();
//        String titlu_echipa2 = getItem(position).getTitlu_echipa2();
//        String imgScor1 = getItem(position).getImgscor1();
//        String imgScor2 = getItem(position).getImgscor2();

        //get Jucatori information
        String jucatorechipa1 = getItem(position).getJucatoriechipa1();
        String jucatorechipa2 = getItem(position).getJucatoriechipa2();
        String imgmijloc = getItem(position).getImgmijloc();



        try{


            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
//                holder.imgScor1 = (ImageView) convertView.findViewById(R.id.scor_echipa1);
//                holder.imgScor2 = (ImageView) convertView.findViewById(R.id.scor_echipa2);
//                holder.titlu_echipa1 = (TextView) convertView.findViewById(R.id.scor_title_echipa1);
//                holder.scor1 = (TextView) convertView.findViewById(R.id.scor_scor1);
//                holder.scor2 = (TextView) convertView.findViewById(R.id.scor_scor2);
//                holder.titlu_echipa2 = (TextView) convertView.findViewById(R.id.scor_title_echipa2);

                //Jucatori
                holder.jucatorechipa1 = (TextView) convertView.findViewById(R.id.gol_echipa1);
                holder.jucatorechipa2 = (TextView) convertView.findViewById(R.id.gol_echipa2);
                holder.imgmijloc = (ImageView) convertView.findViewById(R.id.gol);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

            lastPosition = position;

//            holder.titlu_echipa1.setText(titlu_echipa1);
//            holder.scor1.setText(scor1);
//            holder.scor2.setText(scor2);
//            holder.titlu_echipa2.setText(titlu_echipa2);

            //Jucatori
            holder.jucatorechipa1.setText(jucatorechipa1);
            holder.jucatorechipa2.setText(jucatorechipa2);


            //create the imageloader object
            ImageLoader imageLoader = ImageLoader.getInstance();


            int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed",null,mContext.getPackageName());

            //create display options
            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();

            //download and display image from url
//            imageLoader.displayImage(imgScor1, holder.imgScor1, options,new ImageLoadingListener() {
//                @Override
//                public void onLoadingStarted(String imageUri, View view) {
//                }
//                @Override
//                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//
//                }
//                @Override
//                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//
//                }
//                @Override
//                public void onLoadingCancelled(String imageUri, View view) {
//
//                }}
//
//            );
//            imageLoader.displayImage(imgScor2, holder.imgScor2, options,new ImageLoadingListener() {
//                @Override
//                public void onLoadingStarted(String imageUri, View view) {
//
//                }
//                @Override
//                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//
//                }
//                @Override
//                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//
//                }
//                @Override
//                public void onLoadingCancelled(String imageUri, View view) {
//
//                }}
//
//            );
            imageLoader.displayImage(imgmijloc, holder.imgmijloc, options,new ImageLoadingListener() {
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