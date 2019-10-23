package com.example.test.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
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


public class CustomListAdapterDetaliiStatistici extends ArrayAdapter<CardDetaliiStatistici> {
    private static final String TAG = "CustomListAdapterDetali";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;
    private ProgressBar mProgressBar;
    private ProgressBar mProgressBar2;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView scor1, scor2, titlu_mijloc,mLoadingText;
     //   ImageView imgbackground;
//        ProgressBar dialog;
        ProgressBar mProgressBar;
        ProgressBar mProgressBar2;

    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapterDetaliiStatistici(Context context, int resource, ArrayList<CardDetaliiStatistici> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

        //sets up the image loader library
//        setupImageLoader();
    }

    @SuppressLint("LongLogTag")
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the persons information
        // String imgbackground = getItem(position).getImgbackground();
//        String mLoadingText = getItem(position).getScor1();
        String scor1 = getItem(position).getScor1();
        String scor2 = getItem(position).getScor2();
        String titlu_mijloc = getItem(position).getTitlu_mijloc();


        try {


            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder = new ViewHolder();
                //     holder.imgbackground = (ImageView) convertView.findViewById(R.id.background_horizontal);
                holder.scor1 = (TextView) convertView.findViewById(R.id.numar_stanga);
                holder.scor2 = (TextView) convertView.findViewById(R.id.numar_dreapta);
                holder.titlu_mijloc = (TextView) convertView.findViewById(R.id.titlu_mijloc);
//                holder.dialog = (ProgressBar) convertView.findViewById(R.id.progress_stanga);
                holder.mProgressBar = (ProgressBar) convertView.findViewById(R.id.progress_stanga);
                holder.mProgressBar2 = (ProgressBar) convertView.findViewById(R.id.progress_dreapta);
//                holder.mLoadingText = (TextView) convertView.findViewById(R.id.numar_stanga);

                result = convertView;

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

            lastPosition = position;

//            holder.mLoadingText.setText(mLoadingText);
            holder.scor1.setText(scor1);
            holder.scor2.setText(scor2);
            holder.titlu_mijloc.setText(titlu_mijloc);

//            holder.mProgressStatus.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (mProgressStatus < 100) {
                        mProgressStatus++;
                        android.os.SystemClock.sleep(100);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                holder.mProgressBar.setProgress(mProgressStatus);
                            }
                        });
                    }
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            holder.scor1.setVisibility(View.VISIBLE);
                        }
                    });
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (mProgressStatus < 70) {
                        mProgressStatus++;
                        android.os.SystemClock.sleep(100);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                holder.mProgressBar2.setProgress(mProgressStatus);
                            }
                        });
                    }
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            holder.scor2.setVisibility(View.VISIBLE);
                        }
                    });
                }
            }).start();

            return convertView;
        }catch (IllegalArgumentException e){
            Log.e(TAG, "getView: IllegalArgumentException: " + e.getMessage() );
            return convertView;
        }

    }
}