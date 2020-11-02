package com.barisic.news.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.barisic.news.R
import com.barisic.news.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val newsViewModel: NewsViewModel by viewModel()
    private lateinit var navController: NavController
    private val bottomWebViewObserver = Observer<String?> {
        if (!it.isNullOrEmpty()) navController.navigate(R.id.action_nav_news_to_nav_bottom_web_view_dialog)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
        bottom_navigation.setupWithNavController(navController)
        bottom_navigation.itemIconTintList = null
        newsViewModel.bottomWebViewUrl.observe(this, bottomWebViewObserver)
    }
}