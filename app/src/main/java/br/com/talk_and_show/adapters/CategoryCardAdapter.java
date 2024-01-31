package br.com.talk_and_show.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.talk_and_show.R;
import br.com.talk_and_show.databinding.FragmentCategoryCardBinding;
import br.com.talk_and_show.models.CommCardCategories;
import br.com.talk_and_show.viewmodels.SelectableItemViewModel;

public class CategoryCardAdapter extends RecyclerView.Adapter<CategoryCardAdapter.CategoryCardViewHolder> {
    private final List<CommCardCategories> commCardCategoriesList;
    private final SelectableItemViewModel<CommCardCategories> selectableItemViewModel;

    public CategoryCardAdapter(List<CommCardCategories> commCardCategoriesList,
                               SelectableItemViewModel<CommCardCategories> selectableItemViewModel) {
        this.commCardCategoriesList = commCardCategoriesList;
        this.selectableItemViewModel = selectableItemViewModel;
    }

    class CategoryCardViewHolder extends RecyclerView.ViewHolder {
        //private final SelectableItemViewModel<CommCardCategories> selectableItemViewModel;
        private final  View rootView;
        private final TextView categoryName;
        private final ImageView categoryImage;
        private final CardView categoryBackground;

        CategoryCardViewHolder(View categoryCardView) {
            super(categoryCardView);
            this.rootView = categoryCardView;
            this.categoryName = categoryCardView.findViewById(R.id.fragment_category_card_category_name);
            this.categoryImage = categoryCardView.findViewById(R.id.fragment_category_card_image);
            this.categoryBackground = categoryCardView.findViewById(R.id.fragment_category_card_card_view);
        }

        void setSelectedListener(View categoryCardView, CommCardCategories selectedCategory) {
            categoryCardView.setOnClickListener(view ->
                selectableItemViewModel.onItemSelected(selectedCategory)
            );
        }

        void bind(CommCardCategories commCardCategories) {
            this.categoryName.setText(commCardCategories.getName());
            this.categoryImage.setImageResource(commCardCategories.getImage());
            this.categoryBackground.setBackgroundTintList(ContextCompat.getColorStateList(
                    this.itemView.getContext(), commCardCategories.getColor()));
            this.setSelectedListener(this.rootView, commCardCategories);
        }
    }

    @NonNull
    @Override
    public CategoryCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryCardView = FragmentCategoryCardBinding.inflate(LayoutInflater.from(parent.getContext())).getRoot();
        return new CategoryCardViewHolder(categoryCardView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryCardViewHolder holder, int position) {
        CommCardCategories commCardCategory = this.commCardCategoriesList.get(position);

        holder.bind(commCardCategory);
    }

    @Override
    public int getItemCount() {
        return this.commCardCategoriesList.size();
    }



}
