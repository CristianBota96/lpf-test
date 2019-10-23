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


public class CustomListAdapterCalendar extends ArrayAdapter<CardCalendar> {

    private static final String TAG = "CustomListAdapterCalendar";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView etapaCalendar;
        TextView ligaCalendar;
        ImageView imgURLCalendar1;
        ImageView imgURLCalendar2;
        Button buttonCumparaBilet;
        TextView dataCalendar;
        TextView acasaCalendar;
        TextView acasaEchipaCalendar;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapterCalendar(Context context, int resource, ArrayList<CardCalendar> objects) {
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
        String etapaCalendar = getItem(position).getEtapaCalendar();
        String ligaCalendar = getItem(position).getLigaCalendar();
        String imgURLCalendar1 = getItem(position).getImgURLCalendar1();
        String imgURLCalendar2 = getItem(position).getImgURLCalendar2();
        String buttonCumparaBilet = getItem(position).getbuttonCumparaBilet();
        String dataCalendar = getItem(position).getDataCalendar();
        String acasaCalendar = getItem(position).getAcasaCalendar();
        String acasaEchipaCalendar = getItem(position).getAcasaEchipaCalendar();


        try{


            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.etapaCalendar = (TextView) convertView.findViewById(R.id.etapa);
                holder.ligaCalendar= (TextView) convertView.findViewById(R.id.liga);
                holder.imgURLCalendar1 = (ImageView) convertView.findViewById(R.id.cardImage_echipa1);
                holder.imgURLCalendar2 = (ImageView) convertView.findViewById(R.id.cardImage_echipa2);
                holder.buttonCumparaBilet = (Button) convertView.findViewById(R.id.cumpara_bilet);
                holder.dataCalendar = (TextView) convertView.findViewById(R.id.date);
                holder.acasaCalendar = (TextView) convertView.findViewById(R.id.acasa);
                holder.acasaEchipaCalendar = (TextView) convertView.findViewById(R.id.acasa_echipa);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

            lastPosition = position;

            holder.etapaCalendar.setText(etapaCalendar);
            holder.ligaCalendar.setText(ligaCalendar);
            holder.dataCalendar.setText(dataCalendar);
            holder.acasaCalendar.setText(acasaCalendar);
            holder.acasaEchipaCalendar.setText(acasaEchipaCalendar);
            holder.buttonCumparaBilet.setText(buttonCumparaBilet);




            //create the imageloader object
            ImageLoader imageLoader = ImageLoader.getInstance();

            holder.buttonCumparaBilet.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view){

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    BileteFragment myFragment = new BileteFragment();
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
            imageLoader.displayImage(imgURLCalendar1, holder.imgURLCalendar1, options,new ImageLoadingListener() {
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
            imageLoader.displayImage(imgURLCalendar2, holder.imgURLCalendar2, options,new ImageLoadingListener() {
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