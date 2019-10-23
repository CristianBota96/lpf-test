package com.example.test.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SponsoriFragment extends Fragment {
    private static final String TAG = "SponsoriFragment";

    private Button btnTEST;
    Spinner dropdownmenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponsori, container, false);
//        btnTEST = (Button) view.findViewById(R.id.btnTEST);
//
//        btnTEST.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "TESTING BUTTON SPONSORI", Toast.LENGTH_SHORT).show();
//            }
//        });

        dropdownmenu = (Spinner) view.findViewById(R.id.spinner);

        List<String> list = new ArrayList<>();
        list.add("Alege un proiect");
        list.add("Viitorul Constanta");
        list.add("FCSB");
        list.add("CFR CLUJ");
        list.add("Dinamo Bucuresti");
        list.add("FC RIPENSIA");
        list.add("POLI TIMISOARA");
        list.add("HCM Sighetu Marmatiei");
        list.add("Gloria Bistrita");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownmenu.setAdapter(adapter);
        dropdownmenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), "Selected: "+ itemvalue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

}

