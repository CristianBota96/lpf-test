package com.example.test.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    private static final String TAG = "ShopFragment";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<String> mButton = new ArrayList<>();
//
//    private ListView mListView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getNames();
        initRecyclerView(view);

        initImageBitmaps();
        initRecyclerView2(view);

    }
    private void getNames() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mNames.add("All");
        mNames.add("tricouri");
        mNames.add("pantaloni");
        mNames.add("Bilete");
        mNames.add("etc.");

    }
    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImage.add("https://www.joma.ro/image/cache/catalog/produse/SPORT/FRF/Tricou%20Nationala%202015%20-%202016-320x418.png");
        mTitle.add("FC FCSB");
        mDescription.add("home kit fc barcelona");
        mPrice.add("$50");
        mButton.add("Adauga in cos");

        mImage.add("https://www.joma.ro/image/cache/catalog/produse/SPORT/FRF/Tricou%20Nationala%202015%20-%202016-320x418.png");
        mTitle.add("FC FCSB");
        mDescription.add("home kit fc barcelona");
        mPrice.add("$50");
        mButton.add("adauga in cos");

        mImage.add("https://www.joma.ro/image/cache/catalog/produse/SPORT/FRF/Tricou%20Nationala%202015%20-%202016-320x418.png");
        mTitle.add("FC FCSB");
        mDescription.add("home kit fc barcelona");
        mPrice.add("$50");
        mButton.add("adauga in cos");

        mImage.add("https://www.joma.ro/image/cache/catalog/produse/SPORT/FRF/Tricou%20Nationala%202015%20-%202016-320x418.png");
        mTitle.add("FC FCSB");
        mDescription.add("home kit fc barcelona");
        mPrice.add("$50");
        mButton.add("adauga in cos");


    }

    private void initRecyclerView(View view) {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleView_shop);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterShop adaptor = new RecyclerViewAdapterShop(mNames, getContext());
        recyclerView.setAdapter(adaptor);
    }

    private void initRecyclerView2(View view) {
        Log.d(TAG, "initRecyclerView2: initializing staggered recyclerview");

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_elements);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        ShopRecyclerViewAdapter shopRecyclerViewAdapter = new ShopRecyclerViewAdapter(mImage, mTitle, mDescription, mPrice, mButton, getContext());
        recyclerView.setAdapter(shopRecyclerViewAdapter);
    }

}
