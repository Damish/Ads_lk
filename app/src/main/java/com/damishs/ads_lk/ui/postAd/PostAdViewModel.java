package com.damishs.ads_lk.ui.postAd;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PostAdViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PostAdViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is post ad fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}