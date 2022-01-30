package com.example.testsubject.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.testsubject.common.Resource;
import com.example.testsubject.data.models.Character;
import com.example.testsubject.data.models.RickAndMortyResponse;
import com.example.testsubject.data.remote.RickAndMortyApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainRepository {

    private final RickAndMortyApi api;

    @Inject
    public MainRepository(RickAndMortyApi api) {
        this.api = api;
    }

    public MutableLiveData<Resource<RickAndMortyResponse<Character>>> getCharacters() {
        MutableLiveData<Resource<RickAndMortyResponse<Character>>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        api.getCharacters().enqueue(new Callback<RickAndMortyResponse<Character>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Character>> call, Response<RickAndMortyResponse<Character>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Character>> call, Throwable t) {

            }
        });
        return liveData;
    }

}
