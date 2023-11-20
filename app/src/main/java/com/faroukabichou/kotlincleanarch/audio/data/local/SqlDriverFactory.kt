package com.faroukabichou.kotlincleanarch.audio.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

fun Scope.sqlDriverFactory(): SqlDriver {
    return AndroidSqliteDriver(AudioDatabase.Schema, androidContext(), "audio.db")
}
fun createDatabase(driver: SqlDriver): AudioDatabase {
    val database = AudioDatabase(
        driver = driver,
    )

    return database
}