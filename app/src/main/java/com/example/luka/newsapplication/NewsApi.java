package com.example.luka.newsapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("v2/top-headlines?category=technology&country=us&apiKey=14617cfc936e4cec93e61065b221b4fc")
    Call<NewsResponse> getNews();
}
