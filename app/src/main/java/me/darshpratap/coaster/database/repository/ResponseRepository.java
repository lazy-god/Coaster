package me.darshpratap.coaster.database.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import me.darshpratap.coaster.database.AsyncResponse;
import me.darshpratap.coaster.database.InsightDatabase;
import me.darshpratap.coaster.database.dao.ResponseDao;
import me.darshpratap.coaster.models.db.Response;

public class ResponseRepository  {
    private ResponseDao responseDao;
    private int id;

    public ResponseRepository(Application application) {
        InsightDatabase insightDatabase = InsightDatabase.getInstance(application);
        responseDao = insightDatabase.responseDao();
    }

    public void insert(Response response) {
        new InsertResponseAsyncTask(responseDao).execute(response);
    }

    public void update(Response response) {

    }

    public void delete(Response response) {

    }

    public LiveData<Integer> getId(String url) {
//        new GetIdAsyncTask(responseDao, this).execute(url);
        return responseDao.getId(url);
    }

//    @Override
//    public void getAsyncId(int id) {
//        this.id = id;
//    }

    private static class InsertResponseAsyncTask extends AsyncTask<Response, Void, Void> {
        private ResponseDao responseDao;
        private InsertResponseAsyncTask (ResponseDao responseDao) {
            this.responseDao = responseDao;
        }

        @Override
        protected Void doInBackground(Response... responses) {
            responseDao.insert(responses[0]);
            return null;
        }
    }

//    private static class GetIdAsyncTask extends AsyncTask<String, Void, Integer> {
//        private ResponseDao responseDao;
//        private ResponseRepository responseRepository;
//        private GetIdAsyncTask (ResponseDao responseDao, ResponseRepository responseRepository) {
//            this.responseDao = responseDao;
//            this.responseRepository = responseRepository;
//        }
//
//        @Override
//        protected Integer doInBackground(String... strings) {
//            return responseDao.getId(strings[0]);
//        }
//
//        @Override
//        protected void onPostExecute(Integer i) {
//            responseRepository.getAsyncId(i);
//            super.onPostExecute(i);
//        }
//    }
}
