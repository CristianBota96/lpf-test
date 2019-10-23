package com.example.test.myapplication;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticiFragment extends Fragment {
    private static final String TAG = "StatisticiFragment";

    private List<ScorItem> scorList;
    private ListView mListView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistici, container, false);


    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView mListView = (ListView) view.findViewById(R.id.list_clasament_statistici);

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
}
