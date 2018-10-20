package com.example.luka.newsapplication;

import java.util.List;
import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsResponse {

    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }
}

class Article implements Parcelable {

    private String title;
    private String description;
    private String urlToImage;
    private String author;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeString(this.title);
        dest.writeString(this.urlToImage);
        dest.writeString(this.author);

    }

    private Article(Parcel in) {
        description = in.readString();
        title = in.readString();
        urlToImage = in.readString();
        author = in.readString();
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {

        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }

    };
}

