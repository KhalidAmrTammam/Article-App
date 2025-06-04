package com.example.kmparticleapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform