package me.darshpratap.coaster.models.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
        tableName = "content",
        foreignKeys = [ForeignKey(
                entity = Category::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("cat_id"),
                onDelete = CASCADE
        )]
)
data class Content(
        val title: String,
        val description: String,
        val displayValue: String?,
        val group: String,
        val scoreDisplayMode: String,
        val score: Double,
        val cat_id: Int?
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}