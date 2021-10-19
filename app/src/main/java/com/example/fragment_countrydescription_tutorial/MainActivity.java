package com.example.fragment_countrydescription_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CallBackInterface{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        addCountriesFragment();
    }

    private void addCountriesFragment() {

        fragmentTransaction = fragmentManager.beginTransaction();

        CountriesFragment countryListFragment = new CountriesFragment();

        //1st FRAGMENT er sathe COMMUNICATE korar jonno ACTIVITY jei callBackInterface implements korse taar shei method ta oi 1st Fragment ee pass kore dilam
        countryListFragment.setCallBackInterfaceInstance(this);

        fragmentTransaction.add(R.id.fragmentContainer_in_main, countryListFragment);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(int selectedCountryPos) {

        fragmentTransaction = fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragmentFragment = new CountryDescriptionFragment();

        //Data next FRAGMENT e pathanor jonno "Bundle" use korlam
        Bundle bundle = new Bundle();
        bundle.putString(CallBackInterface.KEY_SELECTED_COUNTRY, String.valueOf(selectedCountryPos));  //Bundle ee ONLY "STRING" pathano jai... tai String.valueOf() diye "Pos" ke String ee convert kore then opor pashe receive korbo
        countryDescriptionFragmentFragment.setArguments(bundle);
        //Data next FRAGMENT e pathanor END


        fragmentTransaction.replace(R.id.fragmentContainer_in_main, countryDescriptionFragmentFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    //CallBackInterface er Override Method
    @Override
    public void callBackMethod(int pos) {
//        Toast.makeText(this, "ToDO:Trigger Other Fragment",Toast.LENGTH_SHORT).show();
        addCountryDescriptionFragment(pos);
    }
}