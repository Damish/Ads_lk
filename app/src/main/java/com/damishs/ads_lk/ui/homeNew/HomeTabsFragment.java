package com.damishs.ads_lk.ui.homeNew;

import android.graphics.Color;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.damishs.ads_lk.R;
import com.damishs.ads_lk.ui.dashboard.PageController;
import com.damishs.ads_lk.ui.home.AdItem;
import com.damishs.ads_lk.ui.home.MyAdapter2;
import com.damishs.ads_lk.ui.home.MyAdapter4;
import com.damishs.ads_lk.ui.home.MyAdapter5;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeTabsFragment extends Fragment implements View.OnClickListener,MyAdapter2.OnItemListener,MyAdapter4.OnItemListener, MyAdapter5.OnItemListener, AdapterView.OnItemClickListener{


    private TabLayout mTabLayout;
    private TabItem home,a1,a2,a3;
    private ViewPager mPager;
    private HomePageController homePageController;
    public HomeTabsFragment homeTabsFragment;
    ImageButton button2,button3,button4,button5,button6;



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

    public TextView buttonShowMostRecent;

    public AutoCompleteTextView actv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_tab_view, container, false);

        buttonShowMostRecent = root.findViewById(R.id.buttonShowMostRecent2);


        mPager = root.findViewById(R.id.viewpagerHome);
        button2 = root.findViewById(R.id.button2);
        button3 = root.findViewById(R.id.button3);
        button4 = root.findViewById(R.id.button4);
        button5 = root.findViewById(R.id.button5);
        button6 = root.findViewById(R.id.button6);


        //Resolve Error when loading  with home Navigation View : Damish :)
        //use getChildFragmentManager() instead of getSupportFragmentManager()
        homePageController = new HomePageController(this.getChildFragmentManager(),5);
        mPager.setAdapter(homePageController);
        mPager.setCurrentItem(0);


        button2.setOnClickListener(new View.OnClickListener(){//Onclick Houses Tab
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "On click Button Houses", Toast.LENGTH_SHORT).show();

                mPager.setCurrentItem(0);

            }
        });

        button3.setOnClickListener(new View.OnClickListener(){//Onclick Vehicles Tab
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "On click Button Vehicles", Toast.LENGTH_SHORT).show();


                mPager.setCurrentItem(1);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){//Onclick Vehicles Tab
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "On click Button Properties", Toast.LENGTH_SHORT).show();


                mPager.setCurrentItem(2);
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){//Onclick Vehicles Tab
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "On click Button Food", Toast.LENGTH_SHORT).show();


                mPager.setCurrentItem(3);
            }
        });

        button6.setOnClickListener(new View.OnClickListener(){//Onclick Vehicles Tab
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "On click Button Classifieds", Toast.LENGTH_SHORT).show();


                mPager.setCurrentItem(4);
            }
        });



        // this is data for most recent ads recycler view

        ArrImageUrl.add("https://static.hitad.lk/assets/uploads/image_2258ab083a.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/btAUXonKWJM/maxresdefault.jpg");ArrImageUrl.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-audi-q7-mmp-1-1591218923.jpg");ArrImageUrl.add("https://www.carshowroom.com.au/media/21491910/2018-jaguar-e-pace-r-dynamic-p-300-awd-36-0318.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/EvszYleNR4o/maxresdefault.jpg");ArrImageUrl.add("https://www.ukautocenter.com/wp-content/uploads/2019/05/gallery_used-car-one2car-in-process-thailand_2458975_dyzzyJ1O002AWE668gnHjf.jpg");ArrImageUrl.add("https://cnet4.cbsistatic.com/img/fBt45enJ2ezvbEOV5NvMi-JNUDY=/2018/07/12/4c0986b2-1beb-4bf5-9abe-ffee6867b9d4/2018-bmw-x3-ogi.jpg");ArrImageUrl.add("https://i.ytimg.com/vi/aPVirls5qQ4/maxresdefault.jpg");
        ArrPublishedDate.add("1 min ago");ArrPublishedDate.add("1 hour ago");ArrPublishedDate.add("1 hour ago");ArrPublishedDate.add("5 hours ago");ArrPublishedDate.add("1 day ago");ArrPublishedDate.add("1 day ago");ArrPublishedDate.add("1 day ago");ArrPublishedDate.add("1 day ago");
        ArrAdId.add("1");ArrAdId.add("2");ArrAdId.add("3");ArrAdId.add("4");ArrAdId.add("5");ArrAdId.add("6");ArrAdId.add("7");ArrAdId.add("8");
        ArrAdName.add("House for sale in Matara");ArrAdName.add("Mercedez Benz S400");ArrAdName.add("Audi Q7");ArrAdName.add("Jaguar E-Pace");ArrAdName.add("BMW i8");ArrAdName.add("Mercedez Benz S300");ArrAdName.add("BMW X3");ArrAdName.add("Audi Q5");
        ArrSellerName.add("Saman");ArrSellerName.add("Saman");ArrSellerName.add("Fernando");ArrSellerName.add("Namal");ArrSellerName.add("Eric");ArrSellerName.add("Saman");ArrSellerName.add("Perera");ArrSellerName.add("Rohan");
        ArrSpecialText.add("");ArrSpecialText.add("10,000Km");ArrSpecialText.add("81,000Km");ArrSpecialText.add("42,000Km");ArrSpecialText.add("63,000Km");ArrSpecialText.add("94,000Km");ArrSpecialText.add("25,000Km");ArrSpecialText.add("36,000Km");
        ArrPrice.add("600,000");ArrPrice.add("600,000");ArrPrice.add("740,000");ArrPrice.add("960,000");ArrPrice.add("210,000");ArrPrice.add("90,000");ArrPrice.add("2,100,000");ArrPrice.add("1,000,000");


        for (int i=1;i<=ArrAdName.size();i++){
            AdItem adlistItem = new AdItem(ArrImageUrl.get(i-1),"posted "+ArrPublishedDate.get(i-1),"",ArrAdName.get(i-1),"by "+ArrSellerName.get(i-1),ArrSpecialText.get(i-1),"Rs."+ArrPrice.get(i-1));
            listItems.add(adlistItem);
        }

        ///////////Auto complete text view//////////////////
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.select_dialog_item, ArrAdName);
        actv = root.findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.BLUE);
        actv.setCompletionHint("Search results ");
        actv.setOnItemClickListener(this);
        /////////////////////////////



        //Most-Recent Ads-Recycler View
        final RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);


        // 2. set layoutManger
        //Most recent ads-all functions related to recycler view
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1, GridLayoutManager.HORIZONTAL, false));
        adapter2 = new MyAdapter2(listItems,this.getContext(), this);
        recyclerView.setAdapter(adapter2);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        buttonShowMostRecent.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "On Click Most Recent show/hide:"+buttonShowMostRecent.getText(), Toast.LENGTH_SHORT).show();

                if(buttonShowMostRecent.getText().equals("Hide")) {
                    recyclerView.setVisibility(View.GONE);
                    buttonShowMostRecent.setText("Show");
                }else if (buttonShowMostRecent.getText().equals("Show")) {
                    recyclerView.setVisibility(View.VISIBLE);
                    buttonShowMostRecent.setText("Hide");
                }

//                HomeFragment homeFragment1 =  new HomeFragment();
//                homeFragment1.selectedLayout="List";

            }
        });

        mPager.setOnPageChangeListener (new ViewPager.OnPageChangeListener() {
           float pos;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if(position+positionOffset>pos){
                    recyclerView.setVisibility(View.GONE);
                }

                pos =position+positionOffset;

                if(recyclerView.getVisibility() == View.VISIBLE)
                {
                    buttonShowMostRecent.setText("Hide");
                }else{
                    buttonShowMostRecent.setText("Show");
                }
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        return root;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}