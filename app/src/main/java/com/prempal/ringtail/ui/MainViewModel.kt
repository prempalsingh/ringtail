package com.prempal.ringtail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prempal.ringtail.R
import com.prempal.ringtail.data.ApiService
import com.prempal.ringtail.data.PullRequest
import com.prempal.ringtail.utils.Event
import com.prempal.ringtail.utils.coroutines.DispatcherProvider
import kotlinx.coroutines.launch
import okhttp3.Headers

/**
 * Created by prempal on 3/2/20.
 */
class MainViewModel(
    private val apiService: ApiService,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _items = MutableLiveData<List<PullRequest>>()
    val items: LiveData<List<PullRequest>> = _items

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _toastEvent = MutableLiveData<Event<Int>>()
    val toastEvent: LiveData<Event<Int>> = _toastEvent

    private var page = 1
    private var loadMoreEnabled = false
    private var list = mutableListOf<PullRequest>()

    init {
        fetchPRs()
    }

    fun onLoadMore() {
        if (_loading.value !== null && _loading.value == false && loadMoreEnabled) fetchPRs()
    }

    private fun fetchPRs() {
        _loading.postValue(true)
        viewModelScope.launch(dispatcherProvider.default) {
            try {
                val response = apiService.getClosedPRs(page)
                val pullRequestsResponse = response.body()
                if (response.isSuccessful && pullRequestsResponse != null) {
                    checkPagination(response.headers())
                    list.addAll(pullRequestsResponse)
                    _items.postValue(list)
                } else {
                    _toastEvent.postValue(Event(R.string.error_fetching_prs))
                }
            } catch (e: Exception) {
                _toastEvent.postValue(Event(R.string.error_fetching_prs))
            } finally {
                _loading.postValue(false)
            }
        }
    }

    private fun checkPagination(headers: Headers) {
        if (headers.get("Link")?.contains("rel=\"next\"") == true) {
            page++
            loadMoreEnabled = true
        } else {
            loadMoreEnabled = false
        }
    }
}
