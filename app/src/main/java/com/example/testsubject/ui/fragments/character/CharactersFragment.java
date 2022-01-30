package com.example.testsubject.ui.fragments.character;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.testsubject.R;
import com.example.testsubject.core.BaseFragment;
import com.example.testsubject.data.models.Character;
import com.example.testsubject.databinding.FragmentCharactersBinding;
import com.example.testsubject.ui.fragments.character.character_list_adapter.CharacterListAdapter;
import com.example.testsubject.ui.fragments.character.character_list_adapter.OnCharacterItemClickListener;

public class CharactersFragment extends BaseFragment<FragmentCharactersBinding> {

    private CharacterListAdapter adapter;
    private CharacterViewModel viewModel;
    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new CharacterListAdapter();
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_activity_main);
    }

    @Override
    protected void setupUI() {
        binding.rvCharacters.setAdapter(adapter);
        adapter.setItemClickListener(new OnCharacterItemClickListener() {
            @Override
            public void inCharacterClick(Character character) {
                navController.navigate(
                        CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(
                                character.getId(),
                                character
                        )
                );
            }
        });
    }

    @Override
    protected void setupObservers() {
        viewModel.fetchCharacters();

        viewModel.characterLiveData.observe(getViewLifecycleOwner(), response -> {
            switch (response.status) {
                case LOADING:
                    binding.rvCharacters.setVisibility(View.INVISIBLE);
                    binding.progressbarCharacterList.setVisibility(View.VISIBLE);
                    break;
                case SUCCESS:
                    binding.progressbarCharacterList.setVisibility(View.GONE);
                    binding.rvCharacters.setVisibility(View.VISIBLE);
                    adapter.setList(response.data.getResults());
                    break;
                case ERROR:
                    binding.rvCharacters.setVisibility(View.GONE);
                    binding.progressbarCharacterList.setVisibility(View.GONE);
                    break;
            }
        });
    }

    @Override
    protected FragmentCharactersBinding bind() {
        return FragmentCharactersBinding.inflate(getLayoutInflater());
    }
}