package com.example.luka.newsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsAdapter.ArticleListener, MainContract.View {
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        presenter.initRetrofit();
        presenter.sendRequest();
    }

    @Override
    public void articleClicked(Article article) {
        presenter.articleClicked(article);
    }

    @Override
    public void setAdapter(List<Article> articles) {
        RecyclerView titleList = findViewById(R.id.titleList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        titleList.setLayoutManager(layoutManager);
        titleList.setAdapter(new NewsAdapter(articles, MainActivity.this));
    }

    @Override
    public void showNewsActivity(Article article) {
        Intent intent = new Intent(MainActivity.this, ShowNewsActivity.class);
        intent.putExtra("article", article);
        startActivity(intent);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
