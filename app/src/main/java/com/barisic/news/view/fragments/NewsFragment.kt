package com.barisic.news.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.barisic.news.R
import com.barisic.news.databinding.FragmentNewsBinding
import com.barisic.news.model.Article
import com.barisic.news.viewmodel.NewsViewModel
import timber.log.Timber

class NewsFragment : Fragment() {
    private lateinit var dataBinding: FragmentNewsBinding
    private val viewModel: NewsViewModel by activityViewModels()

    private val resultObserver = Observer<ArrayList<Article>> {
        it?.let {
            Timber.d("ARTICLE URL -> ${it[0].url}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.newsViewModel = viewModel

        return dataBinding.root
    }

    override fun onResume() {
        super.onResume()
        if (!viewModel.result.hasObservers()) viewModel.result.observe(
            viewLifecycleOwner,
            resultObserver
        )
    }

    override fun onPause() {
        super.onPause()
        viewModel.result.removeObservers(viewLifecycleOwner)
    }
}