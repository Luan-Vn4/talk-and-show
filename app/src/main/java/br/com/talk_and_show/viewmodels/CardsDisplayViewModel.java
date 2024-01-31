package br.com.talk_and_show.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.talk_and_show.R;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;
import br.com.talk_and_show.viewmodels.uistates.CardDisplayUISate;

public class CardsDisplayViewModel extends AndroidViewModel {
    private final MutableLiveData<CardDisplayUISate> cardDisplayUISate = new MutableLiveData<>(new CardDisplayUISate());

    public CardsDisplayViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<CardDisplayUISate> getCardDisplayUISate() {
        return cardDisplayUISate;
    }

    public void fetchCardsToDisplay(){
        this.cardDisplayUISate.setValue(new CardDisplayUISate(
                Objects.requireNonNull(cardDisplayUISate.getValue()).getSessionLabelName(),
                getCardsList()
        ));
    }

    public void setCurrentStringLabel(String currentStringLabel) {
        this.cardDisplayUISate.setValue(new CardDisplayUISate(
                currentStringLabel,
                Objects.requireNonNull(cardDisplayUISate.getValue()).getCardsDisplayed()
        ));
    }

    public String getCurrentStringLabel() {
        return Objects.requireNonNull(this.cardDisplayUISate.getValue()).getSessionLabelName();
    }

    public List<CommCard> getCurrentCardsList() {
        return Objects.requireNonNull(this.cardDisplayUISate.getValue()).getCardsDisplayed();
    }

    private static ArrayList<CommCard> getCardsList() {
        return new ArrayList<CommCard>() {{
            add(new CommCard("EU", CommCardCategories.SUJEITO, R.drawable.icon_adjetivos));
            add(new CommCard("TU", CommCardCategories.SUJEITO, R.drawable.icon_adjetivos));
            add(new CommCard("ELE", CommCardCategories.SUJEITO, R.drawable.icon_adjetivos));
            add(new CommCard("ELA", CommCardCategories.SUJEITO, R.drawable.icon_adjetivos));
            add(new CommCard("NÓS", CommCardCategories.SUJEITO, R.drawable.icon_adjetivos));
            add(new CommCard("VÓS", CommCardCategories.SUJEITO, R.drawable.icon_adjetivos));
        }};
    }

}
