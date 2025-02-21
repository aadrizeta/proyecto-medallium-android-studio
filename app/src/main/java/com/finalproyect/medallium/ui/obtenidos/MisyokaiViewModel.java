package com.finalproyect.medallium.ui.obtenidos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MisyokaiViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MisyokaiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}