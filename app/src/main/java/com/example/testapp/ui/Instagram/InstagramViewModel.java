package com.example.testapp.ui.Instagram;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InstagramViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InstagramViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("This is instagram fragment");
    }

    public LiveData<String> getText () {
        return mText;
    }
}