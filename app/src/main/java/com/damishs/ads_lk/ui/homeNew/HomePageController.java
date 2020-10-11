package com.damishs.ads_lk.ui.homeNew;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.damishs.ads_lk.ui.dashboard.BusinessIndustryAdvancedSearch;
import com.damishs.ads_lk.ui.dashboard.CarsVehiclesAdvancedSearch;
import com.damishs.ads_lk.ui.dashboard.ClassifiedAdvancedSearch;
import com.damishs.ads_lk.ui.dashboard.PropertiesAdvancedSearch;

public class HomePageController extends FragmentPagerAdapter {
    int tabCount;
    public HomePageController(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeHousesTab();
            case 1:
                return new HomeVehiclesTab();
            case 2:
                return new HomePropertiesTab();
            case 3:
                return new HomeFoodTab();
            case 4:
                return new HomeClassifiedsTab();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

