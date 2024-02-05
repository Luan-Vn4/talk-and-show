package br.com.talk_and_show.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import br.com.talk_and_show.adapters.CardsAdapter;
import br.com.talk_and_show.databinding.FragmentCardsDetailedBinding;
import br.com.talk_and_show.fragments.listviews.RecyclerViewFragment;
import br.com.talk_and_show.fragments.listviews.itemdecorations.ItemOffsetDecoration;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.viewmodels.DetailedCardViewModel;
import br.com.talk_and_show.viewmodels.SelectableItemViewModel;


public class CardDetailedFragment extends Fragment{
    DetailedCardViewModel detailedCardViewModel;
    FragmentCardsDetailedBinding binding;
    SelectableItemViewModel<CommCard> selectableItemViewModel;



    public static CardDetailedFragment newInstance(String cardName) {
        Bundle args = new Bundle();
        args.putString("CardName", cardName);

        CardDetailedFragment detailedCardFragment = new CardDetailedFragment();
        detailedCardFragment.setArguments(args);

        return detailedCardFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.detailedCardViewModel = new ViewModelProvider(this).get(DetailedCardViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentCardsDetailedBinding.inflate(inflater, container, false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.titulo.setText(detailedCardViewModel.getCurrentName());
        this.binding.categoria.setText(detailedCardViewModel.getCurrentCategory());
        this.binding.imagemSelecionada.setBackgroundResource(detailedCardViewModel.getCurrentImage());

    }

}
