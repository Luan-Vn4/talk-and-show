package br.com.talk_and_show.viewmodels.uistates;

import java.util.List;

import br.com.talk_and_show.models.CommCard;

public class CardDisplayUISate {
    private String sessionLabelName;
    private List<CommCard> cardsDisplayed;

    public CardDisplayUISate(){}

    public CardDisplayUISate(String sessionLabelName, List<CommCard> cardsDisplayed) {
        this.sessionLabelName = sessionLabelName;
        this.cardsDisplayed = cardsDisplayed;
    }

    public String getSessionLabelName() {
        return this.sessionLabelName;
    }

    public List<CommCard> getCardsDisplayed() {
        return this.cardsDisplayed;
    }

}
