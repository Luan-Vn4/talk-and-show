package br.com.talk_and_show.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.talk_and_show.databinding.ActivityMainBinding;
import br.com.talk_and_show.fragments.HomePageFragment;
import br.com.talk_and_show.fragments.toolbars.hometoolbar.HomeToolbarFragment;

public class MainActivity extends AppCompatActivity {
    // Properties
    ActivityMainBinding binding;

    // LifeCycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.configureFragments();
    }

    private void configureFragments() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(this.binding.activityMainFragmentToolbar.getId(), HomeToolbarFragment.newInstance())
                .add(this.binding.activityMainFragmentHomepage.getId(), HomePageFragment.newInstance())
                .commit();
    }

}