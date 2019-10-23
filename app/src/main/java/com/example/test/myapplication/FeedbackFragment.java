package com.example.test.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {
    private static final String TAG = "FeedbackFragment";

    Spinner dropdownmenu_subiect;
    Spinner dropdownmenu_stadion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        //Spinner subiect
        dropdownmenu_subiect = (Spinner) view.findViewById(R.id.spinner_subiect);

        List<String> list = new ArrayList<>();
        list.add("Alege un subiect");
        list.add("Curatenie");
        list.add("Echipa");
        list.add("Mancare");
        list.add("Receptie");
        list.add("Bilete");
        list.add("Tricouri");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownmenu_subiect.setAdapter(adapter);
        dropdownmenu_subiect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), "Selected: "+ itemvalue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner Stadion

        dropdownmenu_stadion = (Spinner) view.findViewById(R.id.spinner_stadion);

        List<String> list2 = new ArrayList<>();
        list2.add("Alege un stadion");
        list2.add("Cluj Arena");
        list2.add("Arena Nationala");
        list2.add("Dan Paltinisanu");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list2);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownmenu_stadion.setAdapter(adapter2);
        dropdownmenu_stadion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), "Selected: "+ itemvalue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText email = (EditText) view.findViewById(R.id.email);
        final EditText nume = (EditText) view.findViewById(R.id.Nume);
        final EditText detalii = (EditText) view.findViewById(R.id.detalii);

        Button send = (Button) view.findViewById(R.id.buton_send);
        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String emails   = email.getText().toString();
                String numes    = nume.getText().toString();
                String detaliis = detalii.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, emails);
                email.putExtra(Intent.EXTRA_COMPONENT_NAME, numes);
                email.putExtra(Intent.EXTRA_TEXT, detaliis);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose app to send mail"));
            }
        });

        Button imagini = (Button) view.findViewById(R.id.buton_imagini);
        imagini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emails= email.getText().toString();
                String numes = nume.getText().toString();
                String detaliis = detalii.getText().toString();

                Intent images = new Intent(Intent.ACTION_VIEW);
                images.putExtra(Intent.EXTRA_EMAIL, emails);
                images.putExtra(Intent.EXTRA_COMPONENT_NAME, numes);
                images.putExtra(Intent.EXTRA_TEXT, detaliis);

                images.setType("message/rfc822");
                startActivity(Intent.createChooser(images, "upload images"));

            }
        });


        return view;
    }

}
