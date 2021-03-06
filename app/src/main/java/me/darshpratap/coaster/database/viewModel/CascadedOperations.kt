package me.darshpratap.coaster.database.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import me.darshpratap.coaster.database.repository.CascadedOperations
import me.darshpratap.coaster.models.api.ResponsePojo
import me.darshpratap.coaster.models.db.HistoryWithCategory

class CascadedOperations {
    fun cascadedInsert(application: Application, url: String, strategy: String, response: ResponsePojo?) {
        CascadedOperations.cascadedInsert(application, url, strategy, response)
    }
}