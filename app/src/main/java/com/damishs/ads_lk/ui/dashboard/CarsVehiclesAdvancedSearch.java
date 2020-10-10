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


public class CarsVehiclesAdvancedSearch extends Fragment {
    private Spinner c_spinner_vt,c_spinner_brand,c_spinner_condition,c_spinner_mileage,c_spinner_bYear,c_spinner_location;
    private EditText c_txtFrom, c_txtTo;
    private Button c_btnSrc,c_btnReset;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_blank, container, false);
        c_spinner_vt = (Spinner) root.findViewById(R.id.spinner_vt);
        c_spinner_brand = (Spinner) root.findViewById(R.id.spinner_brand);
        c_spinner_condition = (Spinner) root.findViewById(R.id.spinner_condition);
        c_spinner_mileage = (Spinner) root.findViewById(R.id.spinner_mileage);
        c_spinner_bYear = (Spinner) root.findViewById(R.id.spinner_bYear);
        c_spinner_location = (Spinner) root.findViewById(R.id.spinner_location);
        c_txtFrom = (EditText) root.findViewById(R.id.txtFrom);
        c_txtTo = (EditText) root.findViewById(R.id.txtTo);
        c_btnSrc = (Button) root.findViewById(R.id.btnSrc);
        c_btnReset = (Button) root.findViewById(R.id.btnReset);

        c_spinner_vt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position ==0){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.Default_vehicle_brand, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    c_spinner_brand.setAdapter(adapter);

                }else if (position ==1){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.Car_brands, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    c_spinner_brand.setAdapter(adapter);

                }else if (position ==2){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.Bike_brands, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    c_spinner_brand.setAdapter(adapter);

                }else  if (position ==3){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.Van_brands, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    c_spinner_brand.setAdapter(adapter);

                }
                else  if (position ==4){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.Jeep_brands, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    c_spinner_brand.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        c_btnSrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        c_btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                        getContext(), R.array.Vehicle_type, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c_spinner_vt.setAdapter(adapter1);

                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                        getContext(), R.array.Default_vehicle_brand, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c_spinner_brand.setAdapter(adapter2);

                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                        getContext(), R.array.condition, android.R.layout.simple_spinner_item);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c_spinner_condition.setAdapter(adapter3);

                ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
                        getContext(), R.array.mileage, android.R.layout.simple_spinner_item);
                adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c_spinner_mileage.setAdapter(adapter4);

                ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
                        getContext(), R.array.built_year, android.R.layout.simple_spinner_item);
                adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c_spinner_bYear.setAdapter(adapter5);

                ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(
                        getContext(), R.array.location, android.R.layout.simple_spinner_item);
                adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c_spinner_location.setAdapter(adapter6);

                c_txtFrom.setText("");
                c_txtTo.setText("");
            }
        });
        return root;
    }
}
