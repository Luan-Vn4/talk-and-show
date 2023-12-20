package br.com.talk_and_show;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.talk_and_show.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Properties
    ActivityMainBinding binding;

    // LifeCycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}