package com.example.testsubject.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Resource<T> {

    @NonNull
    public final Status status;
    public T data;
    public String message;

    public Resource(@NonNull Status status, T data, String message) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> loading() {
        return new Resource<>(Status.LOADING, null, null);
    }

    public static <T> Resource<T> error(String message, @Nullable T data) {
        return new Resource<>(Status.ERROR, data, message);
    }

    public enum Status {
        SUCCESS,
        LOADING,
        ERROR
    }

}
