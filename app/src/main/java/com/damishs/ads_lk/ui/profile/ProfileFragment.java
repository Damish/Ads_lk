package com.damishs.ads_lk.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.damishs.ads_lk.R;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private Button editprofile,edit_pw,feedback_btn;
    private TextView name,email,phone,type,town,city;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        final TextView textView = root.findViewById(R.id.text_profile);
        profileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        editprofile=(Button)root.findViewById(R.id.edit_prof_btn);
        edit_pw=(Button)root.findViewById(R.id.editpw_btn);
        feedback_btn=(Button)root.findViewById(R.id.feedback_btn);
        name=(TextView)root.findViewById(R.id.name_prof_txt);
        email=(TextView)root.findViewById(R.id.email_prof_txt);
        phone=(TextView)root.findViewById(R.id.phone_prof_txt);
        type=(TextView)root.findViewById(R.id.type_prof_txt);
        town=(TextView)root.findViewById(R.id.town_prof_txt);
        //city=(TextView)root.findViewById(R.id.city_prof_txt);


        Bundle bundle2 = this.getArguments();
        if (bundle2 !=null){

            name.setText(getArguments().getString("name"));
            email.setText(getArguments().getString("email"));
            phone.setText(getArguments().getString("phone"));
            town.setText(getArguments().getString("town"));
            //city.setText(getArguments().getString("city"));
            type.setText(getArguments().getString("type"));

        }

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("name",name.getText().toString());
                bundle.putString("email",email.getText().toString());
                bundle.putString("phone",phone.getText().toString());
                bundle.putString("type",type.getText().toString());
                bundle.putString("town",town.getText().toString());
                //bundle.putString("city",city.getText().toString());

                EditProfileFragment fragment2 = new EditProfileFragment();
                fragment2.setArguments(bundle);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment, fragment2);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        edit_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.remove(new E());
                ft.replace(R.id.nav_host_fragment, new editpassword());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        feedback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.remove(new E());
                ft.replace(R.id.nav_host_fragment, new Feedback());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return root;
    }
}