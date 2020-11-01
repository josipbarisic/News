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
import timber.log.Timber

class NewsFragment : Fragment() {
    private lateinit var dataBinding: FragmentNewsBinding
    private val viewModel: NewsViewModel by activityViewModels()

    private val resultObserver = Observer<ArrayList<Article>> {
        it?.let {
            if (dataBinding.rvNews.adapter == null)
                setupRecyclerView(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)

        Timber.d("onCreateView")

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.newsViewModel = viewModel
        Timber.d("onViewCreated")
        viewModel.result.observe(viewLifecycleOwner, resultObserver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause")
//        viewModel.result.removeObservers(viewLifecycleOwner)
    }

    private fun setupRecyclerView(news: ArrayList<Article>) {
        Timber.d("setupRecyclerView")
        dataBinding.rvNews.adapter = NewsRecyclerViewAdapter(news)
        dataBinding.rvNews.setItemViewCacheSize(5)
        dataBinding.rvNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}