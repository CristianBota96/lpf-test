package com.example.test.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
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


public class CustomListAdapterBilete extends ArrayAdapter<CardBilete> {

    private static final String TAG = "CustomListAdapterBilete";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView locul;
        TextView pozitia;
        TextView pretbilet;
        EditText nr_bilete;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapterBilete(Context context, int resource, ArrayList<CardBilete> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the persons information
        String locul = getItem(position).getLocul();
        String pozitia = getItem(position).getPozitia();
        String pretbilet = getItem(position).getPretbilet();
        Integer nr_bilete = getItem(position).getNr_bilete();


        try{


            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.locul = (TextView) convertView.findViewById(R.id.locul);
                holder.pozitia = (TextView) convertView.findViewById(R.id.pozitia);
                holder.pretbilet = (TextView) convertView.findViewById(R.id.pret_bilet);
                holder.nr_bilete = (EditText) convertView.findViewById(R.id.nr_bilete);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

            lastPosition = position;

            holder.locul.setText(locul);
            holder.pozitia.setText(pozitia);
            holder.pretbilet.setText(pretbilet);
            holder.nr_bilete.getEditableText();


            return convertView;
        }catch (IllegalArgumentException e){
            Log.e(TAG, "getView: IllegalArgumentException: " + e.getMessage() );
            return convertView;
        }

    }

}