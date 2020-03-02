package com.prempal.ringtail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prempal.ringtail.data.ApiService
import com.prempal.ringtail.utils.Event
import com.prempal.ringtail.utils.coroutines.DispatcherProvider

/**
 * Created by prempal on 3/2/20.
 */
class MainViewModel(
    private val apiService: ApiService,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _toastEvent = MutableLiveData<Event<Int>>()
    val toastEvent: LiveData<Event<Int>> = _toastEvent

    init {

    }
}
