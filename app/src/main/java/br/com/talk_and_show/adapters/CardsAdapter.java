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
import br.com.talk_and_show.databinding.FragmentCardBinding;
import br.com.talk_and_show.models.CommCard;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

    private ArrayList<CommCard> cardList;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(CommCard position);

    }

    static class CardsViewHolder extends RecyclerView.ViewHolder {
        private final CardView cardBackground;
        private final TextView cardName;
        private final ImageView cardImage;

        CardsViewHolder(@NonNull View itemView) {
            super(itemView);

            // Extracting view cards fields to fill
            this.cardBackground = itemView.findViewById(R.id.cardBackground);
            this.cardName = itemView.findViewById(R.id.fragment_card_card_name);
            this.cardImage = itemView.findViewById(R.id.fragment_card_image);
        }

        void bind(final CommCard card, final OnItemClickListener listener) {
            this.cardBackground.setBackgroundTintList(ContextCompat.getColorStateList(
                    this.itemView.getContext(), card.getCategory().getColor()));
            this.cardImage.setImageResource(card.getImage());
            this.cardName.setText(card.getName());


            // Adiciona um ouvinte de clique para o item da lista
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(card);
                    }
                }
            });
        }

    }

    // Atributos
    private List<CommCard> cardsList;
    private OnItemClickListener itemClickListener;

    // Métodos de acesso
    public CardsAdapter(List<CommCard> cardsList) {
        this.cardsList = cardsList;
        this.itemClickListener = itemClickListener;
    }

    // Métodos
    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = FragmentCardBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false).getRoot();

        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));

        return new CardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {
        CommCard card = this.cardsList.get(position);
        holder.bind(card, itemClickListener);
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

    public CommCard getCard(int position) {
        if (position >= 0 && position < cardsList.size()) {
            return cardsList.get(position);
        }
        return null;
    }
}
