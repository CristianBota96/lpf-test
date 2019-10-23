package com.example.test.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JucatorFragment extends Fragment {
    private static final String TAG = "JucatorFragment";

//    private ArrayList<CardJucator> lstJucator = new ArrayList<>();
    private ListView mToolbar;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jucator, container, false);

//        Toolbar pager = (Toolbar) view.findViewById(R.id.toolbar_jucator);

//        mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_jucator);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);

        //        lstJucator.add(new CardJucator(
////                "drawable://" + R.drawable.fcsb,
////                "drawable://" + R.drawable.fcsb,
//
//                "33 STANCIOIU EDUARD",
//                "Portar FCSB",
//                "Cumpara Tricoul"
//        ));


        mToolbar = (ListView) view.findViewById(R.id.listView_jucator);

        ArrayList<CardJucator> list_cardJucator = new ArrayList<>();

        list_cardJucator.add(new CardJucator("drawable://" + R.drawable.stancioiu, "drawable://" + R.drawable.fcsb, "33 STANCIOIU EDUARD", "Portar FCSB", "Cumpara Tricou"));

        CustomListAdapter_jucator2 adapter = new CustomListAdapter_jucator2(getActivity(), R.layout.card_layout_jucator, list_cardJucator);
        mToolbar.setAdapter(adapter);

        return view;

    }

}
