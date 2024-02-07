package br.com.talk_and_show.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import br.com.talk_and_show.databinding.ActivityMainBinding;
import br.com.talk_and_show.fragments.CardDetailedFragment;
import br.com.talk_and_show.fragments.CardsDisplayFragment;
import br.com.talk_and_show.fragments.HomePageFragment;
import br.com.talk_and_show.fragments.toolbars.hometoolbar.HomeToolbarFragment;
import br.com.talk_and_show.models.CommCard;
import br.com.talk_and_show.models.CommCardCategories;
import br.com.talk_and_show.viewmodels.DetailedCardViewModel;
import br.com.talk_and_show.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    // Properties
    MainActivityViewModel mainActivityViewModel;
    DetailedCardViewModel detailedCardViewModel;
    ActivityMainBinding binding;

    // LifeCycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isFirstCreatedActivity = savedInstanceState == null;

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        this.detailedCardViewModel = new ViewModelProvider(this).get(DetailedCardViewModel.class);
        this.mainActivityViewModel.getCurrentSelectedCategory().observe(this, this::onSelectedCategoryObserver);
        this.detailedCardViewModel.getCurrentSelectedCard().observe(this, this::onSelectedCardObserver);

        /* Caso a Activity esteja sendo recriada, não é necessário adicionar os Fragments,
           pois o método da superclasse ".onCreate" já restaura as instâncias */
        if (isFirstCreatedActivity) {
            this.configureFragments();
        }
    }

    private void onSelectedCategoryObserver (CommCardCategories commCard) {
        this.getSupportFragmentManager().beginTransaction()
            .setReorderingAllowed(true)
            .replace(this.binding.activityMainFragmentHomepage.getId(), CardsDisplayFragment.newInstance(commCard.getName()))
            .addToBackStack("navigateToCategory")
            .commit();
    }
    private void onSelectedCardObserver (CommCard commCard) {
        this.getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(this.binding.activityMainFragmentHomepage.getId(), CardDetailedFragment.newInstance(commCard.getName(), commCard.getCategory().toString(), commCard.getImage()))
                .addToBackStack("navigateToCard")
                .commit();
    }

    private void configureFragments() {
        getSupportFragmentManager()
            .beginTransaction()
            .setReorderingAllowed(true)
            .replace(this.binding.activityMainFragmentToolbar.getId(), HomeToolbarFragment.newInstance())
            .replace(this.binding.activityMainFragmentHomepage.getId(), HomePageFragment.newInstance(this.mainActivityViewModel, this.detailedCardViewModel))
            .commit();
    }

}