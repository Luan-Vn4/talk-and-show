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

import java.util.ArrayList;
import java.util.List;

import br.com.talk_and_show.R;
import br.com.talk_and_show.databinding.FragmentCategoryCardBinding;
import br.com.talk_and_show.models.CommCardCategories;

public class CategoryCardAdapter extends RecyclerView.Adapter<CategoryCardAdapter.CategoryCardViewHolder> {

    List<CommCardCategories> commCardCategoriesList;

    public CategoryCardAdapter(List<CommCardCategories> commCardCategoriesList) {
        this.commCardCategoriesList = commCardCategoriesList;
    }

    static class CategoryCardViewHolder extends RecyclerView.ViewHolder {

        private final TextView categoryName;
        private final ImageView categoryImage;
        private final CardView categoryBackground;


        CategoryCardViewHolder(View categoryCardView) {
            super(categoryCardView);
            this.categoryName = categoryCardView.findViewById(R.id.fragment_category_card_category_name);
            this.categoryImage = categoryCardView.findViewById(R.id.fragment_category_card_image);
            this.categoryBackground = categoryCardView.findViewById(R.id.fragment_category_card_card_view);
        }

        void bind(CommCardCategories commCardCategories) {
            this.categoryName.setText(commCardCategories.getName());
            this.categoryImage.setImageResource(commCardCategories.getImage());
            this.categoryBackground.setBackgroundTintList(ContextCompat.getColorStateList(
                    this.itemView.getContext(), commCardCategories.getColor()));
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
