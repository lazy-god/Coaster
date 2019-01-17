package me.darshpratap.coaster.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
        val url: String,
        val strategy: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}