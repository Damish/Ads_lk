package com.damishs.ads_lk.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.damishs.ads_lk.R;
import com.damishs.ads_lk.ui.category.CategoryItem;
import com.damishs.ads_lk.ui.category.MyAdapterCategory;

import java.util.ArrayList;
import java.util.List;


public class SellerProfileFragment extends Fragment implements View.OnClickListener,MyAdapter2.OnItemListener,MyAdapter4.OnItemListener, AdapterView.OnItemClickListener{

    TextView txtSellerName,txtSellerLocation,txtSellerName2;
    public String SellerName,Seller_Location;
    int PositionID;
    RatingBar ratingbar;
    Button btnBack3;

    public List<AdItem> listItems = new ArrayList<>();
    private  RecyclerView.Adapter adapter2;

    //Data
    public List<String> ArrImageUrl = new ArrayList<>();
    public List<String> ArrPublishedDate = new ArrayList<>();
    public List<String> ArrAdId = new ArrayList<>();
    public List<String> ArrAdName = new ArrayList<>();
    public List<String> ArrSellerName = new ArrayList<>();
    public List<String> ArrSpecialText = new ArrayList<>();
    public List<String> ArrPrice = new ArrayList<>();
    public List<String> ArrSellerLocation = new ArrayList<>();



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_seller_profile_2, container, false);


        txtSellerName = root.findViewById(R.id.SellerName);
        txtSellerLocation = root.findViewById(R.id.SellerLocation);
        ratingbar = root.findViewById(R.id.ratingBar);
        txtSellerName2 = root.findViewById(R.id.SellerName2);
        btnBack3 = root.findViewById(R.id.btnGoBack3);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            PositionID = bundle.getInt("POSITION_ID");
            SellerName =bundle.getString("SELLER_NAME");
            Seller_Location =bundle.getString("SELLER_LOCATION");
        }
        txtSellerName.setText(SellerName);
        txtSellerLocation.setText(Seller_Location);
        txtSellerName2.setText(SellerName);
        ratingbar.setRating(3);



        // 1. get a reference to recyclerView
        final RecyclerView recyclerView3 = root.findViewById(R.id.sellerRecyclerView);

        // 2. set layoutManger
        //recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(), 2));



        // this is data for recycler view

        ArrImageUrl.add("https://i.ytimg.com/vi/btAUXonKWJM/maxresdefault.jpg");ArrImageUrl.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-audi-q7-mmp-1-1591218923.jpg");ArrImageUrl.add("https://www.carshowroom.com.au/media/21491910/2018-jaguar-e-pace-r-dynamic-p-300-awd-36-0318.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/EvszYleNR4o/maxresdefault.jpg");ArrImageUrl.add("https://www.ukautocenter.com/wp-content/uploads/2019/05/gallery_used-car-one2car-in-process-thailand_2458975_dyzzyJ1O002AWE668gnHjf.jpg");ArrImageUrl.add("https://cnet4.cbsistatic.com/img/fBt45enJ2ezvbEOV5NvMi-JNUDY=/2018/07/12/4c0986b2-1beb-4bf5-9abe-ffee6867b9d4/2018-bmw-x3-ogi.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/aPVirls5qQ4/maxresdefault.jpg");
        ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("06-10-2020");ArrPublishedDate.add("06-10-2020");
        ArrAdId.add("1");ArrAdId.add("2");ArrAdId.add("3");ArrAdId.add("4");ArrAdId.add("5");ArrAdId.add("6");ArrAdId.add("7");
        ArrAdName.add("Mercedez Benz S400");ArrAdName.add("Audi Q7");ArrAdName.add("Jaguar E-Pace");ArrAdName.add("BMW i8");ArrAdName.add("Mercedez Benz S300");ArrAdName.add("BMW X3");ArrAdName.add("Audi Q5");
        ArrSellerName.add("Saman");ArrSellerName.add("Fernando");ArrSellerName.add("Namal");ArrSellerName.add("Eric");ArrSellerName.add("Saman");ArrSellerName.add("Perera");ArrSellerName.add("Rohan");
        ArrSpecialText.add("10,000Km");ArrSpecialText.add("81,000Km");ArrSpecialText.add("42,000Km");ArrSpecialText.add("63,000Km");ArrSpecialText.add("94,000Km");ArrSpecialText.add("25,000Km");ArrSpecialText.add("36,000Km");
        ArrPrice.add("600,000");ArrPrice.add("740,000");ArrPrice.add("960,000");ArrPrice.add("210,000");ArrPrice.add("90,000");ArrPrice.add("2,100,000");ArrPrice.add("1,000,000");



        for (int i=1;i<=ArrAdName.size();i++){
            AdItem adlistItem = new AdItem(ArrImageUrl.get(i-1),ArrPublishedDate.get(i-1),"",ArrAdName.get(i-1),"by "+ArrSellerName.get(i-1),ArrSpecialText.get(i-1),"Rs."+ArrPrice.get(i-1));
            listItems.add(adlistItem);
        }


        // 3. create an adapter
        adapter2 = new MyAdapter4(listItems,this.getContext(), this);


        // 4. set adapter
        recyclerView3.setAdapter(adapter2);



        // 5. set item animator to DefaultAnimator
        recyclerView3.setItemAnimator(new DefaultItemAnimator());




        btnBack3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                ItemProfileFragment itemProfileFragment = new ItemProfileFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("POS", PositionID+1);
                itemProfileFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,itemProfileFragment).addToBackStack(null).commit();


            }
        });


        return root;

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemClick(int position) {

    }
}