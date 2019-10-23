package com.example.test.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdusFragment extends Fragment {

    private static final String TAG = "ProdusFragment";
    private static final int NUM_COLUMNS = 1;

    private ArrayList<String> mNames = new ArrayList<>();

    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_produs, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initImageBitmaps();
        initRecyclerView2(view);

        getNames();
        initRecyclerView(view);

    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImage.add("https://www.joma.ro/image/cache/catalog/produse/SPORT/FRF/Tricou%20Nationala%202015%20-%202016-320x418.png");
        mTitle.add("FC FCSB");
        mDescription.add("home kit fc barcelona");
        mPrice.add("$50");

    }

    private void getNames() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mNames.add("S");
        mNames.add("M");
        mNames.add("L");
        mNames.add("XL");
        mNames.add("XXL");

    }
    private void initRecyclerView2(View view) {
        Log.d(TAG, "initRecyclerView2: initializing staggered recyclerview");

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_produs);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        ProdusRecyclerViewAdapter produsRecyclerViewAdapter = new ProdusRecyclerViewAdapter(mImage, mTitle, mDescription, mPrice, getContext());
        recyclerView.setAdapter(produsRecyclerViewAdapter);
    }

    private void initRecyclerView(View view) {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleView_marimi);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterMarime recyclerViewAdapterMarime = new RecyclerViewAdapterMarime(mNames, getContext());
        recyclerView.setAdapter(recyclerViewAdapterMarime);
    }

}
