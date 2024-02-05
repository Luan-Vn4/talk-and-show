package br.com.talk_and_show.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;

public class DetailedCardViewModel extends AndroidViewModel implements SelectableItemViewModel<CommCardCategories>{

    private final MutableLiveData<CommCard> currentSelectedCard = new MutableLiveData<>();


    public DetailedCardViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<CommCard> getCurrentSelectedCard() {
        return currentSelectedCard;
    }

    public String getCurrentName() {
        return currentSelectedCard.getValue().getName();
    }
    public String getCurrentCategory() {
       return currentSelectedCard.getValue().getCategory().toString();
    }
    public int getCurrentImage() {
        return currentSelectedCard.getValue().getImage();
    }
    public void setCurrentName(String currentName) {
        this.currentSelectedCard.setValue(new CommCard(currentName,
                currentSelectedCard.getValue().getCategory(), currentSelectedCard.getValue().getImage()));
    }
    public void setCurrentCategory(CommCardCategories currentCategory) {
        this.currentSelectedCard.setValue(new CommCard(currentSelectedCard.getValue().getName(),
                currentCategory, currentSelectedCard.getValue().getImage()));
    }
    public void setCurrentImage(int currentImage) {
        this.currentSelectedCard.setValue(new CommCard(currentSelectedCard.getValue().getName(),
                currentSelectedCard.getValue().getCategory(), currentImage));
    }


    @Override
    public void onItemSelected(CommCardCategories dataObject) {

    }

    @Override
    public void onItemSelected(CommCard currentSelectedCard) {
        this.currentSelectedCard.setValue(currentSelectedCard);
    }

}
