package com.example.test.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomListAdapterScor extends PagerAdapter {
    private static final String TAG = "CustomListAdapterScor";

    private Map<View, CardScor> ScorByView = new HashMap<>();
    private List<CardScor> lstScor;
    private Context mContext;
    private ImageView imgScor1, imgScor2, imgbackground;
    private TextView title, subtitle, scor1, scor2, titlu_echipa1, titlu_echipa2;
    private int mResource;
    LayoutInflater layoutInflater;
    private int lastPosition = -1;


    public CustomListAdapterScor(Context context, ArrayList<CardScor> lstScor) {
//        super(resource, context, lstScor);
//        mResource = resource;
        this.mContext = context;
        this.lstScor = lstScor;

        layoutInflater = LayoutInflater.from(mContext);


        //sets up the image loader library
        setupImageLoader();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position){
//        View view = layoutInflater.inflate(R.layout.card_item_scor,container,false);
//        ImageView imageView = (ImageView)view.findViewById(R.id.imageScor);
//        imageView.setImageResource(lstScor.get(position));
        View view = initializeLayout(container);
        displayScor(lstScor.get(position), view);
        ScorByView.put(view, lstScor.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
        ScorByView.remove(object);
    }

    @Override
    public int getCount() {
        return lstScor.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }


    private View initializeLayout(ViewGroup container){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View contentView = inflater.inflate(R.layout.card_layout_scor, container, false);

        imgScor1 = (ImageView) contentView.findViewById(R.id.main_echipa1);
        imgScor2 = (ImageView) contentView.findViewById(R.id.main_echipa2);
        imgbackground = (ImageView) contentView.findViewById(R.id.background_horizontal);
        title = (TextView) contentView.findViewById(R.id.main_title);
        subtitle = (TextView) contentView.findViewById(R.id.main_Subtitle);
        scor1 = (TextView) contentView.findViewById(R.id.main_scor1);
        scor2 = (TextView) contentView.findViewById(R.id.main_scor2);
        titlu_echipa1 = (TextView) contentView.findViewById(R.id.main_title_echipa1);
        titlu_echipa2 = (TextView) contentView.findViewById(R.id.main_title_echipa2);

        return contentView;

    }

    private void displayScor(final CardScor cardScor, final View convertView){



//        ImageView imgScor1 = (ImageView) containerView.findViewById(R.id.main_echipa1);
//        ImageView imgScor2 = (ImageView) containerView.findViewById(R.id.main_echipa2);


        imgScor1.setImageResource(R.drawable.fcsb);
        imgScor2.setImageResource(R.drawable.fcsb);
        imgbackground.setImageResource(R.drawable.background1);
        title.setText(cardScor.getTitle());
        subtitle.setText(cardScor.getSubtitle());
        scor1.setText(cardScor.getScor1());
        scor2.setText(cardScor.getScor2());
        titlu_echipa1.setText(cardScor.getTitlu_echipa1());
        titlu_echipa2.setText(cardScor.getTitlu_echipa2());


        imgbackground.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                DetaliiScorFragment myFragment = new DetaliiScorFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, myFragment).addToBackStack(null).commit();

            }
        });



        ImageLoader imageLoader = ImageLoader.getInstance();

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