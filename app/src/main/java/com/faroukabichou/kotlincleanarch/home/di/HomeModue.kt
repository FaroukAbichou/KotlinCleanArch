package com.faroukabichou.kotlincleanarch.home.di

import com.faroukabichou.kotlincleanarch.cat.data.remote.CatClient
import com.faroukabichou.kotlincleanarch.cat.data.repository.CatRepositoryImpl
import com.faroukabichou.kotlincleanarch.cat.domain.CatRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module


val homeModule = module {
    single { CatClient(get(named("NoAuth"))) }
    single<CatRepository> { CatRepositoryImpl(get(),get()) }
}