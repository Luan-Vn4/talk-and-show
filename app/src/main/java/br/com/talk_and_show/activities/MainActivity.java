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
        boolean isFirstCreatedActivity = savedInstanceState == null;

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /* Caso a Activity esteja sendo recriada, não é necessário adicionar os Fragments,
           pois o método da superclasse ".onCreate" já restaura as instâncias */
        if (isFirstCreatedActivity) {
            this.configureFragments();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void configureFragments() {
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(this.binding.activityMainFragmentToolbar.getId(), HomeToolbarFragment.newInstance())
                .replace(this.binding.activityMainFragmentHomepage.getId(), HomePageFragment.newInstance())
                .commit();
    }

}