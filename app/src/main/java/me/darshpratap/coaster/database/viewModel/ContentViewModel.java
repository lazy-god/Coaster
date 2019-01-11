package me.darshpratap.coaster.database.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import me.darshpratap.coaster.database.repository.ContentRepository;
import me.darshpratap.coaster.models.db.Content;

public class ContentViewModel extends AndroidViewModel {
    private ContentRepository contentRepository;

    public ContentViewModel(@NonNull Application application) {
        super(application);
        contentRepository = new ContentRepository(application);
    }

    public void insert(Content content) {
        contentRepository.insert(content);
    }

    public void update(Content content) {
        contentRepository.update(content);
    }

    public void delete(Content content) {
        contentRepository.delete(content);
    }
}
