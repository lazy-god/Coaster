package me.darshpratap.coaster.database.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import me.darshpratap.coaster.database.repository.HistoryRepository
import me.darshpratap.coaster.models.db.History

class HistoryViewModel(application: Application): AndroidViewModel(application) {
    private var historyRepository: HistoryRepository = HistoryRepository(application)

    fun insert(history: History): Int? {
        return historyRepository.insert(history)
    }

    fun getAllHistory(): LiveData<List<History>>? {
        return historyRepository.getAllHistory()
    }
}