package com.example.testapp.ui.TikTok;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TiktokViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TiktokViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText () {
        return mText;
    }
}