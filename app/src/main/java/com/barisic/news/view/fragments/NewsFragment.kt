package com.barisic.news.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.barisic.news.R
import com.barisic.news.adapter.NewsRecyclerViewAdapter
import com.barisic.news.databinding.FragmentNewsBinding
import com.barisic.news.model.Article
import com.barisic.news.viewmodel.NewsViewModel

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by activityViewModels()

    private val resultObserver = Observer<ArrayList<Article>> {
        it?.let {
            if (binding.rvNews.adapter == null) setupRecyclerView(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.newsViewModel = viewModel

        viewModel.result.observe(viewLifecycleOwner, resultObserver)
    }

    private fun setupRecyclerView(news: ArrayList<Article>) {
        binding.rvNews.adapter = NewsRecyclerViewAdapter(news, viewModel.bottomWebViewUrl)
        binding.rvNews.setItemViewCacheSize(5)
        binding.rvNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}