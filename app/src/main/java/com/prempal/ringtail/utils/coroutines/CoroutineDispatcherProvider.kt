package com.prempal.ringtail.utils.coroutines

import kotlinx.coroutines.Dispatchers

/**
 * Created by prempal on 3/2/20.
 */
class CoroutineDispatcherProvider : DispatcherProvider {
    override val default = Dispatchers.Default
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}
