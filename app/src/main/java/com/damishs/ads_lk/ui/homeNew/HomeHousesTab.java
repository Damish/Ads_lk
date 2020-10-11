package com.damishs.ads_lk.ui.homeNew;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.damishs.ads_lk.R;
import com.damishs.ads_lk.ui.home.AdItem;
import com.damishs.ads_lk.ui.home.MyAdapter2;
import com.damishs.ads_lk.ui.home.MyAdapter4;

import java.util.ArrayList;
import java.util.List;


public class HomeHousesTab extends Fragment implements MyAdapter2.OnItemListener, MyAdapter4.OnItemListener, AdapterView.OnItemClickListener {


    public static final String POSITION = "1";
    private static final String TAG = "SomeActivity";
    //Data
    public List<String> ArrImageUrl = new ArrayList<>();
    public List<String> ArrPublishedDate = new ArrayList<>();
    public List<String> ArrAdId = new ArrayList<>();
    public List<String> ArrAdName = new ArrayList<>();
    public List<String> ArrSellerName = new ArrayList<>();
    public List<String> ArrSpecialText = new ArrayList<>();
    public List<String> ArrPrice = new ArrayList<>();

    public List<AdItem> listItems = new ArrayList<>();
    private RecyclerView.Adapter adapter2;
    private RecyclerView.Adapter adapter4;
    private RecyclerView.Adapter adapter5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =inflater.inflate(R.layout.home_houses_tab_0, container, false);


        // this is data for recycler view
        ArrImageUrl.add("https://static.hitad.lk/assets/uploads/image_2258ab083a.jpg");ArrImageUrl.add("https://i6h9d8c7.stackpathcdn.com/wp-content/uploads/2017/09/House-for-sale-Aluthgama-119642315-1740x960-c-center.jpg");ArrImageUrl.add("https://propertymate.lk/wp-content/uploads/2019/01/propertymate.lk-Luxury-House-for-Sale-in-Kesbewa-11.jpg");ArrImageUrl.add("https://hhgolding.com/wp-content/uploads/2019/02/4-Bedroom-House-for-sale-Maharagama-2-1200x640.jpg");ArrImageUrl.add("https://i.pinimg.com/originals/93/af/fe/93affed65c9758540d2fbcce9610f539.jpg");ArrImageUrl.add("https://images.adsttc.com/media/images/5e58/4b4d/6ee6/7e67/1c00/011a/newsletter/Images_(4).jpg?1582844736");ArrImageUrl.add("https://i.pinimg.com/originals/95/50/c5/9550c5a8ccecfcc8ff5dc6da9d9a2183.jpg");
        ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("06-10-2020");ArrPublishedDate.add("06-10-2020");
        ArrAdId.add("1");ArrAdId.add("2");ArrAdId.add("3");ArrAdId.add("4");ArrAdId.add("5");ArrAdId.add("6");ArrAdId.add("7");
        ArrAdName.add("House for sale in Matara");ArrAdName.add("House in colombo-8");ArrAdName.add("House with Land ,Galle");ArrAdName.add("House for sale in Deniyaya");ArrAdName.add("House in Matara");ArrAdName.add("Galle House and Land");ArrAdName.add("Newly Build House Kandy");
        ArrSellerName.add("Saman");ArrSellerName.add("Fernando");ArrSellerName.add("Namal");ArrSellerName.add("Eric");ArrSellerName.add("Saman");ArrSellerName.add("Perera");ArrSellerName.add("Rohan");
        ArrSpecialText.add("1km to malabe town");ArrSpecialText.add("price nego.");ArrSpecialText.add("price nego.");ArrSpecialText.add("price nego.");ArrSpecialText.add("price nego.");ArrSpecialText.add("price nego.");ArrSpecialText.add("price nego.");
        ArrPrice.add("600,000");ArrPrice.add("740,000");ArrPrice.add("960,000");ArrPrice.add("210,000");ArrPrice.add("90,000");ArrPrice.add("2,100,000");ArrPrice.add("1,000,000");


        for (int i = 1; i <= ArrAdName.size(); i++) {
            AdItem adlistItem = new AdItem(ArrImageUrl.get(i - 1), "posted on "+ArrPublishedDate.get(i - 1), "", ArrAdName.get(i - 1), "by " + ArrSellerName.get(i - 1), ArrSpecialText.get(i - 1), "Rs." + ArrPrice.get(i - 1));
            listItems.add(adlistItem);
        }


        // 1. get a reference to recyclerView
//        final RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        final RecyclerView recyclerView2 = (RecyclerView) root.findViewById(R.id.recyclerViewHouses);

        //All Ads Recycler View
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter4 = new MyAdapter4(listItems, this.getContext(), this);
        recyclerView2.setAdapter(adapter4);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());




        return root;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemClick(int position) {

    }
}