package com.prempal.ringtail.di

import androidx.lifecycle.ViewModelProvider
import com.prempal.ringtail.RingtailApplication
import com.prempal.ringtail.ui.MainActivity
import com.prempal.ringtail.ui.MainViewModel
import com.prempal.ringtail.ui.rv.PullRequestsAdapter
import com.prempal.ringtail.utils.ViewModelProviderFactory

/**
 * Created by prempal on 3/2/20.
 */
object ActivityComponent {

    fun inject(activity: MainActivity) {

        val appContainer = (activity.application as RingtailApplication).appContainer

        activity.viewModel = ViewModelProvider(
            activity,
            ViewModelProviderFactory(MainViewModel::class) {
                MainViewModel(
                    appContainer.apiService,
                    appContainer.dispatcherProvider
                )
            }).get(MainViewModel::class.java)

        activity.adapter = PullRequestsAdapter()
    }
}
