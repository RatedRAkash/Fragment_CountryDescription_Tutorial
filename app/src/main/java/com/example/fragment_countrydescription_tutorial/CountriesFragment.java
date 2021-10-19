package com.example.fragment_countrydescription_tutorial;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class CountriesFragment extends Fragment {

    View rootView;

    ListView listViewCountries;
    ArrayAdapter<String> countryNamesAdapter;
    Context context;
    String [] countries;

    CallBackInterface callBackInterfaceInstance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_countries,container,false);
        initUI();
        return rootView;
    }


    //TITLE set korar jonno amra onResume() method override kore sheita te likbo
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name)+"->Select Country");
    }
    //TITLE set END


    //Activity er sathe COMMUNICATE korar jonno CALLBACKINTERFACE er instance ke initialize korlam
    public void setCallBackInterfaceInstance(CallBackInterface callBackInterfaceInstance)
    {
        this.callBackInterfaceInstance = callBackInterfaceInstance;
    }
    //Activity COMMUNICATE END



    private void initUI() {
        context = getContext();

        countries = getResources().getStringArray(R.array.countries); //Countries er name gula "values" folder theke nilam

        listViewCountries = rootView.findViewById(R.id.listViewCountries);

        countryNamesAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,countries);
        listViewCountries.setAdapter(countryNamesAdapter);//"listView" container ee jei Adapter ache sheita SET kore dilam


        listViewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                if(callBackInterfaceInstance!=null){
                    callBackInterfaceInstance.callBackMethod(pos); //Jei Country Select korlam sheita "ListViewAdapter" "pos" ee rekche... amra shei "countries[pos]" diya "country" er name ta "MainActivity" te pass kore dilam
                }
            }
        });
    }




}
