package me.darshpratap.coaster.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import me.darshpratap.coaster.database.InsightDatabase;
import me.darshpratap.coaster.database.dao.ContentDao;
import me.darshpratap.coaster.models.db.Content;

public class ContentRepository {
    private ContentDao contentDao;

    public ContentRepository(Application application) {
        InsightDatabase insightDatabase = InsightDatabase.getInstance(application);
        contentDao = insightDatabase.contentDao();
    }

    public void insert(Content content) {
        new InsertContentAsyncTask(contentDao).execute(content);
    }

    public void update(Content content) {

    }

    public void delete(Content content) {

    }

    private static class InsertContentAsyncTask extends AsyncTask<Content, Void, Void> {
        private ContentDao contentDao;
        private InsertContentAsyncTask (ContentDao contentDao) {
            this.contentDao = contentDao;
        }

        @Override
        protected Void doInBackground(Content... contents) {
            contentDao.insert(contents[0]);
            return null;
        }
    }
}
