package me.darshpratap.coaster.database.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import me.darshpratap.coaster.database.repository.CategoryRepository;
import me.darshpratap.coaster.models.db.Category;

public class CategoryViewModel extends AndroidViewModel {
    private CategoryRepository categoryRepository;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        categoryRepository = new CategoryRepository(application);
    }

    public void insert(Category category) {
        categoryRepository.insert(category);
    }

    public void update(Category category) {
        categoryRepository.update(category);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
