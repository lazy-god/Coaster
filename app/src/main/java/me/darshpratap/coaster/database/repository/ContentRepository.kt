package me.darshpratap.coaster.database.repository

import android.app.Application
import me.darshpratap.coaster.database.InsightDatabase
import me.darshpratap.coaster.database.dao.ContentDao
import me.darshpratap.coaster.models.db.Content

class ContentRepository(val application: Application) {
    private var contentDao: ContentDao? = InsightDatabase.getInstance(application.baseContext)?.contentDao()

    fun insert(content: Content){
        contentDao?.insert(content)
    }
}