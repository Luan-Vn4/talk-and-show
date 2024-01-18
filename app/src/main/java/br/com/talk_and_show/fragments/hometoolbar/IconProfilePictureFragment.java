package br.com.talk_and_show.fragments.hometoolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.talk_and_show.databinding.FragmentIconProfilePictureBinding;

public class IconProfilePictureFragment extends Fragment {
    FragmentIconProfilePictureBinding binding;

    public static IconProfilePictureFragment newInstance() {
        return new IconProfilePictureFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.binding = FragmentIconProfilePictureBinding.inflate(getLayoutInflater(), container, false);
        return this.binding.getRoot();
    }

}
