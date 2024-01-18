package br.com.talk_and_show.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;







import br.com.talk_and_show.databinding.ActivityMainBinding;
import br.com.talk_and_show.fragments.cards.CardsRecyclerViewFragment;
import br.com.talk_and_show.fragments.cards.RecentCardRecyclerView;
import br.com.talk_and_show.fragments.homeToolbar.HomeToolbarFragment;


public class MainActivity extends AppCompatActivity {
    // Properties
    ActivityMainBinding binding;


    // LifeCycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .add(this.binding.activityMainFragmentToolbar.getId(), HomeToolbarFragment.newInstance())
                .add(this.binding.activityMainFragmentRecyclerViewCategories.getId(), CardsRecyclerViewFragment.newInstance())
                .add(this.binding.activityMainFragmentRecyclerViewRecentCards.getId(), RecentCardRecyclerView.newInstance())
                .commit();
    }
}