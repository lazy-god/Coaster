package me.darshpratap.coaster.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import me.darshpratap.coaster.database.InsightDatabase;
import me.darshpratap.coaster.database.dao.CategoryDao;
import me.darshpratap.coaster.models.db.Category;

public class CategoryRepository {
    private CategoryDao categoryDao;

    public CategoryRepository(Application application) {
        InsightDatabase insightDatabase = InsightDatabase.getInstance(application);
        categoryDao = insightDatabase.categoryDao();
    }

    public void insert(Category category) {
        new InsertCategoryAsyncTask(categoryDao).execute(category);
    }

    public void update(Category category) {

    }

    public void delete(Category category) {

    }

    private static class InsertCategoryAsyncTask extends AsyncTask<Category, Void, Void> {
        private CategoryDao categoryDao;
        private InsertCategoryAsyncTask (CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insert(categories[0]);
            return null;
        }
    }
}
