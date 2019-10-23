package com.example.test.myapplication;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StiriFragment extends Fragment {
    private static final String TAG = "StiriFragment";

    private ListView mListView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stiri, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        {
            mListView = (ListView) view.findViewById(R.id.listView);

            ArrayList<Card> list = new ArrayList<>();

            list.add(new Card("drawable://" + R.drawable.viitorul, "Liga 1 Betano: cifrele Viitorului Constanța", "Dobrogenii au reuşit a treia calificare consecutivă în cupele europene, asta după ce, pe durata întregului sezon, au practicat un fotbal ofensiv de calitate, apreciat de iubitorii fotba..."));
            list.add(new Card("drawable://" + R.drawable.viitorul, "Liga 1 Betano: cifrele Viitorului Constanța", "Dobrogenii au reuşit a treia calificare consecutivă în cupele europene, asta după ce, pe durata întregului sezon, au practicat un fotbal ofensiv de calitate, apreciat de iubitorii fotba..."));
            list.add(new Card("drawable://" + R.drawable.viitorul, "Liga 1 Betano: cifrele Viitorului Constanța", "Dobrogenii au reuşit a treia calificare consecutivă în cupele europene, asta după ce, pe durata întregului sezon, au practicat un fotbal ofensiv de calitate, apreciat de iubitorii fotba..."));
            list.add(new Card("drawable://" + R.drawable.viitorul, "Liga 1 Betano: cifrele Viitorului Constanța", "Dobrogenii au reuşit a treia calificare consecutivă în cupele europene, asta după ce, pe durata întregului sezon, au practicat un fotbal ofensiv de calitate, apreciat de iubitorii fotba..."));
            list.add(new Card("drawable://" + R.drawable.viitorul, "Liga 1 Betano: cifrele Viitorului Constanța", "Dobrogenii au reuşit a treia calificare consecutivă în cupele europene, asta după ce, pe durata întregului sezon, au practicat un fotbal ofensiv de calitate, apreciat de iubitorii fotba..."));


            CustomListAdapter adapter1 = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
            mListView.setAdapter(adapter1);

//            cardviewbutton = (CardView) view.findViewById(R.id.cardview);
////            cardviewbutton.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
////                    transaction.replace(R.id.cardview, new StiriDetaliateFragment());
////                    transaction.commit();
////                }
////            });

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_frame, new StiriDetaliateFragment());
                    transaction.commit();
                }
            });
        }

    }
}