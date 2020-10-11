package com.damishs.ads_lk.ui.profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.damishs.ads_lk.R;


public class Feedback extends Fragment {
    private View view;
    private Button send,reset;
    private EditText name,email,message;
    private Spinner type;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feedback, container, false);

        send=(Button)view.findViewById(R.id.send_btn);
       // reset=(Button)view.findViewById(R.id.reset_btn);
        name=(EditText)view.findViewById(R.id.fb_name);
        email=(EditText)view.findViewById(R.id.fb_email);
        message=(EditText)view.findViewById(R.id.fb_message);
        type=(Spinner)view.findViewById(R.id.feedback_spinner);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length=name.getText().length();
                if (length<4){
                    Toast.makeText(getContext(), "Short name", Toast.LENGTH_SHORT).show();
                }else{
                    String Email = email.getText().toString().trim();

                    String emailPattern = "[a-zA-Z0-9._-]+@[g]+[m]+[a]+[i]+[l]+\\.+[a-z]+";
                    if (!Email.matches(emailPattern)) {
                        Toast.makeText(getContext(), "Incorrect Email", Toast.LENGTH_SHORT).show();
                    }else {
                        String type_st= type.getSelectedItem().toString();
                        if (TextUtils.equals("Select Feedback Type",type_st)){
                            Toast.makeText(getContext(), "please select Feedback Type", Toast.LENGTH_SHORT).show();
                        }else {
                            String msg_st= message.toString().trim();
                            if (TextUtils.isEmpty(msg_st)){
                                Toast.makeText(getContext(), "please type your message", Toast.LENGTH_SHORT).show();
                            }else {
                                AlertDialog.Builder adb = new AlertDialog.Builder(
                                        getContext());
                                adb.setMessage("Feedback send success");
                                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        ProfileFragment fragment1 = new ProfileFragment();

                                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();


                                        ft.replace(R.id.nav_host_fragment, fragment1);
                                        ft.addToBackStack(null);
                                        ft.commit();
                                    }
                                });
                                adb.show();
                            }
                        }
                    }
                }
            }
        });




        return view;
    }
}