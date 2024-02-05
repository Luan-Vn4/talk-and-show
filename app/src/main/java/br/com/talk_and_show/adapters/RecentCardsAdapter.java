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

import br.com.talk_and_show.R;
import br.com.talk_and_show.databinding.FragmentCardBinding;
import br.com.talk_and_show.models.CommCard;

public class RecentCardsAdapter extends RecyclerView.Adapter<RecentCardsAdapter.RecentCardsViewHolder> {

    private ArrayList<CommCard> cardsList;

    public RecentCardsAdapter(ArrayList<CommCard> cardsList) {
        this.cardsList = cardsList;
    }

    static class RecentCardsViewHolder extends RecyclerView.ViewHolder {
        private final TextView cardName;
        private final ImageView cardImage;
        private final CardView cardBackground;


        RecentCardsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardName = itemView.findViewById(R.id.fragment_card_card_name);
            this.cardImage = itemView.findViewById(R.id.fragment_card_image);
            this.cardBackground = itemView.findViewById(R.id.cardBackground);
        }

        void bind(CommCard card) {
            this.cardName.setText((CharSequence) card.getName());
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
