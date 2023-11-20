package com.faroukabichou.kotlincleanarch.cat.di

import com.faroukabichou.kotlincleanarch.cat.data.remote.CatClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val songModule = module {
    single { CatClient(get(named("Auth"))) }
}