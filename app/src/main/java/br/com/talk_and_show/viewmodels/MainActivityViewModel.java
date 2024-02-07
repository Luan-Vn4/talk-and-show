package br.com.talk_and_show.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;

public class MainActivityViewModel extends AndroidViewModel implements SelectableItemViewModel<CommCardCategories> {
    private final MutableLiveData<CommCardCategories> currentSelectedCategory = new MutableLiveData<>();
    private final MutableLiveData<CommCard> currentSelectedCard = new MutableLiveData<>();

    public LiveData<CommCardCategories> getCurrentSelectedCategory() {
        return this.currentSelectedCategory;
    }
    public LiveData<CommCard> getCurrentSelectedCard() {
        return this.currentSelectedCard;
    }

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onItemSelected(CommCardCategories selectedCategory) {
        this.currentSelectedCategory.setValue(selectedCategory);
    }

}
