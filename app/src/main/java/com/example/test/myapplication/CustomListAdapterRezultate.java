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


public class CustomListAdapterRezultate extends ArrayAdapter<CardRezultate> {

    private static final String TAG = "CustomListAdapterRezultate";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView etapaRezultate;
        TextView ligaRezultate;
        ImageView imgURLRezultate1;
        ImageView imgURLRezultate2;
        ImageView card_rezultate;
        Button buttonStatistici;
        TextView dataRezultate;
        TextView acasaRezultate;
        TextView acasaEchipaRezultate;
        TextView scor1;
        TextView scor2;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapterRezultate(Context context, int resource, ArrayList<CardRezultate> objects) {
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
        String etapaRezultate = getItem(position).getEtapaRezultate();
        String ligaRezultate = getItem(position).getLigaRezultate();
        String imgURLRezultate1 = getItem(position).getImgURLRezultate1();
        String imgURLRezultate2 = getItem(position).getImgURLRezultate2();
        String card_rezultate = getItem(position).getImgURLRezultate1();
        String buttonStatistici = getItem(position).getButtonStatistici();
        String dataRezultate = getItem(position).getDataRezultate();
        String acasaRezultate = getItem(position).getAcasaRezultate();
        String acasaEchipaRezultate = getItem(position).getAcasaEchipaRezultate();
        String scor1 = getItem(position).getScor1();
        String scor2 = getItem(position).getScor2();


        try{


            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.etapaRezultate = (TextView) convertView.findViewById(R.id.etapa_rezultate);
                holder.ligaRezultate= (TextView) convertView.findViewById(R.id.liga_rezultate);
                holder.imgURLRezultate1 = (ImageView) convertView.findViewById(R.id.cardImage_echipa1_rezultate);
                holder.imgURLRezultate2 = (ImageView) convertView.findViewById(R.id.cardImage_echipa2_rezultate);
                holder.buttonStatistici = (Button) convertView.findViewById(R.id.statistici_rezultate);
                holder.dataRezultate = (TextView) convertView.findViewById(R.id.date_rezultate);
                holder.acasaRezultate = (TextView) convertView.findViewById(R.id.acasa_rezultate);
                holder.acasaEchipaRezultate = (TextView) convertView.findViewById(R.id.acasa_echipa_rezultate);
                holder.scor1 = (TextView) convertView.findViewById(R.id.scor1);
                holder.scor2 = (TextView) convertView.findViewById(R.id.scor2);
                holder.card_rezultate = (ImageView) convertView.findViewById(R.id.card_rezultate);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

            lastPosition = position;

            holder.etapaRezultate.setText(etapaRezultate);
            holder.ligaRezultate.setText(ligaRezultate);
            holder.dataRezultate.setText(dataRezultate);
            holder.acasaRezultate.setText(acasaRezultate);
            holder.acasaEchipaRezultate.setText(acasaEchipaRezultate);
            holder.scor1.setText(scor1);
            holder.scor2.setText(scor2);

            holder.card_rezultate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view){

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    DetaliiScorFragment myFragment = new DetaliiScorFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, myFragment).addToBackStack(null).commit();


                }
            });


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
            imageLoader.displayImage(imgURLRezultate1, holder.imgURLRezultate1, options,new ImageLoadingListener() {
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
            imageLoader.displayImage(imgURLRezultate2, holder.imgURLRezultate2, options,new ImageLoadingListener() {
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