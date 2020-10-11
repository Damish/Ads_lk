package com.damishs.ads_lk.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.damishs.ads_lk.R;
import com.damishs.ads_lk.ui.home.AdItem;
import com.damishs.ads_lk.ui.home.HomeFragment;
import com.damishs.ads_lk.ui.home.MyAdapter2;
import com.damishs.ads_lk.ui.homeNew.HomeTabsFragment;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment implements MyAdapterCategory.OnItemListener, AdapterView.OnItemClickListener{

    public static final String POSITION ="1";
    private static final String TAG = "SomeActivity";

    //Data
    public List<String> ArrCategoryName = new ArrayList<>();
    public List<String> ArrNoOfResults = new ArrayList<>();

    Button btnBack4;
    public List<CategoryItem> listItems = new ArrayList<>();
    private  RecyclerView.Adapter categoryAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_category, container, false);

        btnBack4 = root.findViewById(R.id.btnGoBack4);

        // 1. get a reference to recyclerView
        final RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.categoryRecyclerView);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        // this is data for recycler view
        ArrCategoryName.add("Architecture");ArrCategoryName.add("Buildings");ArrCategoryName.add("Cameras");ArrCategoryName.add("Education");ArrCategoryName.add("Food");ArrCategoryName.add("Health");ArrCategoryName.add("Weddings");ArrCategoryName.add("Mobile Phones");ArrCategoryName.add("Bicycles");ArrCategoryName.add("Computers");
        ArrNoOfResults.add("1,211");ArrNoOfResults.add("5,176");ArrNoOfResults.add("7,289");ArrNoOfResults.add("12,534");ArrNoOfResults.add("9866");ArrNoOfResults.add("2,577");ArrNoOfResults.add("4,635");ArrNoOfResults.add("1,534");ArrNoOfResults.add("980");ArrNoOfResults.add("3,720");


        for (int i=1;i<=ArrCategoryName.size();i++){
            CategoryItem categoryItem = new CategoryItem(ArrCategoryName.get(i-1),ArrNoOfResults.get(i-1)+" Results");
            listItems.add(categoryItem);
        }


        // 3. create an adapter
        categoryAdapter = new MyAdapterCategory(listItems,this.getContext(), this);


        // 4. set adapter
        recyclerView.setAdapter(categoryAdapter);



        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        btnBack4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                HomeTabsFragment homeFragment = new HomeTabsFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,homeFragment).addToBackStack(null).commit();


            }
        });


        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemClick(int position) {

    }
}