package com.faroukabichou.kotlincleanarch.audio.data.di

import com.faroukabichou.kotlincleanarch.audio.data.local.audio.AudioDao
import com.faroukabichou.kotlincleanarch.audio.data.local.createDatabase
import com.faroukabichou.kotlincleanarch.audio.data.local.sqlDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    factory { sqlDriverFactory() }
    single { createDatabase(driver = get()) }
    single { AudioDao(audioDatabase = get()) }
}