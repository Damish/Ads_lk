package com.damishs.ads_lk.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;
import com.damishs.ads_lk.R;
import com.damishs.ads_lk.ui.postAd.PostUI2;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements MyAdapter2.OnItemListener,MyAdapter4.OnItemListener, MyAdapter5.OnItemListener, AdapterView.OnItemClickListener{

    public static final String POSITION ="1";
    private static final String TAG = "SomeActivity";
    //private HomeViewModel homeViewModel;

    //Data
    public List<String> ArrImageUrl = new ArrayList<>();
    public List<String> ArrPublishedDate = new ArrayList<>();
    public List<String> ArrAdId = new ArrayList<>();
    public List<String> ArrAdName = new ArrayList<>();
    public List<String> ArrSellerName = new ArrayList<>();
    public List<String> ArrSpecialText = new ArrayList<>();
    public List<String> ArrPrice = new ArrayList<>();



    public List<AdItem> listItems = new ArrayList<>();
    private  RecyclerView.Adapter adapter2;
    private  RecyclerView.Adapter adapter4;
    private  RecyclerView.Adapter adapter5;
    public AutoCompleteTextView actv;

    public TextView SelectedACTV;

    public static String selectedLayout = "Grid";

    public TextView buttonShowMostRecent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        buttonShowMostRecent = root.findViewById(R.id.buttonShowMostRecent);


        // this is data for recycler view

        ArrImageUrl.add("https://i.ytimg.com/vi/btAUXonKWJM/maxresdefault.jpg");ArrImageUrl.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-audi-q7-mmp-1-1591218923.jpg");ArrImageUrl.add("https://www.carshowroom.com.au/media/21491910/2018-jaguar-e-pace-r-dynamic-p-300-awd-36-0318.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/EvszYleNR4o/maxresdefault.jpg");ArrImageUrl.add("https://www.ukautocenter.com/wp-content/uploads/2019/05/gallery_used-car-one2car-in-process-thailand_2458975_dyzzyJ1O002AWE668gnHjf.jpg");ArrImageUrl.add("https://cnet4.cbsistatic.com/img/fBt45enJ2ezvbEOV5NvMi-JNUDY=/2018/07/12/4c0986b2-1beb-4bf5-9abe-ffee6867b9d4/2018-bmw-x3-ogi.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/aPVirls5qQ4/maxresdefault.jpg");
        ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("07-10-2020");ArrPublishedDate.add("06-10-2020");ArrPublishedDate.add("06-10-2020");
        ArrAdId.add("1");ArrAdId.add("2");ArrAdId.add("3");ArrAdId.add("4");ArrAdId.add("5");ArrAdId.add("6");ArrAdId.add("7");
        ArrAdName.add("Mercedez Benz S400");ArrAdName.add("Audi Q7");ArrAdName.add("Jaguar E-Pace");ArrAdName.add("BMW i8");ArrAdName.add("Mercedez Benz S300");ArrAdName.add("BMW X3");ArrAdName.add("Audi Q5");
        ArrSellerName.add("Saman");ArrSellerName.add("Fernando");ArrSellerName.add("Namal");ArrSellerName.add("Eric");ArrSellerName.add("Saman");ArrSellerName.add("Perera");ArrSellerName.add("Rohan");
        ArrSpecialText.add("10,000Km");ArrSpecialText.add("81,000Km");ArrSpecialText.add("42,000Km");ArrSpecialText.add("63,000Km");ArrSpecialText.add("94,000Km");ArrSpecialText.add("25,000Km");ArrSpecialText.add("36,000Km");
        ArrPrice.add("600,000");ArrPrice.add("740,000");ArrPrice.add("960,000");ArrPrice.add("210,000");ArrPrice.add("90,000");ArrPrice.add("2,100,000");ArrPrice.add("1,000,000");


        /////////////////////////////

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.select_dialog_item,ArrAdName);


        actv=root.findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.BLUE);
        actv.setCompletionHint("Search results ");
        actv.setOnItemClickListener(this);

        /////////////////////////////


        for (int i=1;i<=ArrAdName.size();i++){
            AdItem adlistItem = new AdItem(ArrImageUrl.get(i-1),ArrPublishedDate.get(i-1),"",ArrAdName.get(i-1),"by "+ArrSellerName.get(i-1),ArrSpecialText.get(i-1),"Rs."+ArrPrice.get(i-1));
            listItems.add(adlistItem);
        }


        // 1. get a reference to recyclerView
        final RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        final RecyclerView recyclerView2 = (RecyclerView) root.findViewById(R.id.recyclerView2);

        // 2. set layoutManger
        //Most recent ads-all functions related to recycler view
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1, GridLayoutManager.HORIZONTAL, false));
        adapter2 = new MyAdapter2(listItems,this.getContext(), this);
        recyclerView.setAdapter(adapter2);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //All ads - two options seperating condition ( Grid / List )
        if(selectedLayout.equals("Grid")){
            recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            adapter4 = new MyAdapter4(listItems,this.getContext(), this);
            recyclerView2.setAdapter(adapter4);
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        else if (selectedLayout.equals("List")){
            recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter5 = new MyAdapter5(listItems,this.getContext(), this);
            recyclerView2.setAdapter(adapter5);
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }




        recyclerView2.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY>oldScrollY){
                    recyclerView.setVisibility(View.GONE);
                }else if (scrollY<oldScrollY){
                   // recyclerView.setVisibility(View.VISIBLE);
                }
                if(recyclerView.getVisibility() == View.VISIBLE)
                {
                    buttonShowMostRecent.setText("Hide");
                }else{
                    buttonShowMostRecent.setText("Show");
                }
            }
        });


        buttonShowMostRecent.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                if(buttonShowMostRecent.getText()=="Hide") {
                    buttonShowMostRecent.setText("Show");
                    recyclerView.setVisibility(View.GONE);
                }else if (buttonShowMostRecent.getText()=="Show") {
                    buttonShowMostRecent.setText("Hide");
                    recyclerView.setVisibility(View.VISIBLE);
                }

//                HomeFragment homeFragment1 =  new HomeFragment();
//                homeFragment1.selectedLayout="List";

            }
        });


        return root;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void onItemClick(int position) {
        actv.setCursorVisible(true);
        String sendPosition= String.valueOf(position+1);
        Log.d(TAG, "onItemClick: Clicked."  + position+1);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        // fetch the user selected value
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(this.getActivity(), "Selected Item is: \t" + item, Toast.LENGTH_LONG).show();
    }
}