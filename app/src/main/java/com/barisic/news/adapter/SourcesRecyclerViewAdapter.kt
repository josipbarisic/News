package com.barisic.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisic.news.databinding.SourceListItemBinding
import com.barisic.news.model.Source
import com.barisic.news.util.LOGO_SCRAPER
import com.squareup.picasso.Picasso

class SourcesRecyclerViewAdapter(private val sourcesList: ArrayList<Source>) :
    RecyclerView.Adapter<SourcesRecyclerViewAdapter.SourcesViewHolder>() {
    private lateinit var binding: SourceListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = SourceListItemBinding.inflate(inflater, parent, false)
        return SourcesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        holder.bind(sourcesList[position])
    }

    override fun getItemCount(): Int {
        return sourcesList.count()
    }

    class SourcesViewHolder(private val binding: SourceListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(source: Source) {
            binding.source = source
            Picasso.get().load(LOGO_SCRAPER + source.url).into(binding.sourceLogo)
        }
    }
}