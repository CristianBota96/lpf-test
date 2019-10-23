package com.example.test.myapplication;


import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetaliiScorFragment extends Fragment {
    private static final String TAG = "DetaliiScorFragment";

//    private ArrayList<CardDetaliiScor> lstDetaliiScor = new ArrayList<>();
//    private Layout mListView;
//    private ListView mListView2;

    private ArrayList<String> mJucator1 = new ArrayList<>();
    private ArrayList<String> mJucator2 = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();

    private List<ScorItem> scorList;
    private ListView mListView;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalii_scor, container, false);


    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //scor
        ImageView echipa1 = (ImageView) view.findViewById(R.id.scor_echipa1);
        echipa1.setImageResource(R.drawable.cfr);
        TextView scor1 = (TextView) view.findViewById(R.id.scor_scor1);
        scor1.setText("5");
        TextView titlu_echipa1 = (TextView) view.findViewById(R.id.scor_title_echipa1);
        titlu_echipa1.setText("CFR");

        ImageView echipa2 = (ImageView) view.findViewById(R.id.scor_echipa2);
        echipa2.setImageResource(R.drawable.fcsb);
        TextView scor2 = (TextView) view.findViewById(R.id.scor_scor2);
        scor2.setText("3");
        TextView titlu_echipa2 = (TextView) view.findViewById(R.id.scor_title_echipa2);
        titlu_echipa2.setText("FCSB");


       //statistica
      /*  ImageView minge = (ImageView) view.findViewById(R.id.gol);
        minge.setImageResource(R.drawable.minge);
        ImageView galben = (ImageView) view.findViewById(R.id.cartonas_galben);
        galben.setImageResource(R.drawable.galben);
        ImageView rosu = (ImageView) view.findViewById(R.id.cartonas_rosu);
        rosu.setImageResource(R.drawable.rosu);
*/

        initImageBitmaps();
        initRecyclerView(view);


        ListView mListView = (ListView) view.findViewById(R.id.list_scor_statistici);

        ArrayList<CardClasament> list = new ArrayList<>();

        list.add(new CardClasament("1", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("2", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("3", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("4", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("5", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("6", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("7", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("8", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("9", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));
        list.add(new CardClasament("10", "drawable://" + R.drawable.cfr, "CFR Cluj", "2", "6", "10", "4"));

        CustomListAdapterClasament adapter = new CustomListAdapterClasament(getActivity(), R.layout.card_layout_clasament, list);
        mListView.setAdapter(adapter);

    }
    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");



        mJucator1.add("P.Popescu");
        mImage.add("drawable://" + R.drawable.minge);
        mJucator2.add("P.Stancioiu");

        mJucator1.add("P.Ionescu");
        mImage.add("");
        mJucator2.add("");

        mJucator1.add("P.Popescu");
        mImage.add("");
        mJucator2.add("");

        mJucator1.add("P.Popescu");
        mImage.add("drawable://" + R.drawable.minge);
        mJucator2.add("P.Stancioiu");


    }

    private void initRecyclerView(View view) {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.statistici);
        recyclerView.setLayoutManager(layoutManager);
        StatisticiRecyclerViewAdapter adaptor = new StatisticiRecyclerViewAdapter(mJucator2, mImage,  mJucator1, getContext());
        recyclerView.setAdapter(adaptor);
    }

}
