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


public class ClassifiedAdvancedSearch extends Fragment {

    private Spinner classified_main, classified_sub, classified_location;
    private EditText clapricefrom, clapriceto;
    private Button classifiedsearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_classified_advanced_search, container, false);

        classified_main = (Spinner) root.findViewById(R.id.spinner_class_main);
        classified_sub = (Spinner) root.findViewById(R.id.spinner_cla_sub);
        classified_location = (Spinner) root.findViewById(R.id.spinner_cla_loc);
        clapricefrom = (EditText) root.findViewById(R.id.editText_cla_price_from);
        clapriceto = (EditText) root.findViewById(R.id.editText_cla_price_to);
        classifiedsearch = (Button) root.findViewById(R.id.button_cla_search);


        classified_main.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position ==1){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.classified_sub_type1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    classified_sub.setAdapter(adapter);

                }else if (position ==2){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.classified_sub_type2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    classified_sub.setAdapter(adapter);

                }else if (position ==0){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.default_classified_sub, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    classified_sub.setAdapter(adapter);

                }else if (position ==3){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.classified_sub_type3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    classified_sub.setAdapter(adapter);

                }else if (position ==4){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.classified_sub_type4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    classified_sub.setAdapter(adapter);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        classifiedsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
//
        return  root;
    }
}
