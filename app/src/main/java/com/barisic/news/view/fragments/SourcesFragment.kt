package com.barisic.news.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.barisic.news.R
import com.barisic.news.adapter.SourcesRecyclerViewAdapter
import com.barisic.news.databinding.FragmentSourcesBinding
import com.barisic.news.model.Source
import com.barisic.news.viewmodel.SourcesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SourcesFragment : Fragment() {
    private lateinit var binding: FragmentSourcesBinding
    private val viewModel: SourcesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sources, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.sourcesViewModel = viewModel

        viewModel.sourcesResult.observe(viewLifecycleOwner, { sources ->
            sources.forEach {
                Timber.tag("SOURCES_RESPONSE").d("SOURCE -> ${it.name} ${it.url}")
            }
            sources?.let {
                setupRecyclerView(sources)
            }
        })
    }

    private fun setupRecyclerView(sources: ArrayList<Source>) {
        binding.rvSources.adapter = SourcesRecyclerViewAdapter(sources)
        binding.rvSources.setItemViewCacheSize(5)
        binding.rvSources.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}