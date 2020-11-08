package com.barisic.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.barisic.news.databinding.ArticleListItemBinding
import com.barisic.news.model.Article
import com.squareup.picasso.Picasso

class NewsRecyclerViewAdapter(
    private var articlesList: ArrayList<Article>,
    private val bottomWebViewUrl: MutableLiveData<String?>
) :
    RecyclerView.Adapter<NewsRecyclerViewAdapter.ArticleViewHolder>() {
    private lateinit var binding: ArticleListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ArticleListItemBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articlesList[position], bottomWebViewUrl)
    }

    override fun getItemCount(): Int = articlesList.count()

    class ArticleViewHolder(private val binding: ArticleListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article, bottomWebViewUrl: MutableLiveData<String?>) {
            binding.article = article
            binding.clArticle.setOnClickListener {
                bottomWebViewUrl.value = article.url
            }
            if (!article.urlToImage.isNullOrEmpty()) Picasso.get().load(article.urlToImage)
                .into(binding.articleImage)
        }
    }
}