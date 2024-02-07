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
import br.com.talk_and_show.models.CommCardCategories;
import br.com.talk_and_show.viewmodels.SelectableItemViewModel;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

    private static SelectableItemViewModel<CommCard> selectableItemViewModel;



    static class CardsViewHolder extends RecyclerView.ViewHolder {
        private final View rootView;
        private final CardView cardBackground;
        private final TextView cardName;
        private final ImageView cardImage;

        CardsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.rootView = itemView;

            // Extracting view cards fields to fill
            this.cardBackground = itemView.findViewById(R.id.cardBackground);
            this.cardName = itemView.findViewById(R.id.fragment_card_card_name);
            this.cardImage = itemView.findViewById(R.id.fragment_card_image);
        }

        private void setRootViewListener(CommCard card) {
            this.rootView.setOnClickListener(view ->
                selectableItemViewModel.onItemSelected(card)
            );
        }

        void bind(final CommCard card) {
            this.cardBackground.setBackgroundTintList(ContextCompat.getColorStateList(
                    this.itemView.getContext(), card.getCategory().getColor()));
            this.cardImage.setImageResource(card.getImage());
            this.cardName.setText(card.getName());
            this.setRootViewListener(card);
        }

    }

    // Atributos
    private List<CommCard> cardsList;

    // Métodos de acesso
    public CardsAdapter(SelectableItemViewModel<CommCard> selectableItemViewModel, List<CommCard> cardsList) {
        this.selectableItemViewModel = selectableItemViewModel;
        this.cardsList = cardsList;
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
