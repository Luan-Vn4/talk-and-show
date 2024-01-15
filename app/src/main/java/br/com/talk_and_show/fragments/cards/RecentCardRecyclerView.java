package br.com.talk_and_show.fragments.cards;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.talk_and_show.R;
import br.com.talk_and_show.adapters.RecentCardsAdapter;
import br.com.talk_and_show.databinding.FragmentRecentCardRecyclerViewBinding;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;

public class RecentCardRecyclerView extends Fragment {
    FragmentRecentCardRecyclerViewBinding binding;

    public static RecentCardRecyclerView newInstance() {
        return new RecentCardRecyclerView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentRecentCardRecyclerViewBinding.inflate(
                                        getLayoutInflater(), container, false);

        configureRecyclerView(this.binding.recentCardRecyclerView);

        return binding.getRoot();
    }

    private void configureRecyclerView(RecyclerView recyclerView) {
        recyclerView.setAdapter(new RecentCardsAdapter(getCardsList()));
        recyclerView.setLayoutManager(new LinearLayoutManager(
                recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));

        Drawable horizontalDivider = ContextCompat.getDrawable(
                recyclerView.getContext(), R.drawable.divider_horizontal_grid);

        CustomDividerItemDecoration divider = new CustomDividerItemDecoration(
                recyclerView.getContext(), DividerItemDecoration.HORIZONTAL, horizontalDivider, false, true);

        recyclerView.addItemDecoration(divider);
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