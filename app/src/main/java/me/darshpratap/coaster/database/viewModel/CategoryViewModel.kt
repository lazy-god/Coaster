package me.darshpratap.coaster.database.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import me.darshpratap.coaster.database.repository.CategoryRepository
import me.darshpratap.coaster.models.db.Category

class CategoryViewModel(application: Application): AndroidViewModel(application) {
    private var categoryRepository: CategoryRepository = CategoryRepository(application)

    fun insert(category: Category): Int? {
        return categoryRepository.insert(category)
    }
}