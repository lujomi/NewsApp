package com.example.luka.newsapplication;

import java.util.List;

public interface MainContract {
    interface View {
        void setAdapter(List<Article> articles);
        void showNewsActivity(Article article);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void initRetrofit();
        void sendRequest();
        void articleClicked(Article article);
    }
}
