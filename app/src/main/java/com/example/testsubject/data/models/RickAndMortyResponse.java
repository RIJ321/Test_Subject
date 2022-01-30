
package com.example.testsubject.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RickAndMortyResponse<T> {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<T> results = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

}
