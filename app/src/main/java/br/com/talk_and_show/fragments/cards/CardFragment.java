package br.com.talk_and_show.fragments.cards;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.talk_and_show.databinding.FragmentCardBinding;


public class CardFragment extends Fragment {

    FragmentCardBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentCardBinding.inflate(inflater, container, false);
        return this.binding.getRoot();
    }

}