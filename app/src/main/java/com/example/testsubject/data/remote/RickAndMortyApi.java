package com.example.testsubject.data.remote;

import com.example.testsubject.data.models.Character;
import com.example.testsubject.data.models.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RickAndMortyApi {

    @GET("character")
    Call<RickAndMortyResponse<Character>> getCharacters();

}
