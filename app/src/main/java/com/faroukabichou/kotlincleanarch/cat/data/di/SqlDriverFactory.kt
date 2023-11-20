package com.faroukabichou.kotlincleanarch.cat.data.di

import com.faroukabichou.kotlincleanarch.cat.data.local.audio.CatDao
import com.faroukabichou.kotlincleanarch.cat.data.local.createDatabase
import com.faroukabichou.kotlincleanarch.cat.data.local.sqlDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    factory { sqlDriverFactory() }
    single { createDatabase(driver = get()) }
    single { CatDao(audioDatabase = get()) }
}