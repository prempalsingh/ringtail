package com.prempal.ringtail.di

import com.prempal.ringtail.data.ApiClient
import com.prempal.ringtail.utils.coroutines.CoroutineDispatcherProvider

/**
 * Created by prempal on 3/2/20.
 */
class AppContainer {

    val apiService = ApiClient.create("https://api.github.com/repos/facebook/react-native/")

    val dispatcherProvider = CoroutineDispatcherProvider()
}
