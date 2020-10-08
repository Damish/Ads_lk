package com.damishs.ads_lk.ui.postAd;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.damishs.ads_lk.R;

public class PostAdFragment extends Fragment {

    private Spinner Category_main;
    private Spinner Category_sub;
    private Button select_category,reset;
    private MutableLiveData<String> mText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                            final ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_post_ad, container, false);



        reset=(Button)root.findViewById(R.id.reset_btn);
        Category_main=(Spinner)root.findViewById(R.id.category_main);
        Category_sub=(Spinner)root.findViewById(R.id.category_sub);
        select_category=(Button)root.findViewById(R.id.select_cat_btn);
//change second spinner
        Category_main.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position ==1){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.subtype_categories, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Category_sub.setAdapter(adapter);

                }else if (position ==2){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.subtype_categories2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Category_sub.setAdapter(adapter);

                }else if (position ==0){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.Default_sub_category, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Category_sub.setAdapter(adapter);

                }
                else if (position ==3) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.subtype_categories3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Category_sub.setAdapter(adapter);
                }
                else if (position ==4) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.subtype_categories4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Category_sub.setAdapter(adapter);
                }
                else if (position ==5) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            getContext(), R.array.subtype_categories5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Category_sub.setAdapter(adapter);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        select_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.equals(Category_main.getSelectedItem().toString().trim(),"Select main category First...") && TextUtils.equals(Category_sub.getSelectedItem().toString().trim(),"Select sub_category..")){
                    Toast.makeText(getContext(), "Select categories and sub categories!!!", Toast.LENGTH_SHORT).show();
                }else {
                    FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
                    container.removeAllViews();
//                ft.remove(new PostAdFragment());
                    ft.replace(R.id.nav_host_fragment, new PostUI2());
                    ft.addToBackStack(null);
                    ft.commit();
                }
             }
        });

        //reset
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                        getContext(), R.array.maintype_categories, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Category_main.setAdapter(adapter);

            }
        });








        return root;
    }

}