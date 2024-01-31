package br.com.talk_and_show.activities;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import br.com.talk_and_show.R;
import br.com.talk_and_show.adapters.CardsAdapter;
import br.com.talk_and_show.databinding.ActivityMainBinding;
import br.com.talk_and_show.databinding.CardViewBinding;
import br.com.talk_and_show.databinding.FragmentCardBinding;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;

public class CardView extends AppCompatActivity {

    ActivityMainBinding binding;
    CardViewBinding cardViewBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommCard commCard = getIntent().getParcelableExtra("commCard");

        // Exibe os detalhes na UI
        if (commCard != null) {
            String cardTitle = getIntent().getStringExtra("title");
            String cardCategory = getIntent().getStringExtra("category");
            int cardImageResId = getIntent().getIntExtra("imageResId", 0);

            // Obter o CardModel da Intent
            CommCard selectedCard = getIntent().getParcelableExtra("commCard");

            cardViewBinding.titulo.setText(selectedCard.getName());
            cardViewBinding.categoria.setText(selectedCard.getCategory().toString());
            cardViewBinding.imagemSelecionada.setImageResource(selectedCard.getImage());
        }
    }
}
