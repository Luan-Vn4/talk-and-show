package br.com.talk_and_show.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import br.com.talk_and_show.adapters.CardsAdapter;
import br.com.talk_and_show.adapters.CategoryCardAdapter;
import br.com.talk_and_show.databinding.FragmentHomepageBinding;
import br.com.talk_and_show.fragments.listviews.RecyclerViewFragment;
import br.com.talk_and_show.fragments.listviews.itemdecorations.ItemOffsetDecoration;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;

public class HomePageFragment extends Fragment {
    FragmentHomepageBinding binding;

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.binding = FragmentHomepageBinding.inflate(inflater, container, false);

        this.getChildFragmentManager()
                .beginTransaction()
                .add(this.binding.fragmentHomepageRecyclerViewCategories.getId(), createCategoryRecyclerViewFragment())
                .add(this.binding.fragmentHomepageRecyclerViewRecentCards.getId(), createRecentRecyclerViewFragment())
                .commit();

        return this.binding.getRoot();
    }

    private RecyclerViewFragment createCategoryRecyclerViewFragment() {
        GridLayoutManager layoutManager = new GridLayoutManager(this.binding.getRoot().getContext(), 2);
        CategoryCardAdapter categoryCardAdapter = new CategoryCardAdapter(CommCardCategories.getValuesList());

        RecyclerViewFragment cardsRVFragment = RecyclerViewFragment
                .newInstance(layoutManager, categoryCardAdapter);
        cardsRVFragment.setPadding(60, 60, 60, 60);

        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(
                cardsRVFragment.getPaddingTop(), cardsRVFragment.getPaddingLeft());

        cardsRVFragment.setItemDecoration(itemOffsetDecoration);

        return cardsRVFragment;
    }

    private RecyclerViewFragment createRecentRecyclerViewFragment() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this.binding.getRoot().getContext(), LinearLayoutManager.HORIZONTAL, false);
        CardsAdapter cardsAdapter = new CardsAdapter(getCardsList());

        RecyclerViewFragment recentCardRV = RecyclerViewFragment.newInstance(layoutManager, cardsAdapter);
        recentCardRV.setPadding(60, 30, 60, 30);

        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(
                recentCardRV.getPaddingTop(), recentCardRV.getPaddingBottom());

        recentCardRV.setItemDecoration(itemOffsetDecoration);

        return recentCardRV;
    }

    private static ArrayList<CommCard> getCardsList() {
        return new ArrayList<CommCard>() {{
            add(new CommCard("Sujeitos", CommCardCategories.SUJEITO, 0));
            add(new CommCard("Verbos", CommCardCategories.VERBO, 0));
            add(new CommCard("Objetos", CommCardCategories.OBJETO, 0));
            add(new CommCard("Adjetivos", CommCardCategories.ADJETIVO, 0));
            add(new CommCard("Advérbios", CommCardCategories.ADVERBIO, 0));
            add(new CommCard("Próprios", CommCardCategories.PROPRIO, 0));
        }};
    }

}
