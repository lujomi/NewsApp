package com.example.luka.newsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ShowNewsActivity extends AppCompatActivity implements NewsContract.View{

    private TextView title;
    private TextView description;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news);

        title = findViewById(R.id.titleTextSecondActivity);
        description = findViewById(R.id.descriptionText);
        image = findViewById(R.id.imageNews);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        NewsPresenter presenter = new NewsPresenter(this);
        presenter.articleReceived((Article) intent.getParcelableExtra("article"));
    }

    @Override
    public void setTitle(String titleText) {
        title.setText(titleText);
    }

    @Override
    public void setDescription(String descriptionText) {
        description.setText(descriptionText);
    }

    @Override
    public void setImage(String urlImage) {
        Picasso.get().load(urlImage).fit().error(R.drawable.error_picture).into(image);
    }

    @Override
    public void setErrorImage() {
        Picasso.get().load(R.drawable.error_picture).fit().into(image);
    }
}
