package com.example.kmparticleapp.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import sqldelight.articles.db.ArticlesDatabase

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = ArticlesDatabase.Schema,
            context = context,
            name = "ArticlesDatabase.database.db"
        )
}