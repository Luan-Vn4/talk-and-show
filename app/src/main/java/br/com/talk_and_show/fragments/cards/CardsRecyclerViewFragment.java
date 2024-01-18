package com.example.myapplication.fragments.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.CardsAdapter;
import com.example.myapplication.databinding.FragmentCardsRecyclerViewBinding;
import com.example.myapplication.models.CommCard;
import com.example.myapplication.models.CommCardCategories;
import com.google.android.material.divider.MaterialDividerItemDecoration;

import java.util.ArrayList;


public class CardsRecyclerViewFragment extends Fragment {
    FragmentCardsRecyclerViewBinding binding;

    public static CardsRecyclerViewFragment newInstance() {
        return new CardsRecyclerViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.binding = FragmentCardsRecyclerViewBinding.inflate(inflater, container, false);

        configureRecyclerView(this.binding.cardsRecyclerView);

        return this.binding.getRoot();
    }

    private static void configureRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(createGridLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new CardsAdapter(getCardsList()));

        Drawable verticalDrawer = ContextCompat.getDrawable(recyclerView.getContext(), R.drawable.divider_vertical_grid);
        Drawable horizontalDrawer = ContextCompat.getDrawable(recyclerView.getContext(), R.drawable.divider_horizontal_grid);

        //CustomDividerItemDecoration dividerVertical = new CustomDividerItemDecoration(
                //recyclerView.getContext(), DividerItemDecoration.VERTICAL, verticalDrawer, true, true);

        MaterialDividerItemDecoration dividerVertical = new MaterialDividerItemDecoration(
                recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerVertical.setLastItemDecorated(false);
        dividerVertical.setDividerThickness(24);
        //CustomDividerItemDecoration dividerHorizontal = new CustomDividerItemDecoration(
                //recyclerView.getContext(), DividerItemDecoration.HORIZONTAL, horizontalDrawer, true, true);

        MaterialDividerItemDecoration dividerHorizontal = new MaterialDividerItemDecoration(
                recyclerView.getContext(), DividerItemDecoration.HORIZONTAL);
        dividerHorizontal.setLastItemDecorated(false);
        dividerHorizontal.setDividerThickness(24);

        recyclerView.addItemDecoration(dividerVertical);
        recyclerView.addItemDecoration(dividerHorizontal);
    }

    private static GridLayoutManager createGridLayoutManager(Context context) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        return gridLayoutManager;
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

    @Override
    public void onPause() {
        super.onPause();
    }
}


