package br.com.talk_and_show.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import br.com.talk_and_show.adapters.CardsAdapter;
import br.com.talk_and_show.databinding.FragmentCardsDisplayBinding;
import br.com.talk_and_show.fragments.listviews.RecyclerViewFragment;
import br.com.talk_and_show.fragments.listviews.itemdecorations.ItemOffsetDecoration;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;
import br.com.talk_and_show.viewmodels.CardsDisplayViewModel;
import br.com.talk_and_show.viewmodels.SelectableItemViewModel;

public class CardsDisplayFragment extends Fragment {
    CardsDisplayViewModel cardsDisplayViewModel;
    FragmentCardsDisplayBinding binding;
    SelectableItemViewModel<CommCard> selectableItemViewModel;

    public static CardsDisplayFragment newInstance(String sessionLabelName) {
        Bundle args = new Bundle();
        args.putString("sessionLabelName", sessionLabelName);

        CardsDisplayFragment cardsDisplayFragment = new CardsDisplayFragment();
        cardsDisplayFragment.setArguments(args);

        return cardsDisplayFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.cardsDisplayViewModel = new ViewModelProvider(this).get(CardsDisplayViewModel.class);

        cardsDisplayViewModel.fetchCardsToDisplay();
        if (this.getArguments() != null) {
            Log.w("Argumento", this.getArguments().getString("sessionLabelName"));
            cardsDisplayViewModel.setCurrentStringLabel(this.getArguments().getString("sessionLabelName"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentCardsDisplayBinding.inflate(inflater, container, false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.fragmentCardsDisplayCategoryLabel.setText(this.cardsDisplayViewModel.getCurrentStringLabel());

        this.cardsDisplayViewModel.getCardDisplayUISate().observe(getViewLifecycleOwner(), cardDisplayUISate ->
            this.loadRecyclerViewFragment()
        );
    }

    private void loadRecyclerViewFragment() {
        this.getChildFragmentManager().beginTransaction()
            .replace(this.binding.fragmentCardsDisplayRecyclerView.getId(), createRecyclerView())
            .setReorderingAllowed(true)
            .commit();
    }

    private RecyclerViewFragment createRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        CardsAdapter cardsAdapter = new CardsAdapter(selectableItemViewModel, this.cardsDisplayViewModel.getCurrentCardsList());

        RecyclerViewFragment cardsRVFragment = RecyclerViewFragment.newInstance(gridLayoutManager, cardsAdapter);
        cardsRVFragment.setPadding(60, 60, 60, 60);

        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(
                cardsRVFragment.getPaddingTop(), cardsRVFragment.getPaddingBottom());

        cardsRVFragment.setItemDecoration(itemOffsetDecoration);

        return cardsRVFragment;
    }
}
