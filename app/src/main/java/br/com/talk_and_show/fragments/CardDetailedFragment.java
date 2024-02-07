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
import br.com.talk_and_show.databinding.FragmentCardsDetailedBinding;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.viewmodels.DetailedCardViewModel;
import br.com.talk_and_show.viewmodels.SelectableItemViewModel;


public class CardDetailedFragment extends Fragment{
    DetailedCardViewModel detailedCardViewModel;
    FragmentCardsDetailedBinding binding;
    SelectableItemViewModel<CommCard> selectableItemViewModel;



    public static CardDetailedFragment newInstance(String cardName, String cardCategory, int cardImage) {
        Bundle args = new Bundle();
        args.putString("CardName", cardName);
        args.putString("CardCategory", cardCategory);
        args.putInt("CardImage", cardImage);

        CardDetailedFragment detailedCardFragment = new CardDetailedFragment();
        detailedCardFragment.setArguments(args);

        return detailedCardFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.detailedCardViewModel = new ViewModelProvider(this).get(DetailedCardViewModel.class);

        if (this.getArguments() != null) {
            Log.w("Argumento", this.getArguments().getString("CardName"));
            detailedCardViewModel.setName(this.getArguments().getString("CardName"));
            Log.w("Argumento", this.getArguments().getString("CardCategory"));
            detailedCardViewModel.setCategory(this.getArguments().getString("CardCategory"));
            Log.w("Argumento", String.valueOf(this.getArguments().getInt("CardImage")));
            detailedCardViewModel.setImage(this.getArguments().getInt("CardImage"));
        }
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

        this.binding.titulo.setText(detailedCardViewModel.getName());
        this.binding.categoria.setText(detailedCardViewModel.getCategory());
        this.binding.imagemSelecionada.setBackgroundResource(detailedCardViewModel.getImage());

        
    }

}
