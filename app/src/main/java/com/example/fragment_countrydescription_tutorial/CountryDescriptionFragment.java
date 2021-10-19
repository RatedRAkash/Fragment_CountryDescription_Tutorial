package com.example.fragment_countrydescription_tutorial;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class CountryDescriptionFragment extends Fragment {

    View rootView;
    TextView textViewCountryDescription;

    String countryName;
    String countryDescription;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_country_description,container,false);
        initUI();
        return rootView;
    }

    private void initUI() {
        textViewCountryDescription = rootView.findViewById(R.id.textViewCountryDescription);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        int pos = Integer.valueOf(bundle.getString(CallBackInterface.KEY_SELECTED_COUNTRY, String.valueOf(1)));

        String[] countries = getResources().getStringArray(R.array.countries); //Countries er name gula "values" folder theke nilam
        String[] countries_description = getResources().getStringArray(R.array.countries_description);

        countryName = countries[pos];
        countryDescription = countries_description[pos];

        textViewCountryDescription.setText(countryDescription);
    }


    //TITLE set korar jonno amra onResume() method override kore sheita te likbo
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(countryName);
    }
    //TITLE set END

}
