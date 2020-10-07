package com.damishs.ads_lk.ui.postAd;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.damishs.ads_lk.MainActivity;
import com.damishs.ads_lk.R;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class PostUI2 extends Fragment {
    private View view;
    private Button addimage,submit_btn;
    private Uri imgUri;
    private ImageView selectimage;
    private EditText Titletext,PriceText,DetailsTxt,NameTxt,EmailTxt,PhoneTxt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_post_ui2, container, false);


        addimage=(Button)view.findViewById(R.id.add_img_btn);
        selectimage=(ImageView)view.findViewById(R.id.imageView);
        submit_btn=(Button)view.findViewById(R.id.submit_btn);

        Titletext=(EditText)view.findViewById(R.id.title_in);
        PriceText=(EditText)view.findViewById(R.id.price_in);
        DetailsTxt=(EditText)view.findViewById(R.id.ad_details_in);
        NameTxt=(EditText)view.findViewById(R.id.TxtContactName);
        EmailTxt=(EditText)view.findViewById(R.id.TxtcontactEmail);
        PhoneTxt=(EditText)view.findViewById(R.id.TxtContactPhone);


        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectIMG();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);
                }
            }

        });


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Titletext.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(), "please enter Title!!!", Toast.LENGTH_SHORT).show();

                }else{
                    if(TextUtils.isEmpty(PriceText.getText().toString().trim())){
                        Toast.makeText(getContext(), "please enter Price!!!", Toast.LENGTH_SHORT).show();
                    }else{
                        if(TextUtils.isEmpty(DetailsTxt.getText().toString().trim())){
                            Toast.makeText(getContext(), "please enter ad details!!!", Toast.LENGTH_SHORT).show();

                        }else{

                            if(TextUtils.isEmpty(NameTxt.getText().toString().trim())){
                                Toast.makeText(getContext(), "please enter Contact Name!!!", Toast.LENGTH_SHORT).show();

                            }else{
                                if(TextUtils.isEmpty(EmailTxt.getText().toString().trim())){
                                    Toast.makeText(getContext(), "please enter valid Email!!!", Toast.LENGTH_SHORT).show();

                                }else{
                                    if(TextUtils.isEmpty(PhoneTxt.getText().toString().trim())){
                                        Toast.makeText(getContext(), "please enter Contact Phone!!!", Toast.LENGTH_SHORT).show();

                                    }else{
                                        AlertDialog.Builder ald=new AlertDialog.Builder(getContext());
                                        ald.setMessage("Post has been Submitted!!!");
                                        ald.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent=new Intent(getActivity(), MainActivity.class);
                                                startActivity(intent);
                                            }
                                        });
                                        ald.show();



                                    }
                                }

                            }

                        }
                    }

                }

            }
        });


        return view;
    }

    private void selectIMG(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 76);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==76 && resultCode == RESULT_OK && data!=null) {
            imgUri=data.getData();



            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),imgUri);
                selectimage.setImageBitmap(bitmap);
            }catch (IOException e){
                Toast.makeText(getContext(), "bad: "+e, Toast.LENGTH_SHORT).show();
            }




        } else {
            Toast.makeText(getContext(), "Please select a file", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            selectIMG();
        }else {
            Toast.makeText(getContext(), "please provide permission", Toast.LENGTH_SHORT).show();
        }
    }






}
