package com.damishs.ads_lk.ui.dashboard;

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
import androidx.viewpager.widget.ViewPager;

import com.damishs.ads_lk.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    private TabLayout mTabLayout;
    private TabItem home,a1,a2,a3;
    private ViewPager mPager;
    private PageController pageController;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });





        mTabLayout=root.findViewById(R.id.tablayout);
        home=root.findViewById(R.id.home);
        a1=root.findViewById(R.id.home1);
        a2=root.findViewById(R.id.home2);
        a3=root.findViewById(R.id.home3);
        mPager = root.findViewById(R.id.viewpager);

        pageController = new PageController(getActivity().getSupportFragmentManager(),mTabLayout.getTabCount());
        mPager.setAdapter(pageController);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        return root;
    }
}