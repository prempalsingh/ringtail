package com.prempal.ringtail.ui

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.prempal.ringtail.R
import com.prempal.ringtail.di.ActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityComponent.inject(this)
        setupObservers()
    }

    private fun setupObservers() {

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
