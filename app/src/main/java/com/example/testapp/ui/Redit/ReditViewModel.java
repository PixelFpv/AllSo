package com.example.testapp.ui.Redit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReditViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReditViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText () {
        return mText;
    }
}