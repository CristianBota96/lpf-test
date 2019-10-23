package com.example.test.myapplication;


import android.os.Bundle;

import android.support.annotation.Nullable;
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
public class StiriDetaliateFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private ArrayList<CardStiriDetaliate> lstStiriDetaliate = new ArrayList<>();
    private ListView mListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stiri_detaliate, container, false);


    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mListView = (ListView) view.findViewById(R.id.listView_stiridetaliate);

        ArrayList<CardStiriDetaliate> list = new ArrayList<>();

        list.add(new CardStiriDetaliate("drawable://" + R.drawable.viitorul, "Liga 1 Betano",
                "Cifrele Viitorului Constanta",
                "11.06.2018",
                "aCEST TEXT FUNCTIONEAZA dinamic. <<StiriDetaliateFragment>>"

        ));

        CustomListAdapterStiriDetaliate adapter = new CustomListAdapterStiriDetaliate(getActivity(), R.layout.card_layout_stiridetaliate, list);
        mListView.setAdapter(adapter);


    }
}
