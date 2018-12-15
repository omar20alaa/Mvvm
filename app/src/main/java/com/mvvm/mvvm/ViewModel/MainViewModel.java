package com.mvvm.mvvm.ViewModel;

import android.os.AsyncTask;

import com.mvvm.mvvm.Model.MainModel;
import com.mvvm.mvvm.Reposotories.MainRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    // vars
    private MutableLiveData<List<MainModel>> mNicePlaces;
    private MainRepository mainRepository;
    private MutableLiveData<Boolean> mIsUpdating  = new MutableLiveData<>();

    public void init() {
        if (mNicePlaces != null) {
            return;
        }
        mainRepository = MainRepository.getInstance();
        mNicePlaces = mainRepository.getNicePlace();
        }

        public void addNewValue(final MainModel mainModel)
        {
            mIsUpdating.setValue(true);

            new AsyncTask<Void , Void , Void>()
            {
                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    List<MainModel> currentPlaces = mNicePlaces.getValue();
                    currentPlaces.add(mainModel);
                    mNicePlaces.postValue(currentPlaces);
                    mIsUpdating.setValue(false);
                }

                @Override
                protected Void doInBackground(Void... voids) {

                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {

                    }

                    return null;
                }
            }.execute();
        }

        public LiveData<Boolean> getIsUpdating()
        {
            return mIsUpdating;
        }

    public LiveData<List<MainModel>> getNicePlaces() {
        return mNicePlaces;
    }

}
