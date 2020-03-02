package com.prempal.ringtail.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prempal.ringtail.R
import com.prempal.ringtail.di.ActivityComponent
import com.prempal.ringtail.ui.rv.PullRequestsAdapter

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    lateinit var adapter: PullRequestsAdapter

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progress_bar)
        ActivityComponent.inject(this)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                recyclerView.layoutManager?.run {
                    if (this is LinearLayoutManager
                        && itemCount > 0
                        && itemCount == findLastVisibleItemPosition() + 1
                    ) {
                        viewModel.onLoadMore()
                    }
                }
            }
        })
    }

    private fun setupObservers() {

        viewModel.items.observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.loading.observe(this, Observer {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.toastEvent.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                showToast(it)
            }
        })
    }

    private fun showToast(@StringRes int: Int) {
        Toast.makeText(this, getString(int), Toast.LENGTH_SHORT).show()
    }
}
