package br.com.talk_and_show.fragments.hometoolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.talk_and_show.databinding.FragmentHomeToolbarBinding;

public class HomeToolbarFragment extends Fragment {
    FragmentHomeToolbarBinding binding;

    public static HomeToolbarFragment newInstance() {
        return new HomeToolbarFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentHomeToolbarBinding.inflate(getLayoutInflater(), container, false);

        getChildFragmentManager().beginTransaction()
                .add(this.binding.fragmentHomeToolbarFragmentProfilePicture.getId(), IconProfilePictureFragment.newInstance())
                .commit();

        return this.binding.getRoot();
    }
}