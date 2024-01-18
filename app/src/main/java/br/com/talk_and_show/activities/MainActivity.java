package com.example.myapplication.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.fragments.cards.CardsRecyclerViewFragment;
import com.example.myapplication.fragments.cards.RecentCardRecyclerView;


import com.example.myapplication.fragments.homeToolbar.HomeToolbarFragment;


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