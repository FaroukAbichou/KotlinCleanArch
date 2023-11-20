package com.faroukabichou.kotlincleanarch.core.di

import com.faroukabichou.kotlincleanarch.core.network.networkModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration) = run {
    startKoin {
        appDeclaration()
        modules(
            networkModule,
        )
    }
}

