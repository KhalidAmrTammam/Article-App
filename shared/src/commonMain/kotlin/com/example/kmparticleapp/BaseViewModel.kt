package com.example.kmparticleapp

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel(){
    val scope: CoroutineScope
}