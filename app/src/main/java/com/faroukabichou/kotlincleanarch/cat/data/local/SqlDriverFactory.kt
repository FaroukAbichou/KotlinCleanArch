package com.faroukabichou.kotlincleanarch.cat.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.faroukabichou.kotlincleanarch.MyDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

fun Scope.sqlDriverFactory(): SqlDriver {
    return AndroidSqliteDriver(MyDatabase.Schema, androidContext(), "cat.db")
}
fun createDatabase(driver: SqlDriver): MyDatabase {
    return MyDatabase(
        driver = driver,
    )
}