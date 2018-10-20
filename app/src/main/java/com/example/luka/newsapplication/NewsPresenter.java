package com.example.luka.newsapplication;

public class NewsPresenter implements NewsContract.Presenter {
    private NewsContract.View view;

    public NewsPresenter(NewsContract.View view) {
        this.view = view;
    }

    @Override
    public void articleReceived(Article article) {
        if (article.getTitle() == null) {
            view.setTitle("Without title");
        } else {
            view.setTitle(article.getTitle());
        }
        if (article.getDescription() == null) {
            view.setDescription("Without description");
        } else {
            view.setDescription(article.getDescription());
        }
        if (article.getUrlToImage() == null) {
            view.setErrorImage();

        } else {
            view.setImage(article.getUrlToImage());
        }
    }
}

