package com.damishs.ads_lk.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.damishs.ads_lk.MainActivity;
import com.damishs.ads_lk.R;


public class BusinessIndustryAdvancedSearch extends Fragment {

    private Spinner business_main, business_sub, business_location;
    private EditText pricefrom, priceto;
    private Button businesssearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View root = inflater.inflate(R.layout.fragment_business_industry_advanced_search, container, false);
        business_main = (Spinner) root.findViewById(R.id.spinner_business_category);
        business_sub = (Spinner) root.findViewById(R.id.spinner_business_subcategory);
        business_location = (Spinner) root.findViewById(R.id.location_spinner);
        pricefrom = (EditText) root.findViewById(R.id.editTextPriceFrom);
        priceto = (EditText) root.findViewById(R.id.editTextPriceTo);
        businesssearch = (Button) root.findViewById(R.id.button_B_search);


        business_main.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position ==1){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.business_sub_cat_Type1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    business_sub.setAdapter(adapter);

                }else if (position ==2){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.business_sub_cat_Type2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    business_sub.setAdapter(adapter);

                }else if (position ==0){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.Default_business_sub_category, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    business_sub.setAdapter(adapter);

                }else if (position ==3){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.business_sub_cat_Type3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    business_sub.setAdapter(adapter);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        businesssearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
