package me.darshpratap.coaster.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import me.darshpratap.coaster.database.InsightDatabase
import me.darshpratap.coaster.database.dao.HistoryDao
import me.darshpratap.coaster.models.db.History

class HistoryRepository(val application: Application) {
    private var historyDao: HistoryDao? = InsightDatabase.getInstance(application.baseContext)?.historyDao()

    fun insert(history: History): Int? {
        return historyDao?.insert(history)?.toInt()
    }

    fun getAllHistory(): LiveData<List<History>>? {
        return historyDao?.getAllHistory()
    }
}