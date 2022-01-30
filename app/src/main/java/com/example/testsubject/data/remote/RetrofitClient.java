package com.example.testsubject.data.remote;

import static com.example.testsubject.BuildConfig.BASE_URL;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private OkHttpClient provideOkHttpClient() {
        return new OkHttpClient().newBuilder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(provideLoggingInterceptor())
                .build();
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public  RickAndMortyApi provideApi(){
        return retrofit.create(RickAndMortyApi.class);
    }

    private Interceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
