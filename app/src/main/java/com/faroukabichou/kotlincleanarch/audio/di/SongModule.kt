package com.faroukabichou.kotlincleanarch.audio.di

import com.faroukabichou.kotlincleanarch.audio.data.remote.AudioClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val songModule = module {
    single { AudioClient(get(named("Auth"))) }
}