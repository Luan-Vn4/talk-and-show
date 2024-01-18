package br.com.talk_and_show.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import br.com.talk_and_show.R;
import br.com.talk_and_show.adapters.CardsAdapter;
import br.com.talk_and_show.adapters.RecentCardsAdapter;
import br.com.talk_and_show.databinding.ActivityMainBinding;
import br.com.talk_and_show.fragments.listviews.RecyclerViewFragment;
import br.com.talk_and_show.fragments.hometoolbar.HomeToolbarFragment;
import br.com.talk_and_show.fragments.listviews.RecentCardRecyclerView;
import br.com.talk_and_show.fragments.listviews.itemdecorations.ItemOffsetDecoration;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;

public class MainActivity extends AppCompatActivity {
    // Properties
    ActivityMainBinding binding;


    // LifeCycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .add(this.binding.activityMainFragmentToolbar.getId(), HomeToolbarFragment.newInstance())
                .add(this.binding.activityMainFragmentRecyclerViewCategories.getId(), createCategoryRecyclerViewFragment())
                .add(this.binding.activityMainFragmentRecyclerViewRecentCards.getId(), createRecentRecyclerViewFragment())
                .commit();
    }

    private RecyclerViewFragment createCategoryRecyclerViewFragment() {
        GridLayoutManager layoutManager = new GridLayoutManager(this.binding.getRoot().getContext(), 2);
        CardsAdapter cardsAdapter = new CardsAdapter(getCardsList());

        RecyclerViewFragment cardsRVFragment = RecyclerViewFragment
                                                        .newInstance(layoutManager, cardsAdapter);
        cardsRVFragment.setPadding(60, 60, 60, 60);

        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(
                cardsRVFragment.getPaddingTop(), cardsRVFragment.getPaddingLeft());

        cardsRVFragment.setItemDecoration(itemOffsetDecoration);

        return cardsRVFragment;
    }

    private RecyclerViewFragment createRecentRecyclerViewFragment() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this.binding.getRoot().getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecentCardsAdapter recentCardsAdapter = new RecentCardsAdapter(getCardsList());

        RecyclerViewFragment recentCardRV = RecyclerViewFragment.newInstance(layoutManager, recentCardsAdapter);
        recentCardRV.setPadding(60, 30, 60, 30);

        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(
                recentCardRV.getPaddingTop(), recentCardRV.getPaddingBottom());

        recentCardRV.setItemDecoration(itemOffsetDecoration);

        return recentCardRV;

        R.layout.fragment
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