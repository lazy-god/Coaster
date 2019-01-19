package me.darshpratap.coaster.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import me.darshpratap.coaster.database.InsightDatabase
import me.darshpratap.coaster.database.dao.HistoryWithCategoryDao
import me.darshpratap.coaster.models.db.HistoryWithCategory as HistoryWithCategoryDB

class HistoryWithCategoryRepository(val application: Application) {
    private var historyWithCategoryDaoDao: HistoryWithCategoryDao? = InsightDatabase.getInstance(application.baseContext)?.historyWithCategoryDao()

    fun getHistoryWithCategory(): LiveData<List<HistoryWithCategoryDB>>? {
        return historyWithCategoryDaoDao?.getHistory()
    }
}