package com.damishs.ads_lk.ui.postAd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.damishs.ads_lk.R;

public class PostAdFragment extends Fragment {

    private PostAdViewModel postAdViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        postAdViewModel =
                ViewModelProviders.of(this).get(PostAdViewModel.class);
        View root = inflater.inflate(R.layout.fragment_post_ad, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        postAdViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}