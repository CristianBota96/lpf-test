package com.example.test.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private ArrayList<CardScor> lstScor = new ArrayList<>();
    private StiriDetaliateFragment stiriDetaliateFragment;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ListView mListView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);


    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnfragment = (Button)view.findViewById(R.id.mai_multe);
//        ImageView imagebutton = (ImageView) view.findViewById(R.id.cardImage);

        btnfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.main_frame, new StiriFragment());
                fr.commit();
            }
        });



        // horizontal stiri cycler view
        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager) view.findViewById(R.id.horizontal_cycle);


        lstScor.add(new CardScor(
//                "drawable://" + R.drawable.fcsb,
//                "drawable://" + R.drawable.fcsb,

                "Liga1",
                "UCV acasa 14/05/2018 20:45",
                "0",
                "2",
                "fcsb",
                "cfr"
                ));
        lstScor.add(new CardScor(
//                "drawable://" + R.drawable.fcsb,
//                "drawable://" + R.drawable.fcsb,
                "Liga1",
                "UCV acasa 14/05/2018 20:45",
                "0",
                "2",
                "fcsb",
                "viitorul"
        ));

        lstScor.add(new CardScor(
//                "drawable://" + R.drawable.fcsb,
//                "drawable://" + R.drawable.fcsb,
                "Liga1",
                "UCV acasa 14/05/2018 20:45",
                "0",
                "2",
                "fcsb",
                "viitorul"
        ));



        CustomListAdapterScor adapter = new CustomListAdapterScor(getContext(), lstScor);
        pager.setAdapter(adapter);

//cerculete echipe
        getImages();
        initRecyclerView(view);

        //stiri
        mListView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.viitorul, "Liga 1 Betano: cifrele Viitorului Constanța", "Dobrogenii au reuşit a treia calificare consecutivă în cupele europene, asta după ce, pe durata întregului sezon, au practicat un fotbal ofensiv de calitate, apreciat de iubitorii fotba..."));

        CustomListAdapter adapter1 = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
        mListView.setAdapter(adapter1);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, new StiriDetaliateFragment());
                transaction.commit();
            }
        });
    }

//recyclerview
    private void getImages() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_steaua.png");
        mNames.add("FC FCSB");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_astra.png");
        mNames.add("FC Astra Giurgiu");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_dinamo.png");
        mNames.add("Dinamo 1948 Bucureşti");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_viitorul.png");
        mNames.add("FC Viitorul Constanța");

        mImageUrls.add("https://www.lpf.ro/assets/images/CSMS.png");
        mNames.add("CSM Poli Iaşi");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_craiova.png");
        mNames.add("U Craiova");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_botosani.png");
        mNames.add("FC Botoşani");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_concordia.png");
        mNames.add("CS Concordia Chiajna");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_voluntari.png");
        mNames.add("FC Voluntari");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_cfr.png");
        mNames.add("CFR 1907 Cluj");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_gaz-metan.png");
        mNames.add("Gaz Metan Mediaş");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_poli-timisoara.png");
        mNames.add("ACS Poli Timişoara");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_sf-gheorghe.png");
        mNames.add("ACS Sepsi OSK Sf. Gheorghe");

        mImageUrls.add("https://www.lpf.ro/assets/images/cl_juventus.png");
        mNames.add("ASC Juventus Bucureşti");


    }

    private void initRecyclerView(View view) {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adaptor = new RecyclerViewAdapter(getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adaptor);
    }

}