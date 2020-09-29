package com.damishs.ads_lk.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.damishs.ads_lk.R;

public class ItemProfile extends AppCompatActivity implements View.OnClickListener {

    TextView text1;
    Button btnBack;
    String receivedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_profile);

        text1= findViewById(R.id.textViewId);
        btnBack = findViewById(R.id.btnGoBack);

        Intent intent = getIntent();
        receivedPosition=intent.getStringExtra(ResultsRecyclerView.POSITION);

        text1.setText(receivedPosition);

        Toast.makeText(this, "Received Position:"+receivedPosition, Toast.LENGTH_SHORT).show();

        btnBack.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.btnGoBack:
                Intent intent = new Intent(this,ResultsRecyclerView.class);
                startActivity(intent);
                finish();
        }

    }
}
