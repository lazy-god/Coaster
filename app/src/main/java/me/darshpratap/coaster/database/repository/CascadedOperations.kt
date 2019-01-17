package me.darshpratap.coaster.database.repository

import android.app.Application
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import me.darshpratap.coaster.database.viewModel.ContentViewModel
import me.darshpratap.coaster.models.api.ResponsePojo
import me.darshpratap.coaster.models.db.Category
import me.darshpratap.coaster.models.db.Content
import me.darshpratap.coaster.models.db.History

object CascadedOperations {

    fun cascadedInsert(application: Application, url: String, strategy: String, response: ResponsePojo?) = runBlocking {
        val historyRepository = HistoryRepository(application)
        val categoryRepository = CategoryRepository(application)
        val contentRepository = ContentRepository(application)

        // insert response
        val responseId = withContext(Dispatchers.IO) { historyRepository.insert(History(url, strategy)) }
        Log.d("shit", responseId.toString())

        // insert all categories
        val performanceId = withContext(Dispatchers.IO) { categoryRepository.insert(Category(response!!.performancePojo.title, response.performancePojo.score, responseId)) }
        val accessibilityId = withContext(Dispatchers.IO) { categoryRepository.insert(Category(response!!.accessibilityPojo.title, response.accessibilityPojo.score, responseId)) }
        val bestPracticesId = withContext(Dispatchers.IO) { categoryRepository.insert(Category(response!!.bestPracticesPojo.title, response.bestPracticesPojo.score, responseId)) }
        val pwaId = withContext(Dispatchers.IO) { categoryRepository.insert(Category(response!!.pwaPojo.title, response.pwaPojo.score, responseId)) }
        val seoId = withContext(Dispatchers.IO) { categoryRepository.insert(Category(response!!.seoPojo.title, response.seoPojo.score, responseId)) }

        // insert all contents per category
        // 1 -> performance
        val performanceContent = response!!.performancePojo.contentPojo
        for (content in performanceContent) {
            withContext(Dispatchers.IO) { contentRepository.insert(
                    Content(content.title, content.description, content.displayValue, content.group, content.scoreDisplayMode, content.score, performanceId)
            ) }
        }

        // 2 -> performance
        val accessibilityContent = response.accessibilityPojo.contentPojo
        for (content in accessibilityContent) {
            withContext(Dispatchers.IO) { contentRepository.insert(
                    Content(content.title, content.description, content.displayValue, content.group, content.scoreDisplayMode, content.score, accessibilityId)
            ) }
        }

        // 3 -> performance
        val bestPracticesContent = response.bestPracticesPojo.contentPojo
        for (content in bestPracticesContent) {
            withContext(Dispatchers.IO) { contentRepository.insert(
                    Content(content.title, content.description, content.displayValue, content.group, content.scoreDisplayMode, content.score, bestPracticesId)
            ) }
        }

        // 4 -> performance
        val pwaContent = response.pwaPojo.contentPojo
        for (content in pwaContent) {
            withContext(Dispatchers.IO) { contentRepository.insert(
                    Content(content.title, content.description, content.displayValue, content.group, content.scoreDisplayMode, content.score, pwaId)
            ) }
        }

        // 5 -> performance
        val seoContent = response.seoPojo.contentPojo
        for (content in seoContent) {
            withContext(Dispatchers.IO) { contentRepository.insert(
                    Content(content.title, content.description, content.displayValue, content.group, content.scoreDisplayMode, content.score, seoId)
            ) }
        }
    }
}