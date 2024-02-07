package br.com.talk_and_show.viewmodels;

import br.com.talk_and_show.models.CommCard;

public interface SelectableItemViewModel<DataModel> {
    void onItemSelected(DataModel dataObject);

}
