package com.faroukabichou.kotlincleanarch.home.di

import com.faroukabichou.kotlincleanarch.audio.data.remote.AudioClient
import com.faroukabichou.kotlincleanarch.audio.data.repository.AudioRepositoryImpl
import com.faroukabichou.kotlincleanarch.audio.domain.AudioRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module


val homeModule = module {
    single { AudioClient(get(named("NoAuth"))) }
    single<AudioRepository> { AudioRepositoryImpl(get(),get()) }
}