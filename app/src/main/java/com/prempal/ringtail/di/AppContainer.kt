package com.prempal.ringtail.di

import com.prempal.ringtail.data.ApiClient

/**
 * Created by prempal on 3/2/20.
 */
class AppContainer {

    val apiService = ApiClient.create("https://api.github.com/repos/facebook/react-native/pulls?state=closed")

}
