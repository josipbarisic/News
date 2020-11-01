package com.barisic.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisic.news.databinding.ArticleListItemBinding
import com.barisic.news.model.Article
import com.squareup.picasso.Picasso

class NewsRecyclerViewAdapter(private var articlesList: ArrayList<Article>) :
    RecyclerView.Adapter<NewsRecyclerViewAdapter.ArticleViewHolder>() {
    private lateinit var dataBinding: ArticleListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        dataBinding = ArticleListItemBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articlesList[position])
    }

    override fun getItemCount(): Int = articlesList.count()

    class ArticleViewHolder(private val binding: ArticleListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article

            if (!article.urlToImage.isNullOrEmpty()) Picasso.get().load(article.urlToImage)
                .into(binding.articleImage)
        }
    }
}