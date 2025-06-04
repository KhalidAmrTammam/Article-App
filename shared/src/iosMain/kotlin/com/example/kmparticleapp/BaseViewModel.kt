package com.example.kmparticleapp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

actual open class BaseViewModel{
    actual val scope = CoroutineScope(Dispatchers.Main)

    fun clear(){
        scope.cancel()
    }
}