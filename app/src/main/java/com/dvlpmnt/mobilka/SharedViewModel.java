package com.dvlpmnt.mobilka;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<Data> itemData = new MutableLiveData<>();

    public void setItemData(Data value) {
        itemData.setValue(value);
    }

    public LiveData<Data> getItemData() {
        return itemData;
    }
}
