package com.example.test.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EchipaFragment extends Fragment {

    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_echipa, container, false);
        Activity a = getActivity();
        mListView = (ListView) view.findViewById(R.id.lista_echipa);

        ArrayList<CardEchipa> list_cardEchipa = new ArrayList<CardEchipa>();

        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));



        CustomListAdapterEchipa adapter = new CustomListAdapterEchipa(getActivity(), R.layout.card_layout_echipa, list_cardEchipa);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, new JucatorFragment());
                transaction.commit();


            }
        });

        return view;
    }

    @Override
    public void onResume() {

        ArrayList<CardEchipa> list_cardEchipa = new ArrayList<CardEchipa>();

        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));
        list_cardEchipa.add(new CardEchipa("drawable://" + R.drawable.jucator, "10", "BALGRADEAN CRISTIAN EMANUEL", "Romania"));


        CustomListAdapterEchipa adapter = new CustomListAdapterEchipa(getActivity(), R.layout.card_layout_echipa, list_cardEchipa);
        mListView.setAdapter(adapter);

        super.onResume();
    }
}
