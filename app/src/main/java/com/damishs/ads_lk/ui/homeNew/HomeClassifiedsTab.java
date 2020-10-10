package com.damishs.ads_lk.ui.homeNew;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

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


public class HomeClassifiedsTab extends Fragment implements MyAdapter2.OnItemListener, MyAdapter4.OnItemListener, AdapterView.OnItemClickListener {


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
        View root =inflater.inflate(R.layout.home_classifieds_tab_4, container, false);


        // this is data for recycler view
        ArrImageUrl.add("https://i0.wp.com/www.society19.com/wp-content/uploads/2018/06/chocolate-cake-houston.jpg?fit=1000%2C750&ssl=1");ArrImageUrl.add("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/HLPE2?wid=1144&hei=1144&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1507158270169");ArrImageUrl.add("https://i5.walmartimages.com/asr/5da7cd4c-3585-4f37-8bf4-02323ddaf124_1.430e428b3cd47988efbce2b83555ce2a.jpeg");ArrImageUrl.add("https://www.notebookcheck.net/uploads/tx_nbc2/2-103-e1587727512700.jpg");ArrImageUrl.add("https://geniusmobile.lk/wp-content/uploads/2020/02/Mi-Powerbank-3-Genius.jpg");ArrImageUrl.add("https://www.digitalsave.co.uk/images/thumbnails/465/465/detailed/7/official-apple-lightning-cable.png");ArrImageUrl.add("https://i5.walmartimages.com/asr/29a6a03b-7389-4aec-88c5-378bc47c5c31_1.e5f61e35863a57ca520bf312c1617843.jpeg?odnWidth=612&odnHeight=612&odnBg=ffffff");
        ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("06-10-2020");ArrPublishedDate.add("06-10-2020");
        ArrAdId.add("1");ArrAdId.add("2");ArrAdId.add("3");ArrAdId.add("4");ArrAdId.add("5");ArrAdId.add("6");ArrAdId.add("7");
        ArrAdName.add("Chocolate Cake");ArrAdName.add("Boss Headphones");ArrAdName.add("Iphone Xs");ArrAdName.add("Asus Vivobook");ArrAdName.add("Mi PowerBank");ArrAdName.add("Lightning cable");ArrAdName.add("PS5");
        ArrSellerName.add("Saman");ArrSellerName.add("Fernando");ArrSellerName.add("Namal");ArrSellerName.add("Eric");ArrSellerName.add("Saman");ArrSellerName.add("Perera");ArrSellerName.add("Rohan");
        ArrSpecialText.add("Chocolate flavour");ArrSpecialText.add("White color");ArrSpecialText.add("Gold color");ArrSpecialText.add("10th Gen.");ArrSpecialText.add("10000mah");ArrSpecialText.add("for Iphones");ArrSpecialText.add("5th Gen.");
        ArrPrice.add("4,000");ArrPrice.add("120,000");ArrPrice.add("260,000");ArrPrice.add("190,000");ArrPrice.add("3,000");ArrPrice.add("2,000");ArrPrice.add("100,000");


        for (int i = 1; i <= ArrAdName.size(); i++) {
            AdItem adlistItem = new AdItem(ArrImageUrl.get(i - 1), ArrPublishedDate.get(i - 1), "", ArrAdName.get(i - 1), "by " + ArrSellerName.get(i - 1), ArrSpecialText.get(i - 1), "Rs." + ArrPrice.get(i - 1));
            listItems.add(adlistItem);
        }



        // 1. get a reference to recyclerView
//        final RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        final RecyclerView recyclerView2 = (RecyclerView) root.findViewById(R.id.recyclerViewClassifieds);

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
