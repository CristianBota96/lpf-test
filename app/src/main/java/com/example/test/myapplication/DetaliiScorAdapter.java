package com.example.test.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetaliiScorAdapter extends ArrayAdapter<ScorItem> {
    private static final String TAG = "DetaliiScorAdapter";

    private Map<View, ScorItem> ScorByView = new HashMap<>();
    private List<ScorItem> scorListFull;
    private Context mContext;
    ImageView imgScor1, imgScor2;
    TextView scor1, scor2, textechipa1, textechipa2;
    LayoutInflater layoutInflater;


    public DetaliiScorAdapter(Context context, ArrayList<ScorItem> scorList) {
        super(context, 0, scorList);
//        scorListFull = new ArrayList<>(scorList);
        this.mContext = context;
        this.scorListFull = scorList;

        layoutInflater = LayoutInflater.from(mContext);


    }

    public Object instantiateItem(ViewGroup container, int position){
//        View view = layoutInflater.inflate(R.layout.card_item_scor,container,false);
//        ImageView imageView = (ImageView)view.findViewById(R.id.imageScor);
//        imageView.setImageResource(lstScor.get(position));
        View view = initializeLayout(container);
        displayScorAdapter(scorListFull.get(position), view);
        container.addView(view);
        return view;
    }

    private View initializeLayout(ViewGroup container){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View contentView = inflater.inflate(R.layout.detalii_scor, container, false);

        imgScor1 = (ImageView) contentView.findViewById(R.id.scor_echipa1);
        imgScor2 = (ImageView) contentView.findViewById(R.id.scor_echipa2);
        scor1 = (TextView) contentView.findViewById(R.id.scor_scor1);
        scor2 = (TextView) contentView.findViewById(R.id.scor_scor2);
        textechipa1 = (TextView) contentView.findViewById(R.id.scor_title_echipa1);
        textechipa2 = (TextView) contentView.findViewById(R.id.scor_title_echipa2);

        return contentView;
    }
    private void displayScorAdapter(final ScorItem scorItem, final View convertView){
        imgScor1.setImageResource(R.drawable.fcsb);
        imgScor2.setImageResource(R.drawable.cfr);
        scor1.setText(scorItem.getScor1());
        scor2.setText(scorItem.getScor2());
        textechipa1.setText(scorItem.getTextechipa1());
        textechipa2.setText(scorItem.getTextechipa2());
    }
}
