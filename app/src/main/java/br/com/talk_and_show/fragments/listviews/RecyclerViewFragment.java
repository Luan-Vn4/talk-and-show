package br.com.talk_and_show.fragments.listviews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import br.com.talk_and_show.databinding.FragmentRecyclerViewBinding;

public class RecyclerViewFragment extends Fragment {
    // Atributos
    FragmentRecyclerViewBinding binding;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter<?> adapter;
    RecyclerView.ItemDecoration itemDecoration;
    int paddingTop;
    int paddingBottom;
    int paddingRight;
    int paddingLeft;

    // Métodos de acesso
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPadding(int left, int top, int right, int bottom) {
        if (this.getRecyclerView() != null) {
            this.recyclerView.setPadding(left, top, right, bottom);
        }
        this.paddingLeft = left;
        this.paddingTop = top;
        this.paddingRight = right;
        this.paddingBottom = bottom;
    }

    public RecyclerView.ItemDecoration getItemDecoration() {
        return itemDecoration;
    }

    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        if (this.getRecyclerView() != null) {
            this.getRecyclerView().addItemDecoration(itemDecoration);
        }
        this.itemDecoration = itemDecoration;
    }

    public static RecyclerViewFragment newInstance(RecyclerView.LayoutManager layoutManager,
                                                   RecyclerView.Adapter<?> adapter) {
        RecyclerViewFragment newInstance = new RecyclerViewFragment();

        newInstance.layoutManager = layoutManager;
        newInstance.adapter = adapter;

        return newInstance;
    }

    // Métodos
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.binding = FragmentRecyclerViewBinding.inflate(inflater, container, false);

        configureRecyclerView(this.binding.cardsRecyclerView);

        return this.binding.getRoot();
    }

    private void configureRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(this.layoutManager);
        recyclerView.setAdapter(this.adapter);
        if (this.getItemDecoration() != null) {recyclerView.addItemDecoration(this.itemDecoration);}
        recyclerView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
