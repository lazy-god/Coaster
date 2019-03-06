package me.darshpratap.coaster.database.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import me.darshpratap.coaster.database.repository.ContentRepository
import me.darshpratap.coaster.models.db.Content

class ContentViewModel(application: Application): AndroidViewModel(application) {
    private var contentRepository: ContentRepository= ContentRepository(application)

    fun insert(content: Content) {
        contentRepository.insert(content)
    }

    fun getContentsForCategory(id: Int): List<Content>? {
        return contentRepository.getContentsForCategory(id)
    }
}