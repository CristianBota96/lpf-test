package com.example.test.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class PrezentaregeneralaFragment extends Fragment {
    private static final String TAG = "PrezentareGeneralaFragment";

    private ListView mCalendarList;
    private ListView mRezultateList;


    boolean showContent = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prezentaregenerala, container, false);
        Activity a = getActivity();
        mCalendarList = (ListView) view.findViewById(R.id.lista_calendar);
        mRezultateList = (ListView) view.findViewById(R.id.lista_rezultate);

        ArrayList<CardCalendar> list_cardCalendar = new ArrayList<CardCalendar>();

        list_cardCalendar.add(new CardCalendar("drawable://" + R.drawable.fcsb,"drawable://" + R.drawable.fcsb, "ETAPA 10", "LIGA 1 BETANO", "Duminica/ 20 MAI '18/ 20:45", "Acasa","FCSB","Cumpara Bilet"));

        CustomListAdapterCalendar adapter = new CustomListAdapterCalendar(getActivity(), R.layout.card_layout_calendar, list_cardCalendar);
        mCalendarList.setAdapter(adapter);



       //lista rezultate (PREZENTARE GENERALA)

//
        ArrayList<CardRezultate> list_cardRezultate = new ArrayList<CardRezultate>();

        list_cardRezultate.add(new CardRezultate("drawable://" + R.drawable.fcsb,"drawable://" + R.drawable.fcsb, "ETAPA 9", "LIGA 1 BETANO", "Sambata/ 11 MAI '18/ 20:45", "Acasa","FCSB","2","1","", ""));
        list_cardRezultate.add(new CardRezultate("drawable://" + R.drawable.fcsb,"drawable://" + R.drawable.fcsb, "ETAPA 8", "LIGA 1 BETANO", "Sambata/ 11 MAI '18/ 20:45", "Acasa","FCSB","3", "2", "", ""));
        list_cardRezultate.add(new CardRezultate("drawable://" + R.drawable.fcsb,"drawable://" + R.drawable.fcsb, "ETAPA 7", "LIGA 1 BETANO", "Sambata/ 11 MAI '18/ 20:45", "Acasa","FCSB","0","1","", ""));

        CustomListAdapterRezultate adapter2 = new CustomListAdapterRezultate(getActivity(), R.layout.card_layout_rezultate, list_cardRezultate);
        mRezultateList.setAdapter(adapter2);

        return view;
    }


}
