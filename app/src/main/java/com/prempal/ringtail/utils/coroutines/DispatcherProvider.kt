package com.prempal.ringtail.utils.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by prempal on 3/2/20.
 */
interface DispatcherProvider {
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}
