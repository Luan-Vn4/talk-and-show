package br.com.talk_and_show.adapters;

import android.os.Parcel;
import android.os.Parcelable;
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

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

    public static class CardsViewHolder extends RecyclerView.ViewHolder {
        private final CardView cardBackround;
        private final TextView cardName;
        private final ImageView cardImage;

        public CardsViewHolder(@NonNull View itemView) {
            super(itemView);

            // Extracting view cards fields to fill
            this.cardBackround = itemView.findViewById(R.id.cardBackground);
            this.cardName = itemView.findViewById(R.id.fragment_card_card_name);
            this.cardImage = itemView.findViewById(R.id.fragment_card_image);
        }

        public void bind(CommCard card) {
            this.cardBackround.setBackgroundTintList(ContextCompat.getColorStateList(
                    this.itemView.getContext(), card.getCategory().getColor()));
            this.cardImage.setImageResource(card.getImage());
            this.cardName.setText(card.getName());
        }
    }

    // Atributos
    private ArrayList<CommCard> cardsList;

    // Métodos de acesso
    public CardsAdapter(ArrayList<CommCard> cardsList) {
        this.cardsList = cardsList;
    }

    // Métodos
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

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
