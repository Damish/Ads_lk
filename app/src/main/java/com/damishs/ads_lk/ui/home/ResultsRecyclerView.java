package com.damishs.ads_lk.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.damishs.ads_lk.R;

import java.util.ArrayList;
import java.util.List;

public class ResultsRecyclerView extends AppCompatActivity implements MyAdapter.OnItemListener{

    public static final String POSITION ="1";
    private static final String TAG = "SomeActivity";
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter2;
    public List<ListItem> listItems = new ArrayList<>();
    public List<String> ItemNames = new ArrayList<>();
    public AutoCompleteTextView actv;
    public TextView SelectedACTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SelectedACTV=findViewById(R.id.SelectedACTV);

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,ItemNames);


        actv=findViewById(R.id.autoCompleteTextView);

        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.BLUE);
        actv.setCompletionHint("Search results ");

        /////////////////////////////

        for (int i=1;i<=ItemNames.size();i++){

            Toast.makeText(this,"No of Results = " + i , Toast.LENGTH_SHORT).show();

            ListItem listItem = new ListItem(ItemNames.get(i-1),"Code : 000" + (i-1));
            listItems.add(listItem);

        }

        adapter2= new MyAdapter(listItems,this, this);
        recyclerView.setAdapter(adapter2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bottom_nav_menu,menu);
        return true;
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onItemClick(int position) {

        String sendPosition= String.valueOf(position+1);

        Log.d(TAG, "onItemClick: Clicked."  + position+1);
        Intent intent = new Intent(this, ItemProfile.class);
        intent.putExtra(POSITION,sendPosition);
        Toast.makeText(this, "Position:"+sendPosition, Toast.LENGTH_LONG).show();
        startActivity(intent);
        finish();
    }
}

