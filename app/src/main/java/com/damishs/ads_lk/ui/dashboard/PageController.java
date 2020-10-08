package com.damishs.ads_lk.ui.dashboard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageController extends FragmentPagerAdapter {
    int tabCount;
    public PageController(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CarsVehiclesAdvancedSearch();
            case 1:
                return new PropertiesAdvancedSearch();
            case 2:
                return new ClassifiedAdvancedSearch();
            case 3:
                return new BusinessIndustryAdvancedSearch();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

