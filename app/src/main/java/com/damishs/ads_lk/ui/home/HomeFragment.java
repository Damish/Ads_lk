package com.damishs.ads_lk.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;
import com.damishs.ads_lk.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements MyAdapter.OnItemListener{

    public static final String POSITION ="1";
    private static final String TAG = "SomeActivity";
    private HomeViewModel homeViewModel;
    public List<String> ItemNames = new ArrayList<>();
    public List<ListItem> listItems = new ArrayList<>();
    private  RecyclerView.Adapter adapter2;
    public AutoCompleteTextView actv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // this is data fro recycler view
        ItemNames.add("Apple");
        ItemNames.add("Orange");
        ItemNames.add("Grapes");
        ItemNames.add("Pineapple");
        ItemNames.add("Guava");
        ItemNames.add("Banana");
        ItemNames.add("Cadbury");
        ItemNames.add("Kandos");
        ItemNames.add("Ritsbury");
        ItemNames.add("Oreo");
        ItemNames.add("Chocolate Biscuit");
        ItemNames.add("Gold Marie");


        /////////////////////////////

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.select_dialog_item,ItemNames);


        actv=root.findViewById(R.id.autoCompleteTextView);

        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.BLUE);
        actv.setCompletionHint("Search results ");

        /////////////////////////////



        for (int i=1;i<=ItemNames.size();i++){

            //Toast.makeText(this,"No of Results = " + i , Toast.LENGTH_SHORT).show();

            ListItem listItem = new ListItem(ItemNames.get(i-1),"Code : 000" + (i-1));
            listItems.add(listItem);

        }

        // 3. create an adapter
        adapter2 = new MyAdapter(listItems,this.getContext(), this);
        // 4. set adapter
        recyclerView.setAdapter(adapter2);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return root;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void onItemClick(int position) {

        String sendPosition= String.valueOf(position+1);

        Log.d(TAG, "onItemClick: Clicked."  + position+1);
        Intent intent = new Intent(getActivity(), ItemProfile.class);
        intent.putExtra(POSITION,sendPosition);
        Toast.makeText(this.getContext(), "Position:"+sendPosition, Toast.LENGTH_LONG).show();
        startActivity(intent);
        //getActivity().finish();
    }
}