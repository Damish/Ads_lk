package com.damishs.ads_lk.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.damishs.ads_lk.MainActivity;
import com.damishs.ads_lk.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemProfileFragment extends Fragment implements View.OnClickListener {

    private static final String TAG2 = "SomeActivity";


    TextView txtAdName,txtPublishedDate,txtAdSellerName,txtPrice,seller_name2,callButton;
    Button btnBack2;
    String receivedPosition;
    ImageView ItemProfileImage,imageView;

    //Data
    public List<String> ArrImageUrl = new ArrayList<>();
    public List<String> ArrPublishedDate = new ArrayList<>();
    public List<String> ArrAdId = new ArrayList<>();
    public List<String> ArrAdName = new ArrayList<>();
    public List<String> ArrSellerName = new ArrayList<>();
    public List<String> ArrSpecialText = new ArrayList<>();
    public List<String> ArrPrice = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_item_profile_2, container, false);

        txtAdName= root.findViewById(R.id.AdName);
        txtPublishedDate= root.findViewById(R.id.AdDate);
        txtAdSellerName= root.findViewById(R.id.AdSellerName);
        btnBack2 = root.findViewById(R.id.btnGoBack2);
        ItemProfileImage= root.findViewById(R.id.ItemProfileImage);
        txtPrice = root.findViewById(R.id.txtPrice);
        seller_name2= root.findViewById(R.id.seller_name2);
        callButton= root.findViewById(R.id.callButton);
        imageView= root.findViewById(R.id.imageView);


        ArrImageUrl.add("https://i.ytimg.com/vi/btAUXonKWJM/maxresdefault.jpg");ArrImageUrl.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-audi-q7-mmp-1-1591218923.jpg");ArrImageUrl.add("https://www.carshowroom.com.au/media/21491910/2018-jaguar-e-pace-r-dynamic-p-300-awd-36-0318.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/EvszYleNR4o/maxresdefault.jpg");ArrImageUrl.add("https://www.ukautocenter.com/wp-content/uploads/2019/05/gallery_used-car-one2car-in-process-thailand_2458975_dyzzyJ1O002AWE668gnHjf.jpg");ArrImageUrl.add("https://cnet4.cbsistatic.com/img/fBt45enJ2ezvbEOV5NvMi-JNUDY=/2018/07/12/4c0986b2-1beb-4bf5-9abe-ffee6867b9d4/2018-bmw-x3-ogi.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/aPVirls5qQ4/maxresdefault.jpg");
        ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("06-10-2020");ArrPublishedDate.add("06-10-2020");
        ArrAdId.add("1");ArrAdId.add("2");ArrAdId.add("3");ArrAdId.add("4");ArrAdId.add("5");ArrAdId.add("6");ArrAdId.add("7");
        ArrAdName.add("Mercedez Benz S400");ArrAdName.add("Audi Q7");ArrAdName.add("Jaguar E-Pace");ArrAdName.add("BMW i8");ArrAdName.add("Mercedez Benz S300");ArrAdName.add("BMW X3");ArrAdName.add("Audi Q5");
        ArrSellerName.add("Saman");ArrSellerName.add("Fernando");ArrSellerName.add("Namal");ArrSellerName.add("Eric");ArrSellerName.add("Saman");ArrSellerName.add("Perera");ArrSellerName.add("Rohan");
        ArrSpecialText.add("10,000Km");ArrSpecialText.add("81,000Km");ArrSpecialText.add("42,000Km");ArrSpecialText.add("63,000Km");ArrSpecialText.add("94,000Km");ArrSpecialText.add("25,000Km");ArrSpecialText.add("36,000Km");
        ArrPrice.add("600,000");ArrPrice.add("740,000");ArrPrice.add("960,000");ArrPrice.add("210,000");ArrPrice.add("90,000");ArrPrice.add("2,100,000");ArrPrice.add("1,000,000");


//        Intent intent = getIntent();
//        receivedPosition=intent.getStringExtra(HomeFragment.POSITION);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            receivedPosition =String.valueOf(bundle.getInt("POS"));
        }

        //receivedPosition ="1";


        txtAdName.setText(ArrAdName.get(Integer.parseInt(receivedPosition)-1));
        txtAdSellerName.setText("by "+ArrSellerName.get(Integer.parseInt(receivedPosition)-1));
        txtPublishedDate.setText("posted on "+ArrPublishedDate.get(Integer.parseInt(receivedPosition)-1));
        txtPrice.setText("Rs."+ArrPrice.get(Integer.parseInt(receivedPosition)-1));
        seller_name2.setText(ArrSellerName.get(Integer.parseInt(receivedPosition)-1));

        String imageUri = ArrImageUrl.get(Integer.parseInt(receivedPosition)-1);
        Picasso.with(this.getContext()).load(imageUri).into(ItemProfileImage);

        //Toast.makeText(this.getContext(), "Received Position:"+receivedPosition, Toast.LENGTH_SHORT).show();
        btnBack2.setOnClickListener(this);


        root.findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialContactPhone("+94712303299");
            }

        });



        return root;
    }


    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnGoBack2:

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                HomeFragment homeFragment = new HomeFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,homeFragment).addToBackStack(null).commit();

                break;
        }

    }
}
