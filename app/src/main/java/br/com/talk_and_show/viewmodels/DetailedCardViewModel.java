package br.com.talk_and_show.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.Objects;

import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;
import br.com.talk_and_show.viewmodels.uistates.CardDisplayUISate;

public class DetailedCardViewModel extends AndroidViewModel implements SelectableItemViewModel<CommCard>{

    private final MutableLiveData<CommCard> currentSelectedCard = new MutableLiveData<>();


    public DetailedCardViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<CommCard> getCurrentSelectedCard() {
        return currentSelectedCard;
    }
    private String name;
    private String category;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public void onItemSelected(CommCard currentSelectedCard) {
        this.currentSelectedCard.setValue(currentSelectedCard);
    }

    public void fetchCardsToDisplay() {
        this.currentSelectedCard.setValue(Objects.requireNonNull(currentSelectedCard.getValue()
        ));
    }
}
