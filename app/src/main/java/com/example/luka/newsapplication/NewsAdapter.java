package com.example.luka.newsapplication;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<Article> articles;
    private ArticleListener listener;

    public NewsAdapter(List<Article> articles, ArticleListener listener) {
        this.articles = articles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, final int position) {
        final Article article = articles.get(position);
        newsViewHolder.title.setText(article.getTitle());
        newsViewHolder.author.setText(article.getAuthor());

        newsViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.articleClicked(article);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView author;
        private ConstraintLayout layout;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            author=itemView.findViewById(R.id.authorText);
            layout = itemView.findViewById(R.id.newsItemLayout);
        }
    }

    public interface ArticleListener {
        void articleClicked(Article article);
    }
}

