package com.example.test.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BileteFragment extends Fragment {
    private static final String TAG = "BileteFragment";
    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bilete, container, false);
        // Inflate the layout for this fragment

        mListView = (ListView) view.findViewById(R.id.listView_bilete);

        ArrayList<CardBilete> list_cardBilete = new ArrayList<>();

        list_cardBilete.add(new CardBilete( "Peluza", "Inel 1", "15 Lei",3));
        list_cardBilete.add(new CardBilete( "Cerc", "Inel 2", "10 Lei",7));
//        list_cardBilete.add(new CardBilete( "Tribune", "Inel 1", "15 Lei",3));
//        list_cardBilete.add(new CardBilete( "Peluza", "Inel 1", "15 Lei",3));

        CustomListAdapterBilete adapter = new CustomListAdapterBilete(getActivity(), R.layout.card_layout_bilete, list_cardBilete);
        mListView.setAdapter(adapter);
        
        final EditText nr_bilete = (EditText) view.findViewById(R.id.nr_bilete);

        Button send = (Button) view.findViewById(R.id.buton_cumpara_bilet);
        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String nr_biletes = nr_bilete.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_TEXT, nr_biletes);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose app to send mail"));
            }
        });
        return view;
    }

}
