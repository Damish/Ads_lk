package com.damishs.ads_lk.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.damishs.ads_lk.MainActivity;
import com.damishs.ads_lk.R;


public class PropertiesAdvancedSearch extends Fragment {
    private Spinner c_spinner_vt,c_spinner_location ;
    private EditText c_txtFrom, c_txtTo,c_txtSrc;
    private Button c_btnSrc,c_btnReset,c_rSale,c_rRent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_properties_advanced_search, container, false);
        c_spinner_vt = (Spinner) root.findViewById(R.id.spinner_vt);
        c_spinner_location = (Spinner) root.findViewById(R.id.spinner_location);
        c_txtFrom = (EditText) root.findViewById(R.id.txtFrom);
        c_txtTo = (EditText) root.findViewById(R.id.txtTo);
        c_txtSrc = (EditText) root.findViewById(R.id.txtSrc);
        c_btnSrc = (Button) root.findViewById(R.id.btnSrc);
        c_btnReset = (Button) root.findViewById(R.id.btnReset);
        c_rSale = (Button) root.findViewById(R.id.rSale );
        c_rRent = (Button) root.findViewById(R.id.rRent);

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
                        getContext(), R.array.Properties, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c_spinner_vt.setAdapter(adapter1);

                ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(
                        getContext(), R.array.prop_location, android.R.layout.simple_spinner_item);
                adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c_spinner_location.setAdapter(adapter6);

                //c_rRent.setSelected(false);
                //c_rSale.setSelected(false);
                c_txtSrc.setText("");
                c_txtFrom.setText("");
                c_txtTo.setText("");
            }});

        return root;
    }
}
