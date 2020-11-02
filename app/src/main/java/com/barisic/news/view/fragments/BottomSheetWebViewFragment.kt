package com.barisic.news.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.barisic.news.R
import com.barisic.news.databinding.BottomSheetWebViewDialogBinding
import com.barisic.news.viewmodel.NewsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_web_view_dialog.*

class BottomSheetWebViewFragment : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetWebViewDialogBinding
    private val viewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.bottom_sheet_web_view_dialog,
            container,
            false
        )
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.newsViewModel = viewModel

        web_view.loadUrl(viewModel.bottomWebViewUrl.value)
        web_view.settings.javaScriptEnabled = true
        web_view.settings.allowContentAccess = true
        web_view.canGoBack()
        web_view.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK
                && event.action == MotionEvent.ACTION_UP
                && web_view.canGoBack()
            ) {
                web_view.goBack()
            }
            return@setOnKeyListener true
        }

        web_view.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                viewModel.showArticleContent.value = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.showArticleContent.value = false
        viewModel.bottomWebViewUrl.value = null
    }
}