package me.darshpratap.coaster.database.repository

import android.app.Application
import me.darshpratap.coaster.database.InsightDatabase
import me.darshpratap.coaster.database.dao.CategoryDao
import me.darshpratap.coaster.models.db.Category

class CategoryRepository(val application: Application) {
    private var categorDao: CategoryDao? = InsightDatabase.getInstance(application.baseContext)?.categoryDao()

    fun insert(category: Category): Int? {
        return categorDao?.insert(category)?.toInt()
    }
}