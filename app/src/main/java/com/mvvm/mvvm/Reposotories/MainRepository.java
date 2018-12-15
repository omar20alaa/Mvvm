package com.mvvm.mvvm.Reposotories;

import com.mvvm.mvvm.Model.MainModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;


// singleton pattern

public class MainRepository {

    private static MainRepository instance;
    private ArrayList<MainModel> dataSet = new ArrayList<>();

    public static MainRepository getInstance() {
        if (instance == null) {
            instance = new MainRepository();
        }

        return instance;
    }

    public MutableLiveData<List<MainModel>> getNicePlace() {
        setNicePlaces();
        MutableLiveData<List<MainModel>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setNicePlaces() {
        dataSet.add(new MainModel("http://blogmedia.dealerfire.com/wp-content/uploads/sites/223/2016/08/android-robot-icon-22.png"
                , "Place 1"));

        dataSet.add(new MainModel("https://zdnet3.cbsistatic.com/hub/i/2016/08/08/7ef3afcf-ec15-44da-a066-b22bf58dcca4/98dcadc9295d1592c0443697633455e5/android-security-1.jpg"
                , "Place 2"));

        dataSet.add(new MainModel("https://www.android.com/static/2016/img/share/oreo-lg.jpg"
                , "Place 3"));

        dataSet.add(new MainModel("https://www.android.com/static/2016/img/share/oreo-lg.jpg"
                , "Place 4"));
        dataSet.add(new MainModel("http://blogmedia.dealerfire.com/wp-content/uploads/sites/223/2016/08/android-robot-icon-22.png"
                , "Place 5"));

        dataSet.add(new MainModel("https://zdnet3.cbsistatic.com/hub/i/2016/08/08/7ef3afcf-ec15-44da-a066-b22bf58dcca4/98dcadc9295d1592c0443697633455e5/android-security-1.jpg"
                , "Place 6"));

        dataSet.add(new MainModel("https://www.android.com/static/2016/img/share/oreo-lg.jpg"
                , "Place 7"));

        dataSet.add(new MainModel("https://www.android.com/static/2016/img/share/oreo-lg.jpg"
                , "Place 8"));
        dataSet.add(new MainModel("http://blogmedia.dealerfire.com/wp-content/uploads/sites/223/2016/08/android-robot-icon-22.png"
                , "Place 9"));

        dataSet.add(new MainModel("https://zdnet3.cbsistatic.com/hub/i/2016/08/08/7ef3afcf-ec15-44da-a066-b22bf58dcca4/98dcadc9295d1592c0443697633455e5/android-security-1.jpg"
                , "Place 10"));

        dataSet.add(new MainModel("https://www.android.com/static/2016/img/share/oreo-lg.jpg"
                , "Place 11"));

        dataSet.add(new MainModel("https://www.android.com/static/2016/img/share/oreo-lg.jpg"
                , "Place 12"));

    }
}
