package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentCardBinding;
import com.example.myapplication.models.CommCard;

import java.util.ArrayList;


public class RecentCardsAdapter extends RecyclerView.Adapter<RecentCardsAdapter.RecentCardsViewHolder> {

    private ArrayList<CommCard> cardsList;

    public RecentCardsAdapter(ArrayList<CommCard> cardsList) {
        this.cardsList = cardsList;
    }

    public class RecentCardsViewHolder extends RecyclerView.ViewHolder {
        private TextView cardName;
        private ImageView cardImage;
        private CardView cardBackground;

        public RecentCardsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardName = itemView.findViewById(R.id.cardName);
            this.cardImage = itemView.findViewById(R.id.imageView);
            this.cardBackground = itemView.findViewById(R.id.cardBackground);
        }

        public void bind(CommCard card) {
            this.cardName.setText(card.getName());
            this.cardBackground.setBackgroundTintList(ContextCompat.getColorStateList(
                                this.itemView.getContext(), card.getCategory().getColor()));
            this.cardImage.setImageResource(card.getImage());
        }
    }

    @NonNull
    @Override
    public RecentCardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = FragmentCardBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false).getRoot();

        return new RecentCardsViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentCardsViewHolder holder, int position) {
        CommCard card = this.cardsList.get(position);
        holder.bind(card);
    }

    @Override
    public int getItemCount() {
        return this.cardsList.size();
    }
}
