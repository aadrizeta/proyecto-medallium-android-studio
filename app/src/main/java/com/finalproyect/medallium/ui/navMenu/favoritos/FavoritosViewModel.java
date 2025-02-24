package com.finalproyect.medallium.ui.navMenu.favoritos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoritosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FavoritosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ejemplo de favoritos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}