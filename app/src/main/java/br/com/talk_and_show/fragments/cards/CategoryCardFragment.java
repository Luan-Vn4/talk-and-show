package br.com.talk_and_show.fragments.cards;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.talk_and_show.R;
import br.com.talk_and_show.databinding.FragmentCategoryCardBinding;

public class CategoryCardFragment extends Fragment {
    FragmentCategoryCardBinding binding;

    public static CategoryCardFragment newInstance(String param1, String param2) {
        CategoryCardFragment fragment = new CategoryCardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentCategoryCardBinding.inflate(getLayoutInflater(), container, false);
        return this.binding.getRoot();
    }
}