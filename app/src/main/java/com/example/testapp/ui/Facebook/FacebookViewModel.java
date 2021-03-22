package com.example.testapp.ui.Facebook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FacebookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FacebookViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText () {
        return mText;
    }
}