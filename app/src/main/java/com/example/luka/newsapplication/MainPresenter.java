package com.example.luka.newsapplication;

import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter implements MainContract.Presenter {
    private NewsApi newsApi;
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void initRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        newsApi = retrofit.create(NewsApi.class);
    }

    @Override
    public void sendRequest() {
        newsApi.getNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.body() != null)
                    view.setAdapter(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
               view.showErrorMessage(t.getMessage());
            }
        });
    }

    @Override
    public void articleClicked(Article article) {
        view.showNewsActivity(article);
    }
}
