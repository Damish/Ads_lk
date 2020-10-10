package com.damishs.ads_lk.ui.profile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.damishs.ads_lk.MainActivity;
import com.damishs.ads_lk.R;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class EditProfileFragment extends Fragment {
    private View view;
    private EditText name,email,phone,city;
    private Spinner type,town;
    private Button cancel,save;
    private ImageButton profimg;
    private Uri imgUri;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_edit_profile, container, false);


        Bundle bundle = this.getArguments();
        name=(EditText)view.findViewById(R.id.name_edit_txt);
        email=(EditText)view.findViewById(R.id.email_edit_txt);
        phone=(EditText)view.findViewById(R.id.phone_edit_txt);
        town=(Spinner)view.findViewById(R.id.spinner_town);
        //city=(EditText)view.findViewById(R.id.city_edit_txt);
        type=(Spinner)view.findViewById(R.id.type_spinner);
        cancel=(Button)view.findViewById(R.id.cancel_btn);
        save=(Button)view.findViewById(R.id.save_btn);
        profimg=(ImageButton)view.findViewById(R.id.profile_imgbtn1);

        setData(bundle);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent=new Intent(getActivity(),MainActivity.class);

                Bundle bundle2 = new Bundle();
                bundle2.putString("name",name.getText().toString());
                bundle2.putString("email",email.getText().toString());
                bundle2.putString("phone",phone.getText().toString());
                bundle2.putString("type",type.getSelectedItem().toString());
                bundle2.putString("town",town.getSelectedItem().toString());
                //bundle2.putString("city",city.getText().toString());

                ProfileFragment fragment1 = new ProfileFragment();
                fragment1.setArguments(bundle2);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

//                ft.remove(new E());
                ft.replace(R.id.nav_host_fragment, fragment1);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        profimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectIMG();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);
                }
            }
        });



        return view;
    }


    private void setData(Bundle bundle){
        name.setText(getArguments().getString("name"));
        email.setText(getArguments().getString("email"));
        phone.setText(getArguments().getString("phone"));
        town.setSelection(((ArrayAdapter<String>)town.getAdapter()).getPosition(getArguments().getString("town")));
       // city.setText(getArguments().getString("city"));

        type.setSelection(((ArrayAdapter<String>)type.getAdapter()).getPosition(getArguments().getString("type")));
    }

    private void selectIMG(){
        Intent pickImageIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        pickImageIntent.setType("image/*");
        pickImageIntent.putExtra("crop", "true");
        pickImageIntent.putExtra("outputX", 160);
        pickImageIntent.putExtra("outputY", 160);
        pickImageIntent.putExtra("aspectX", 1);
        pickImageIntent.putExtra("aspectY", 1);
        pickImageIntent.putExtra("scale", true);
        pickImageIntent.putExtra("outputFormat",
                Bitmap.CompressFormat.JPEG.toString());
        startActivityForResult(pickImageIntent, 76);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==76 && resultCode == RESULT_OK && data!=null) {
            imgUri=data.getData();


            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),imgUri);
                Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth()/2, bitmap.getHeight()/2, Bitmap.Config.ARGB_8888);
                BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                Paint paint = new Paint();
                paint.setShader(shader);
                paint.setAntiAlias(true);
                Canvas c = new Canvas(circleBitmap);
                c.drawCircle(bitmap.getWidth() / 4, bitmap.getHeight() / 4, bitmap.getWidth() / 4, paint);



                profimg.setImageBitmap(circleBitmap);



            }catch (IOException e){
                Toast.makeText(getContext(), "Error: "+e, Toast.LENGTH_SHORT).show();
            }



        }
    }
}