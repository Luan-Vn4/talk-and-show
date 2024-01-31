package br.com.talk_and_show.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import br.com.talk_and_show.models.CommCardCategories;

public class MainActivityViewModel extends AndroidViewModel {
    private final MutableLiveData<CommCardCategories> currentSelectedCategory = new MutableLiveData<>();

    public LiveData<CommCardCategories> getCurrentSelectedCategory() {
        return this.currentSelectedCategory;
    }

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
}
