package com.damishs.ads_lk.ui.profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.damishs.ads_lk.MainActivity;
import com.damishs.ads_lk.R;


public class editpassword extends Fragment {
    private View view;
    private EditText new_pass,repeat_pass;
    private Button change_pw;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_editpassword, container, false);


        new_pass=(EditText)view.findViewById(R.id.new_pw);
        repeat_pass=(EditText)view.findViewById(R.id.repeat_pw);
        change_pw=(Button)view.findViewById(R.id.change_pw_btn);

        change_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_pw_st=new_pass.getText().toString().trim();
                String repeat_pw_st=repeat_pass.getText().toString().trim();
                if (!TextUtils.equals(new_pw_st,repeat_pw_st)){
                    Toast.makeText(getContext(), "repeat_pw not match", Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder ald=new AlertDialog.Builder(getContext());
                    ald.setMessage("Post has been Submitted!!!");
                    ald.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.nav_host_fragment, new ProfileFragment());
                            ft.addToBackStack(null);
                            ft.commit();
                        }
                    });
                    ald.show();
                }
            }
        });




        return view;
    }
}