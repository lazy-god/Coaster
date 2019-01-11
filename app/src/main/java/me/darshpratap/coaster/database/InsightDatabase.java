package me.darshpratap.coaster.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import me.darshpratap.coaster.database.dao.CategoryDao;
import me.darshpratap.coaster.database.dao.ContentDao;
import me.darshpratap.coaster.database.dao.ResponseDao;
import me.darshpratap.coaster.models.db.Category;
import me.darshpratap.coaster.models.db.Content;
import me.darshpratap.coaster.models.db.Response;

@Database(
        entities = {
                Response.class,
                Category.class,
                Content.class
        },
        version = 1
)
public abstract class InsightDatabase extends RoomDatabase {
    private static InsightDatabase instance;

    public abstract ResponseDao responseDao();
    public abstract CategoryDao categoryDao();
    public abstract ContentDao contentDao();

    public static synchronized InsightDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    InsightDatabase.class, "insight_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
