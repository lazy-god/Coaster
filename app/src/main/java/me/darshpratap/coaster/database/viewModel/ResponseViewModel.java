package me.darshpratap.coaster.database.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import me.darshpratap.coaster.database.repository.ResponseRepository;
import me.darshpratap.coaster.models.db.Response;

public class ResponseViewModel extends AndroidViewModel {
    private ResponseRepository responseRepository;

    public ResponseViewModel(@NonNull Application application) {
        super(application);
        responseRepository = new ResponseRepository(application);
    }

    public void insert(Response response) {
        responseRepository.insert(response);
    }

    public void update(Response response) {
        responseRepository.update(response);
    }

    public void delete(Response response) {
        responseRepository.delete(response);
    }

    public LiveData<Integer> getId(String url) {
        return responseRepository.getId(url);
    }
}
