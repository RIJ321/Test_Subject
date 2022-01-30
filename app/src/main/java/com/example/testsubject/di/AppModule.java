package com.example.testsubject.di;

import com.example.testsubject.data.remote.RetrofitClient;
import com.example.testsubject.data.remote.RickAndMortyApi;
import com.example.testsubject.data.repositories.MainRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    public static RickAndMortyApi provideApi() {
        return new RetrofitClient().provideApi();
    }

    @Provides
    public static MainRepository provideMainRepository(RickAndMortyApi api){
        return new MainRepository(api);
    }


}
