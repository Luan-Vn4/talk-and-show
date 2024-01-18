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


public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

    private ArrayList<CommCard> cardsList;

    public CardsAdapter(ArrayList<CommCard> cardsList) {
        this.cardsList = cardsList;
    }

    /**
     * Wrapper class to encapsulate the binding of {@link CommCard} objects, that is, it will receive
     * a {@link View} itemView that is the representation of the card by the onCreateViewHolder method
     * of the adapter class on runtime. Then, it will bind the data received from the card from
     * the onBindViewHolder method of the adapter class
     */
    public class CardsViewHolder extends RecyclerView.ViewHolder {
        private CardView cardBackround;
        private TextView cardName;
        private ImageView cardImage;

        public CardsViewHolder(@NonNull View itemView) {
            super(itemView);

            // Extracting view cards fields to fill
            this.cardBackround = itemView.findViewById(R.id.cardBackground);
            this.cardName = itemView.findViewById(R.id.cardName);
            this.cardImage = itemView.findViewById(R.id.imageView);
        }

        public void bind(CommCard card) {
            this.cardBackround.setBackgroundTintList(ContextCompat.getColorStateList(
                    this.itemView.getContext(), card.getCategory().getColor()));
            this.cardImage.setImageResource(card.getImage());
            this.cardName.setText(card.getName());
        }
    }

    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = FragmentCardBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false).getRoot();

        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        return new CardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {
        CommCard card = this.cardsList.get(position);
        holder.bind(card);
    }

    @Override
    public int getItemCount() {
        return this.cardsList.size();
    }
}
