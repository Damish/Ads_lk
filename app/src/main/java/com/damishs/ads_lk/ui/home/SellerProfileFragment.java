package com.damishs.ads_lk.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.damishs.ads_lk.R;


public class SellerProfileFragment extends Fragment implements View.OnClickListener {

    TextView txtSellerName,txtSellerLocation,txtSellerName2;
    public String SellerName,Seller_Location;
    RatingBar ratingbar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_seller_profile_2, container, false);


        txtSellerName = root.findViewById(R.id.SellerName);
        txtSellerLocation = root.findViewById(R.id.SellerLocation);
        ratingbar = root.findViewById(R.id.ratingBar);
        txtSellerName2 = root.findViewById(R.id.SellerName2);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            SellerName =bundle.getString("SELLER_NAME");
            Seller_Location =bundle.getString("SELLER_LOCATION");
        }

        txtSellerName.setText(SellerName);
        txtSellerLocation.setText(Seller_Location);
        txtSellerName2.setText(SellerName);
        ratingbar.setRating(3);

    return root;

    }

    @Override
    public void onClick(View view) {

    }
}