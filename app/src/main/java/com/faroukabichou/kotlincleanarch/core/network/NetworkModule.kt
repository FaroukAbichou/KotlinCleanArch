package com.faroukabichou.kotlincleanarch.core.network

import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("NoAuth")) { createNoAuthHttpClient() }
}