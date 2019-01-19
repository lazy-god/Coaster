package me.darshpratap.coaster.database.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import me.darshpratap.coaster.database.repository.HistoryWithCategoryRepository
import me.darshpratap.coaster.models.db.HistoryWithCategory

class HistoryWithCategoryViewModel(application: Application): AndroidViewModel(application) {
    private val historyWithCategoryRepository = HistoryWithCategoryRepository(application)

    fun getHistoryWithCategory(): LiveData<List<HistoryWithCategory>>? {
        return historyWithCategoryRepository.getHistoryWithCategory()
    }
}