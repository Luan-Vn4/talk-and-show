package com.example.myapplication.fragments.cards;

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

import com.example.myapplication.R;
import com.example.myapplication.adapters.RecentCardsAdapter;
import com.example.myapplication.databinding.FragmentRecentCardRecyclerViewBinding;
import com.example.myapplication.models.CommCardCategories;
import com.example.myapplication.models.CommCard;

import java.util.ArrayList;



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

    private static <CommCard> ArrayList<CommCard> getCardsList() {
        return new ArrayList<CommCard>() {{
            add((CommCard) new com.example.myapplication.models.CommCard("Sujeitos", CommCardCategories.SUJEITO, 0));
            add((CommCard) new com.example.myapplication.models.CommCard("Verbos", CommCardCategories.VERBO, 0));
            add((CommCard) new com.example.myapplication.models.CommCard("Objetos", CommCardCategories.OBJETO, 0));
            add((CommCard) new com.example.myapplication.models.CommCard("Adjetivos", CommCardCategories.ADJETIVO, 0));
            add((CommCard) new com.example.myapplication.models.CommCard("Adverbios", CommCardCategories.ADVERBIO, 0));
            add((CommCard) new com.example.myapplication.models.CommCard("Próprios", CommCardCategories.PROPRIO, 0));
        }};
    }

}