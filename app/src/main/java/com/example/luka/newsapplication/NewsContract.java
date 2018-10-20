package com.example.luka.newsapplication;

public interface NewsContract {
    interface View {
        void setTitle(String titleText);
        void setDescription(String descriptionText);
        void setImage(String urlImage);
        void setErrorImage();
    }

    interface Presenter {
        void articleReceived(Article article);
    }
}
