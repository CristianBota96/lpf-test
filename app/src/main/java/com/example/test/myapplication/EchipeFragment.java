package com.example.test.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class EchipeFragment extends Fragment {
    private static final String TAG = "EchipeFragment";
    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_echipe, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);{


            Log.d(TAG, "onCreate: started.");
            mSectionsPageAdapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) view.findViewById(R.id.container);
            setupViewPager(mViewPager);

            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);

        }
    }
    private  void getImcomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if(getActivity().getIntent().hasExtra("image_url") && getActivity().getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getActivity().getIntent().getStringExtra("image_url");
            String imageName = getActivity().getIntent().getStringExtra("image_name");
        }
    }
    public void setupViewPager(ViewPager viewpager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new PrezentaregeneralaFragment(), "Prezentare Generala");
        adapter.addFragment(new EchipaFragment(), "Echipa");
        adapter.addFragment(new StatisticiFragment(), "Statistici");
        viewpager.setAdapter(adapter);
    }
}
