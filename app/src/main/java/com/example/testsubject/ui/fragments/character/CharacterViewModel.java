package com.example.testsubject.ui.fragments.character;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.testsubject.common.Resource;
import com.example.testsubject.data.models.Character;
import com.example.testsubject.data.models.RickAndMortyResponse;
import com.example.testsubject.data.repositories.MainRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CharacterViewModel extends ViewModel {

    private MainRepository repository;

    public LiveData<Resource<RickAndMortyResponse<Character>>> characterLiveData;

    @Inject
    public CharacterViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public void fetchCharacters() {
        characterLiveData = repository.getCharacters();
    }
}
